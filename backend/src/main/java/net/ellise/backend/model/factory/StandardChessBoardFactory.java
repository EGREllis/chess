package net.ellise.backend.model.factory;

import net.ellise.backend.model.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StandardChessBoardFactory implements ChessBoardFactory {

    @Override
    public ChessBoard newBoard() {
        Map<Point, Token> tokens = new HashMap<>();
        tokens.put(new Point(0,0), new Token(Colour.BLACK, Type.ROOK));
        tokens.put(new Point(1,0), new Token(Colour.BLACK, Type.KNIGHT));
        tokens.put(new Point(2,0), new Token(Colour.BLACK, Type.BISHOP));
        tokens.put(new Point(3,0), new Token(Colour.BLACK, Type.KING));
        tokens.put(new Point(4,0), new Token(Colour.BLACK, Type.QUEEN));
        tokens.put(new Point(5,0), new Token(Colour.BLACK, Type.BISHOP));
        tokens.put(new Point(6,0), new Token(Colour.BLACK, Type.KNIGHT));
        tokens.put(new Point(7,0), new Token(Colour.BLACK, Type.ROOK));
        tokens.put(new Point(0,1), new Token(Colour.BLACK, Type.PAWN));
        tokens.put(new Point(1,1), new Token(Colour.BLACK, Type.PAWN));
        tokens.put(new Point(2,1), new Token(Colour.BLACK, Type.PAWN));
        tokens.put(new Point(3,1), new Token(Colour.BLACK, Type.PAWN));
        tokens.put(new Point(4,1), new Token(Colour.BLACK, Type.PAWN));
        tokens.put(new Point(5,1), new Token(Colour.BLACK, Type.PAWN));
        tokens.put(new Point(6,1), new Token(Colour.BLACK, Type.PAWN));
        tokens.put(new Point(7,1), new Token(Colour.BLACK, Type.PAWN));

        tokens.put(new Point(0,6), new Token(Colour.WHITE, Type.PAWN));
        tokens.put(new Point(1,6), new Token(Colour.WHITE, Type.PAWN));
        tokens.put(new Point(2,6), new Token(Colour.WHITE, Type.PAWN));
        tokens.put(new Point(3,6), new Token(Colour.WHITE, Type.PAWN));
        tokens.put(new Point(4,6), new Token(Colour.WHITE, Type.PAWN));
        tokens.put(new Point(5,6), new Token(Colour.WHITE, Type.PAWN));
        tokens.put(new Point(6,6), new Token(Colour.WHITE, Type.PAWN));
        tokens.put(new Point(7,6), new Token(Colour.WHITE, Type.PAWN));
        tokens.put(new Point(0,7), new Token(Colour.WHITE, Type.ROOK));
        tokens.put(new Point(1,7), new Token(Colour.WHITE, Type.KNIGHT));
        tokens.put(new Point(2,7), new Token(Colour.WHITE, Type.BISHOP));
        tokens.put(new Point(3,7), new Token(Colour.WHITE, Type.KING));
        tokens.put(new Point(4,7), new Token(Colour.WHITE, Type.QUEEN));
        tokens.put(new Point(5,7), new Token(Colour.WHITE, Type.BISHOP));
        tokens.put(new Point(6,7), new Token(Colour.WHITE, Type.KNIGHT));
        tokens.put(new Point(7,7), new Token(Colour.WHITE, Type.ROOK));

        return new ChessBoard(tokens);
    }
}
