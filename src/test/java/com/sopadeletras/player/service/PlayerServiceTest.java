package com.sopadeletras.player.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.sopadeletras.player.dto.score.ScoreMessage;
import com.sopadeletras.player.dto.score.ScoreResponse;
import com.sopadeletras.player.entity.Player;
import com.sopadeletras.player.repository.IPlayerRepository;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class PlayerServiceTest {

    @Mock
    private IPlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    // -----------------------------
    //   GET RANKING LIST
    // -----------------------------
    @Test
    void testGetRankingList_ReturnsListOfScores() {

        Player p1 = new Player(1L, "Juan", 120, 30);
        Player p2 = new Player(2L, "Maria", 150, 25);

        when(playerRepository.findAll()).thenReturn(List.of(p1, p2));

        List<ScoreResponse> result = playerService.getRankingList();

        assertEquals(2, result.size());
        assertEquals("Juan", result.get(0).name());
        assertEquals("Maria", result.get(1).name());
    }

    // -----------------------------
    //   SAVE PLAYER
    // -----------------------------
    @Test
    void testSavePlayer_SavesAndReturnsScoreResponse() {

        ScoreMessage msg = new ScoreMessage("Pedro", 200, 40);

        Player saved = new Player(10L, "Pedro", 200, 40);

        //! IMPORTANTE: mockear save()
        when(playerRepository.save(any(Player.class))).thenReturn(saved);

        ScoreResponse response = playerService.savePlayer(msg);

        assertNotNull(response);
        assertEquals("Pedro", response.name());
        assertEquals(200, response.score());
        assertEquals(40, response.time());
    }
}
