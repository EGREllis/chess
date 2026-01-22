package net.ellise.backend.repository;

import net.ellise.backend.model.Board;
import net.ellise.backend.model.BoardEngine;
import net.ellise.backend.model.BoardFactory;
import net.ellise.backend.model.Move;
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
    public Board applyMove(Move move) {
        Board nextBoard = boardEngine.applyMove(move, theBoard);
        theBoard = nextBoard;
        return nextBoard;
    }
}
