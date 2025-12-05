package com.sopadeletras.player.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.sopadeletras.player.dto.score.ScoreMessage;
import com.sopadeletras.player.dto.score.ScoreResponse;
import com.sopadeletras.player.service.IPlayerService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ScoreController {

    private final IPlayerService playerService;

    @MessageMapping("/score")  // El mismo destino que envías desde Angular
    @SendTo("/list/score")     // El mismo topic al que Angular se suscribe
    public ScoreResponse processScore(ScoreMessage message) {
        System.out.println("Mensaje recibido desde Angular: " + message.name() + ", Score: " + message.score() + ", Time: " + message.time());

        return playerService.savePlayer(message);
    }
}