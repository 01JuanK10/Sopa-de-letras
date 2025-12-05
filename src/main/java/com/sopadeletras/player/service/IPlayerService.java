package com.sopadeletras.player.service;

import java.util.List;

import com.sopadeletras.player.dto.score.ScoreMessage;
import com.sopadeletras.player.dto.score.ScoreResponse;

public interface IPlayerService {
    public List<ScoreResponse> getRankingList();
    public ScoreResponse savePlayer(ScoreMessage player);
}
