package com.sopadeletras.player.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.sopadeletras.player.dto.score.ScoreMessage;
import com.sopadeletras.player.dto.score.ScoreResponse;

@Controller
public class ScoreController {

    @MessageMapping("/score")  // El mismo destino que envías desde Angular
    @SendTo("/list/score")     // El mismo topic al que Angular se suscribe
    public ScoreResponse processScore(ScoreMessage message) {
        System.out.println("Mensaje recibido desde Angular: " + message.message());

        return new ScoreResponse("Hola Angular, recibí tu mensaje: " + message.message());
    }
}