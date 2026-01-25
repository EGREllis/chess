package net.ellise.backend.model;

import net.ellise.backend.validator.ValidatedChessMove;
import org.springframework.stereotype.Component;

@Component
public class NoMoveChessEngine implements ChessEngine {
    @Override
    public ChessBoard applyMove(ValidatedChessMove chessMove, ChessBoard preMoveChessBoard) {
        return preMoveChessBoard;
    }
}
