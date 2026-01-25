package net.ellise.backend.io.converter;

import net.ellise.backend.io.Board;
import net.ellise.backend.io.BoardPiece;
import net.ellise.backend.model.ChessBoard;
import net.ellise.backend.model.Point;
import net.ellise.backend.model.Token;

import java.util.HashMap;
import java.util.Map;

public class BoardToChessBoardConverter implements Converter<Board, ChessBoard> {
    @Override
    public ChessBoard convert(Board input) {
        Map<Point, Token> pieces = new HashMap<>();
        for (BoardPiece boardPiece : input.getPieces()) {
            Point point = new Point(boardPiece.x(), boardPiece.y());
            pieces.put(point, new Token(boardPiece.colour(), boardPiece.type()));
        }
        return new ChessBoard(input.getTurn(), pieces);
    }
}
