package com.sopadeletras.player.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopadeletras.player.dto.score.ScoreResponse;
import com.sopadeletras.player.service.IPlayerService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/ranking")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class RankingController {

    private final IPlayerService playerService;
    
    @GetMapping("/position")
    public List<ScoreResponse> getRanking() {
        return playerService.getRankingList();
    }
    
}
