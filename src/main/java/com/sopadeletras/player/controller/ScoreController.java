package com.sopadeletras.player.controller;

import com.sopadeletras.player.dto.MessageDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ScoreController {

    @MessageMapping("/score")
    public void getMessage(MessageDto message){
        System.out.println("mensaje recibido: " + message);
    }
}
