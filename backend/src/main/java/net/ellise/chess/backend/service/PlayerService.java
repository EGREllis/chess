package net.ellise.chess.backend.service;

import net.ellise.chess.backend.domain.Player;

import java.util.List;

public interface PlayerService {
    Player registerPlayer(String playerName);
    List<Player> listPlayers();
}
