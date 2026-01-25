package net.ellise.backend.validator;

import net.ellise.backend.model.ChessBoard;
import net.ellise.backend.model.ChessMove;

public interface ChessMoveValidator {
    ValidatedChessMove validate(ChessMove move, ChessBoard chessBoard);
}
