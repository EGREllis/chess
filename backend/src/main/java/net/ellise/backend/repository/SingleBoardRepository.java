package net.ellise.backend.repository;

import net.ellise.backend.io.Board;
import net.ellise.backend.io.BoardEngine;
import net.ellise.backend.io.BoardFactory;
import net.ellise.backend.io.BoardMove;
import org.springframework.stereotype.Component;

@Component
public class SingleBoardRepository implements BoardRepository {
    private final BoardFactory boardFactory;
    private final BoardEngine boardEngine;
    private Board theBoard = null;

    public SingleBoardRepository(BoardFactory boardFactory, BoardEngine boardEngine) {
        this.boardFactory = boardFactory;
        this.boardEngine = boardEngine;
    }

    @Override
    public Board newBoard() {
        this.theBoard = boardFactory.newBoard();
        return theBoard;
    }

    @Override
    public Board applyMove(BoardMove boardMove) {
        Board nextBoard = boardEngine.applyMove(boardMove, theBoard);
        theBoard = nextBoard;
        return nextBoard;
    }
}
