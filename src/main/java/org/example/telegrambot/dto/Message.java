package org.example.telegrambot.dto;

import lombok.Data;

@Data
public class Message {
    private Long message_id;
    private From from;
    private Chat chat;
    private Long date;
    private String text;
}
