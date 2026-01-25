package net.ellise.backend.io.converter;

import net.ellise.backend.io.BoardPiece;
import net.ellise.backend.model.ChessBoard;
import net.ellise.backend.model.ChessBoardVisitor;
import net.ellise.backend.model.Point;
import net.ellise.backend.model.Token;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChessBoardToBoardConverter implements Converter<ChessBoard, List<BoardPiece>> {

    private static class ConverterChessBoardVisitor implements ChessBoardVisitor {
        private List<BoardPiece> pieces = new ArrayList<>();

        @Override
        public void visit(Point point, Token token) {
            pieces.add(new BoardPiece(point.x(), point.y(), token.colour(), token.type()));
        }

        private List<BoardPiece> getPieces() {
            return pieces;
        }
    }

    @Override
    public List<BoardPiece> convert(ChessBoard input) {
        ConverterChessBoardVisitor visitor = new ConverterChessBoardVisitor();
        input.visitAll(visitor);
        return visitor.getPieces();
    }
}
