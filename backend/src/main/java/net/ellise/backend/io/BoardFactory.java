package net.ellise.backend.io;

import net.ellise.backend.model.Colour;
import net.ellise.backend.model.Type;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BoardFactory {
    public Board newBoard() {
        List<BoardPiece> startingBoardPieces = List.of(
                new BoardPiece(0,0, Colour.BLACK, Type.ROOK),
                new BoardPiece(1,0, Colour.BLACK, Type.KNIGHT),
                new BoardPiece(2,0, Colour.BLACK, Type.BISHOP),
                new BoardPiece(3,0, Colour.BLACK, Type.KING),
                new BoardPiece(4,0, Colour.BLACK, Type.QUEEN),
                new BoardPiece(5,0, Colour.BLACK, Type.BISHOP),
                new BoardPiece(6,0, Colour.BLACK, Type.KNIGHT),
                new BoardPiece(7,0, Colour.BLACK, Type.ROOK),

                new BoardPiece(0,1, Colour.BLACK, Type.PAWN),
                new BoardPiece(1,1, Colour.BLACK, Type.PAWN),
                new BoardPiece(2,1, Colour.BLACK, Type.PAWN),
                new BoardPiece(3,1, Colour.BLACK, Type.PAWN),
                new BoardPiece(4,1, Colour.BLACK, Type.PAWN),
                new BoardPiece(5,1, Colour.BLACK, Type.PAWN),
                new BoardPiece(6,1, Colour.BLACK, Type.PAWN),
                new BoardPiece(7,1, Colour.BLACK, Type.PAWN),

                new BoardPiece(0,6, Colour.WHITE, Type.PAWN),
                new BoardPiece(1,6, Colour.WHITE, Type.PAWN),
                new BoardPiece(2,6, Colour.WHITE, Type.PAWN),
                new BoardPiece(3,6, Colour.WHITE, Type.PAWN),
                new BoardPiece(4,6, Colour.WHITE, Type.PAWN),
                new BoardPiece(5,6, Colour.WHITE, Type.PAWN),
                new BoardPiece(6,6, Colour.WHITE, Type.PAWN),
                new BoardPiece(7,6, Colour.WHITE, Type.PAWN),

                new BoardPiece(0,7, Colour.WHITE, Type.ROOK),
                new BoardPiece(1,7, Colour.WHITE, Type.KNIGHT),
                new BoardPiece(2,7, Colour.WHITE, Type.BISHOP),
                new BoardPiece(3,7, Colour.WHITE, Type.KING),
                new BoardPiece(4,7, Colour.WHITE, Type.QUEEN),
                new BoardPiece(5,7, Colour.WHITE, Type.BISHOP),
                new BoardPiece(6,7, Colour.WHITE, Type.KNIGHT),
                new BoardPiece(7,7, Colour.WHITE, Type.ROOK)
        );
        return new Board(Colour.BLACK, null, startingBoardPieces);
    }
}
