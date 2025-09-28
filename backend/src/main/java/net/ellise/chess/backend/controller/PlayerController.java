package net.ellise.chess.backend.controller;

import lombok.extern.slf4j.Slf4j;
import net.ellise.chess.backend.domain.Player;
import net.ellise.chess.backend.request.RegisterRequest;
import net.ellise.chess.backend.response.ListPlayerResponse;
import net.ellise.chess.backend.response.PlayerResponse;
import net.ellise.chess.backend.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
class PlayerController {
    private final PlayerService playerService;

    PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/api/players")
    PlayerResponse registerNewUser(@RequestBody RegisterRequest request) {
        Player player = playerService.registerPlayer(request.getPlayerName());
        return PlayerResponse.from(player);
    }

    @GetMapping("/api/players")
    ListPlayerResponse listPlayers() {
        List<Player> players = playerService.listPlayers();
        return ListPlayerResponse.from(players);
    }
}
