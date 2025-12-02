package com.sopadeletras.player.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ScoreController {

    @MessageMapping("/score")  // El mismo destino que envías desde Angular
    @SendTo("/list/score")     // El mismo topic al que Angular se suscribe
    public ScoreResponse processScore(ScoreMessage message) {
        System.out.println("Mensaje recibido desde Angular: " + message.getMessage());

        // Retorno al cliente
        return new ScoreResponse("Hola Angular, recibí tu mensaje: " + message.getMessage());
    }

    // Clases DTO
    public static class ScoreMessage {
        private String message;
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }

    public static class ScoreResponse {
        private String message;
        public ScoreResponse(String message) { this.message = message; }
        public String getMessage() { return message; }
    }
}