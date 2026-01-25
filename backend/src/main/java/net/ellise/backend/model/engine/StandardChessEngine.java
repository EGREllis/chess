package net.ellise.backend.model.engine;

import net.ellise.backend.model.ChessBoard;
import net.ellise.backend.model.ChessEngine;
import net.ellise.backend.validator.ValidatedChessMove;
import org.springframework.stereotype.Component;

@Component
public class StandardChessEngine implements ChessEngine {
    @Override
    public ChessBoard applyMove(ValidatedChessMove chessMove, ChessBoard preMoveChessBoard) {
        return preMoveChessBoard.applyValidMove(chessMove.move());
    }
}
