package net.ellise.chess.backend.response;

import lombok.Getter;
import net.ellise.chess.backend.domain.Player;

@Getter
public class PlayerResponse {
    private final String playerName;

    private PlayerResponse(String playerName) {
        this.playerName = playerName;
    }

    public static PlayerResponse from(Player player) {
        return new PlayerResponse(player.getName());
    }
}
