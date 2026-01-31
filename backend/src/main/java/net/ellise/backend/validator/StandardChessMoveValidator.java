package net.ellise.backend.validator;

import net.ellise.backend.model.*;
import net.ellise.backend.model.factory.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StandardChessMoveValidator implements ChessMoveValidator {
    private static final Map<Type, PointFactory> VALIDATORS = new HashMap<>();

    static {
        VALIDATORS.put(Type.PAWN, new PawnValidatorPointFactory());
        VALIDATORS.put(Type.ROOK, new RookValidatorPointFactory());
        VALIDATORS.put(Type.KNIGHT, new KnightValidatorPointFactory());
        VALIDATORS.put(Type.BISHOP, new BishopValidatorPointFactory());
        VALIDATORS.put(Type.QUEEN, new QueenValidatorPointFactory());
        VALIDATORS.put(Type.KING, new KingValidatorPointFactory());
    }

    @Override
    public ValidatedChessMove validate(ChessMove move, ChessBoard chessBoard) {
        Token piece = chessBoard.get(move.from());
        if (piece == null) {
            return new ValidatedChessMove(move, Validity.INVALID, "No piece at source.");
        }
        if (!piece.colour().equals(chessBoard.getTurn())) {
            return new ValidatedChessMove(move, Validity.INVALID, "You can not move your opponents pieces.");
        }
        if (!piece.type().equals(move.type())) {
            return new ValidatedChessMove(move, Validity.INVALID, "Encoded piece does not match current board piece.");
        }

        PointFactory validPointFactory = VALIDATORS.get(move.type());
        Set<Point> validMoves = validPointFactory.generateValidMoves(move, chessBoard);
        if (!validMoves.contains(move.to())) {
            return new ValidatedChessMove(move, Validity.INVALID, "This piece can not move there.");
        }

        return new ValidatedChessMove(move, Validity.VALID, "");
    }
}
