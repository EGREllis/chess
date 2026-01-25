package net.ellise.backend.validator;

import net.ellise.backend.model.ChessMove;
import net.ellise.backend.model.Validity;

public record ValidatedChessMove(ChessMove move, Validity validity, String invalidMessage) {
}
