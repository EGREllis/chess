package net.ellise.chess.backend.repository;

import lombok.extern.slf4j.Slf4j;
import net.ellise.chess.backend.domain.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class HashMapPlayerRepository implements PlayerRepository {
    private final Map<String, Player> storage = new ConcurrentHashMap<>();

    @Override
    public boolean registerPlayer(String playerName) {
        Player player = storage.computeIfAbsent(playerName, (k) -> new Player(playerName));
        log.info("Registered player: "+playerName);
        return true;
    }

    @Override
    public Player getPlayer(String playerName) {
        log.info("Fetching player: "+playerName);
        return storage.get(playerName);
    }

    @Override
    public List<Player> getPlayers() {
        log.info("Fetching all players, {} entries", storage.size());
        return Collections.unmodifiableList(new ArrayList<>(storage.values()));
    }
}
