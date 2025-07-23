package org.example.telegrambot.dto;

import lombok.Data;

@Data
public class Chat {
    private Long id;
    private String first_name;
    private String last_name;
    private String username;
    private String type;
}