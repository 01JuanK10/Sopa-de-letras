package com.sopadeletras.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopadeletras.player.entity.Player;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Long> {}

