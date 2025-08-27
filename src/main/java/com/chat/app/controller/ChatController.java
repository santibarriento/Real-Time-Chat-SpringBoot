package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    // Endpoint para recibir mensajes desde el cliente
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(@org.springframework.messaging.handler.annotation.Payload ChatMessage message) {
        return message;
    }

    // Endpoint para servir la vista del chat
    @GetMapping({"/", "/chat"})
    public String chat() {
        return "chat"; // Thymeleaf buscará chat.html en src/main/resources/templates
    }
}
