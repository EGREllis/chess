package net.ellise.backend.validator;

import net.ellise.backend.model.ChessBoard;
import net.ellise.backend.model.ChessMove;
import net.ellise.backend.model.Validity;

public class AlwaysValidChessMoveValidator implements ChessMoveValidator {
    @Override
    public ValidatedChessMove validate(ChessMove move, ChessBoard chessBoard) {
        return new ValidatedChessMove(move, Validity.VALID, "");
    }
}
