package org.example.telegrambot.client;

import org.example.telegrambot.dto.SendMessageRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TelegramClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String telegramApiUrl;

    public TelegramClient(@Value("${telegram.bot.token}") String botToken) {
        this.telegramApiUrl = "https://api.telegram.org/bot" + botToken + "/";
    }

    public void sendMessage(Long chatId, String text) {
        SendMessageRequest request = new SendMessageRequest(chatId, text);
        restTemplate.postForObject(telegramApiUrl + "sendMessage", request, String.class);
    }
}