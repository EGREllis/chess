package net.ellise.backend.repository;

import net.ellise.backend.model.ChessBoard;

public interface ChessBoardRepository {
    ChessBoard getChessBoard();
    void setChessBoard(ChessBoard chessBoard);
}
