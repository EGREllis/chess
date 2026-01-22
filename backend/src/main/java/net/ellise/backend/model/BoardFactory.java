package net.ellise.backend.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BoardFactory {
    public Board newBoard() {
        List<Piece> startingPieces = List.of(
                new Piece(0,0, Colour.BLACK, Type.ROOK),
                new Piece(1,0, Colour.BLACK, Type.KNIGHT),
                new Piece(2,0, Colour.BLACK, Type.BISHOP),
                new Piece(3,0, Colour.BLACK, Type.KING),
                new Piece(4,0, Colour.BLACK, Type.QUEEN),
                new Piece(5,0, Colour.BLACK, Type.BISHOP),
                new Piece(6,0, Colour.BLACK, Type.KNIGHT),
                new Piece(7,0, Colour.BLACK, Type.ROOK),

                new Piece(0,1, Colour.BLACK, Type.PAWN),
                new Piece(1,1, Colour.BLACK, Type.PAWN),
                new Piece(2,1, Colour.BLACK, Type.PAWN),
                new Piece(3,1, Colour.BLACK, Type.PAWN),
                new Piece(4,1, Colour.BLACK, Type.PAWN),
                new Piece(5,1, Colour.BLACK, Type.PAWN),
                new Piece(6,1, Colour.BLACK, Type.PAWN),
                new Piece(7,1, Colour.BLACK, Type.PAWN),

                new Piece(0,6, Colour.WHITE, Type.PAWN),
                new Piece(1,6, Colour.WHITE, Type.PAWN),
                new Piece(2,6, Colour.WHITE, Type.PAWN),
                new Piece(3,6, Colour.WHITE, Type.PAWN),
                new Piece(4,6, Colour.WHITE, Type.PAWN),
                new Piece(5,6, Colour.WHITE, Type.PAWN),
                new Piece(6,6, Colour.WHITE, Type.PAWN),
                new Piece(7,6, Colour.WHITE, Type.PAWN),

                new Piece(0,7, Colour.WHITE, Type.ROOK),
                new Piece(1,7, Colour.WHITE, Type.KNIGHT),
                new Piece(2,7, Colour.WHITE, Type.BISHOP),
                new Piece(3,7, Colour.WHITE, Type.KING),
                new Piece(4,7, Colour.WHITE, Type.QUEEN),
                new Piece(5,7, Colour.WHITE, Type.BISHOP),
                new Piece(6,7, Colour.WHITE, Type.KNIGHT),
                new Piece(7,7, Colour.WHITE, Type.ROOK)
        );
        return new Board(Colour.BLACK, null, startingPieces);
    }
}
