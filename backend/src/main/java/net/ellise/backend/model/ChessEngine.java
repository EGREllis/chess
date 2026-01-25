package net.ellise.backend.model;

import net.ellise.backend.validator.ValidatedChessMove;

public interface ChessEngine {
    ChessBoard applyMove(ValidatedChessMove chessMove, ChessBoard preMoveChessBoard);
}
