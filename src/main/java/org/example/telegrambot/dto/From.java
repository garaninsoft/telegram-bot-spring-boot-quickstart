package org.example.telegrambot.dto;

import lombok.Data;

@Data
public class From {
    private Long id;
    private Boolean is_bot;
    private String first_name;
    private String last_name;
    private String username;
    private String language_code;
}