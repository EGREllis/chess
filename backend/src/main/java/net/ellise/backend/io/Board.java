package net.ellise.backend.io;

import net.ellise.backend.model.Colour;
import net.ellise.backend.model.Validity;

import java.util.Collections;
import java.util.List;

public class Board {
    private final Colour turn;
    private final BoardPiece selected;
    private final List<BoardPiece> boardPieces;
    private final BoardMove lastBoardMove;
    private final Validity valid;
    private final String reason;

    public Board(Colour turn, BoardPiece selected, List<BoardPiece> boardPieces) {
        this(turn, selected, boardPieces, null, Validity.VALID, "");
    }

    public Board(Colour turn, BoardPiece selected, List<BoardPiece> boardPieces, BoardMove lastBoardMove, Validity valid, String reason) {
        this.turn = turn;
        this.selected = selected;
        this.boardPieces = boardPieces;
        this.lastBoardMove = lastBoardMove;
        this.valid = valid;
        this.reason = reason;
    }

    public Colour getTurn() {
        return turn;
    }

    public BoardPiece getSelected() {
        return selected;
    }

    public List<BoardPiece> getPieces() {
        return Collections.unmodifiableList(boardPieces);
    }

    public BoardMove getLastMove() { return this.lastBoardMove; }

    public Validity getValid() { return this.valid; }

    public String getReason() { return reason; }

    public Board invalidMove(BoardMove boardMove, String reason) {
        return new Board(turn, selected, boardPieces, boardMove, Validity.INVALID, reason);
    }
}
