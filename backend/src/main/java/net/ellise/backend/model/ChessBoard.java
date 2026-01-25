package net.ellise.backend.model;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ChessBoard {
    private final Colour turn;
    private final Map<Point, Token> piecePlacement;

    public ChessBoard(Colour turn, Map<Point, Token> piecePlacement) {
        this.turn = turn;
        this.piecePlacement = piecePlacement;
    }

    public Token get(Point point) {
        return piecePlacement.get(point);
    }

    public void visitAll(ChessBoardVisitor visitor) {
        for (Map.Entry<Point, Token> tokens : piecePlacement.entrySet()) {
            visitor.visit(tokens.getKey(), tokens.getValue());
        }
    }

    public Colour getTurn() {
        return turn;
    }

    public ChessBoard applyValidMove(ChessMove move) {
        log.info("Applying move {}", move);
        final Colour advancedTurn = turn.getEnemy();
        final Map<Point, Token> advancedPieces = new HashMap<>();
        for (Map.Entry<Point, Token> entry : piecePlacement.entrySet()) {
            Token token = entry.getValue();
            if (move.from().equals(entry.getKey())) {
                // This is the piece that is moving.
                advancedPieces.put(move.to(), token);
                log.info("Applying move");
            } else if (move.to().equals(entry.getKey())) {
                // This piece is taken, don't copy it
                log.info("Piece captured");
            } else {
                // No change to these pieces
                advancedPieces.put(entry.getKey(), entry.getValue());
            }
        }
        return new ChessBoard(advancedTurn, advancedPieces);
    }
}
