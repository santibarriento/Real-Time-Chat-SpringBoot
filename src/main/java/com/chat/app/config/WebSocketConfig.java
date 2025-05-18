package com.chat.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {// mantiene el canal abierto para chat

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
       registry.addEndpoint("/chat").setAllowedOriginPatterns("*").withSockJS(); // permite la conexión de clientes a través de SockJS
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // permite la comunicación entre clientes
        registry.setApplicationDestinationPrefixes("/app"); // prefijo para los mensajes enviados al servidor
    }

}

