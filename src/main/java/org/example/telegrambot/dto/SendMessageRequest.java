package org.example.telegrambot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SendMessageRequest {

    @JsonProperty("chat_id")
    private Long chatId;

    private String text;

//    @JsonProperty("parse_mode")
//    private String parseMode = "Markdown"; // можно использовать "HTML" или null

    public SendMessageRequest(Long chatId, String text) {
        this.chatId = chatId;
        this.text = text;
    }
}
