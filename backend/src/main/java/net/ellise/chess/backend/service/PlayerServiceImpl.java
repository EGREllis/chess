package net.ellise.chess.backend.service;

import net.ellise.chess.backend.domain.Player;
import net.ellise.chess.backend.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository repository;

    PlayerServiceImpl(PlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Player registerPlayer(String playerName) {
        repository.registerPlayer(playerName);
        return repository.getPlayer(playerName);
    }

    @Override
    public List<Player> listPlayers() {
        return repository.getPlayers();
    }
}
