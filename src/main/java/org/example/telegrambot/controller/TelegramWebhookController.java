package org.example.telegrambot.controller;

import org.example.telegrambot.dto.Update;
import org.example.telegrambot.service.TelegramService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class TelegramWebhookController {

    private final TelegramService telegramService;

    public TelegramWebhookController(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @PostMapping
    public ResponseEntity<?> onUpdateReceived(@RequestBody Update update) {
        telegramService.processUpdate(update);
        return ResponseEntity.ok().build();
    }
}
