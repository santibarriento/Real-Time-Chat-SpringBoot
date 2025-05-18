package com.chat.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatMessage {
private String sender;
private String content;
private Long id;
}
