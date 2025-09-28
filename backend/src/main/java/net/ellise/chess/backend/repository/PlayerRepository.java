package net.ellise.chess.backend.repository;

import net.ellise.chess.backend.domain.Player;

import java.util.List;

public interface PlayerRepository {
    boolean registerPlayer(String playerName);
    Player getPlayer(String playerName);
    List<Player> getPlayers();
}
