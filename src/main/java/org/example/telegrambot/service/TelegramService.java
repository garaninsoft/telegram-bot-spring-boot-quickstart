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
                    👋 Hi! I'm a calculator bot. 
                    Use the command: 
                    /calc 2 + 2
                    """);
        } else if (text.startsWith("/calc")) {
            String expression = text.replace("/calc", "").trim();
            try {
                double result = evaluate(expression);
                telegramClient.sendMessage(chatId, "Result: " + result);
            } catch (Exception e) {
                telegramClient.sendMessage(chatId, """
                        ❌ Calculation error. Make sure the format is correct:
                        Example: /calc 2 * 3
                        (spaces are required)
                        """);
            }
        } else {
            telegramClient.sendMessage(chatId, "🤖 Unknown command. Try /calc 2 + 2");
        }
    }

    private double evaluate(String expr) {
        String[] parts = expr.split(" ");
        if (parts.length != 3) throw new IllegalArgumentException("Invalid format");

        double a = Double.parseDouble(parts[0]);
        String op = parts[1];
        double b = Double.parseDouble(parts[2]);

        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) throw new ArithmeticException("Division by zero");
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Unknown operator: " + op);
        };
    }
}
