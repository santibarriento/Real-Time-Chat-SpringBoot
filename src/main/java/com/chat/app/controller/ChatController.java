package com.chat.app.controller;
import com.chat.app.model.ChatMessage;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ChatController {
    @MessageMapping("/sendMessage") // endpoint para recibir mensajes
    @SendTo("/topic/messages") // endpoint para enviar mensajes a todos los clientes suscritos
public ChatMessage sendMessage(@org.springframework.messaging.handler.annotation.Payload ChatMessage message) {
    return message;
}
@GetMapping("chat") // endpoint para recibir mensajes
public String chat(){
    return "chat"; // nombre de la vista HTML
}


}
