package net.ellise.backend.repository;

import net.ellise.backend.io.Board;
import net.ellise.backend.io.BoardMove;

public interface BoardRepository {
    Board newBoard();
    Board applyMove(BoardMove boardMove);
}
