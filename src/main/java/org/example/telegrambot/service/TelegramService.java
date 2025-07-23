package org.example.telegrambot.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.telegrambot.client.TelegramClient;
import org.example.telegrambot.dto.Message;
import org.example.telegrambot.dto.Update;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramService {

    private final TelegramClient telegramClient;

    public void processUpdate(Update update) {
        if (update.getMessage() != null) {
            Message message = update.getMessage();
            String text = message.getText();
            Long chatId = message.getChat().getId();
            String username = message.getFrom().getUsername();

            log.info("Received update: {}", update);
            log.info("Message from {}: {}", username, text);

            handleTextMessage(text, chatId);
        }
    }

    private void handleTextMessage(String text, Long chatId) {
        if (text.startsWith("/start")) {
            telegramClient.sendMessage(chatId, """
                    👋 Привет! Я бот-калькулятор.
                    Используй команду:
                    /calc 2 + 2
                    """);
        } else if (text.startsWith("/calc")) {
            String expression = text.replace("/calc", "").trim();
            try {
                double result = evaluate(expression);
                telegramClient.sendMessage(chatId, "Результат: " + result);
            } catch (Exception e) {
                telegramClient.sendMessage(chatId, """
                        ❌ Ошибка вычисления. Убедись, что формат правильный:
                        Пример: /calc 2 * 3
                        (пробелы обязательно)
                        """);
            }
        } else {
            telegramClient.sendMessage(chatId, "🤖 Неизвестная команда. Попробуй /calc 2 + 2");
        }
    }

    private double evaluate(String expr) {
        String[] parts = expr.split(" ");
        if (parts.length != 3) throw new IllegalArgumentException("Неверный формат");

        double a = Double.parseDouble(parts[0]);
        String op = parts[1];
        double b = Double.parseDouble(parts[2]);

        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) throw new ArithmeticException("Деление на ноль");
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Неизвестный оператор: " + op);
        };
    }
}
