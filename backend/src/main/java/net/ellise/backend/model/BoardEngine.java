package net.ellise.backend.model;

import org.springframework.stereotype.Component;

@Component
public class BoardEngine {
    private final BoardFactory boardFactory;

    public BoardEngine(BoardFactory boardFactory) {
        this.boardFactory = boardFactory;
    }

    public Board applyMove(Move move, Board board) {
        return boardFactory.newBoard();
    }
}
