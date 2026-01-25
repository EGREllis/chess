package net.ellise.backend.repository;

import net.ellise.backend.model.ChessBoard;
import org.springframework.stereotype.Component;

@Component
public class SingleChessBoardRepository implements ChessBoardRepository {
    private ChessBoard theBoard = null;

    public SingleChessBoardRepository() {
    }

    @Override
    public ChessBoard getChessBoard() {
        return theBoard;
    }

    @Override
    public void setChessBoard(ChessBoard chessBoard) {
        this.theBoard = chessBoard;
    }
}
