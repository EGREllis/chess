package net.ellise.backend.repository;

import net.ellise.backend.model.Board;
import net.ellise.backend.model.Move;

public interface BoardRepository {
    Board newBoard();
    Board applyMove(Move move);
}
