package net.ellise.chess.backend.response;

import lombok.Getter;
import net.ellise.chess.backend.domain.Player;

import java.util.List;

@Getter
public class ListPlayerResponse {
    private final List<PlayerResponse> players;

    private ListPlayerResponse(List<PlayerResponse> players) {
        this.players = players;
    }

    public static ListPlayerResponse from(List<Player> players) {
        List<PlayerResponse> responseList = players.stream().map(PlayerResponse::from).toList();
        return new ListPlayerResponse(responseList);
    }
}
