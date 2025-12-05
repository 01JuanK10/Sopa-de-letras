package com.sopadeletras.player.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sopadeletras.player.dto.score.ScoreMessage;
import com.sopadeletras.player.dto.score.ScoreResponse;
import com.sopadeletras.player.entity.Player;
import com.sopadeletras.player.repository.IPlayerRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class PlayerService implements IPlayerService {

    private final IPlayerRepository playerRepository;

    @Override
    public List<ScoreResponse> getRankingList() {
        return playerRepository.findAll().stream()
                .map(player -> new ScoreResponse(player.getName(), player.getScore(), player.getTime()))
                .toList();
    }

    @Override
    public ScoreResponse savePlayer(ScoreMessage player) {
        Player SavedPlayer = playerRepository.save(new Player(null, player.name(), player.score(), player.time()));
        ScoreResponse response = new ScoreResponse(SavedPlayer.getName(), SavedPlayer.getScore(), SavedPlayer.getTime());    
        return response;
    }

}
