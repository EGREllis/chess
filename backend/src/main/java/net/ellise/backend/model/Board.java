package net.ellise.backend.model;

import java.util.Collections;
import java.util.List;

public class Board {
    private final Colour turn;
    private final Piece selected;
    private final List<Piece> pieces;
    private final Move lastMove;
    private final Validity valid;
    private final String reason;

    public Board(Colour turn, Piece selected, List<Piece> pieces) {
        this(turn, selected, pieces, null, Validity.VALID, "");
    }

    public Board(Colour turn, Piece selected, List<Piece> pieces, Move lastMove, Validity valid, String reason) {
        this.turn = turn;
        this.selected = selected;
        this.pieces = pieces;
        this.lastMove = lastMove;
        this.valid = valid;
        this.reason = reason;
    }

    public Colour getTurn() {
        return turn;
    }

    public Piece getSelected() {
        return selected;
    }

    public List<Piece> getPieces() {
        return Collections.unmodifiableList(pieces);
    }

    public Move getLastMove() { return this.lastMove; }

    public Validity getValid() { return this.valid; }

    public String getReason() { return reason; }

    public Board invalidMove(Move move, String reason) {
        return new Board(turn, selected, pieces, move, Validity.INVALID, reason);
    }
}
