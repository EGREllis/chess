package net.ellise.backend.model;

import java.util.Collections;
import java.util.List;

public class Board {
    private final Colour turn;
    private final Piece selected;
    private final List<Piece> pieces;

    public Board(Colour turn, Piece selected, List<Piece> pieces) {
        this.turn = turn;
        this.selected = selected;
        this.pieces = pieces;
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
}
