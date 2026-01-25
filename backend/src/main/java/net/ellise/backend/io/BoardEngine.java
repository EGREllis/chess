package net.ellise.backend.io;

import org.springframework.stereotype.Component;

@Component
public class BoardEngine {
    private final BoardFactory boardFactory;

    public BoardEngine(BoardFactory boardFactory) {
        this.boardFactory = boardFactory;
    }

    public Board applyMove(BoardMove boardMove, Board board) {
        return boardFactory.newBoard();
    }
}
