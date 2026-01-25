package net.ellise.backend.model;

import java.util.Map;

public class ChessBoard {
    private final Map<Point, Token> piecePlacement;

    public ChessBoard(Map<Point, Token> piecePlacement) {
        this.piecePlacement = piecePlacement;
    }

    public Token get(Point point) {
        return piecePlacement.get(point);
    }

    public void add(Point point, Token token) {
        piecePlacement.put(point, token);
    }

    public void remove(Point point) {
        piecePlacement.remove(point);
    }
}
