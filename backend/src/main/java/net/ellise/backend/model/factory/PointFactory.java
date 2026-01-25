package net.ellise.backend.model.factory;

import net.ellise.backend.model.ChessBoard;
import net.ellise.backend.model.ChessMove;
import net.ellise.backend.model.Colour;
import net.ellise.backend.model.Point;

import java.util.Set;

public interface PointFactory {
    Set<Point> generateValidMoves(ChessMove move, ChessBoard chessBoard);
}
