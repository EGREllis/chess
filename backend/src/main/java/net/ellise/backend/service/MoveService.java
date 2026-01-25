package net.ellise.backend.service;

import lombok.extern.slf4j.Slf4j;
import net.ellise.backend.io.Board;
import net.ellise.backend.io.BoardMove;
import net.ellise.backend.io.BoardPiece;
import net.ellise.backend.io.converter.Converter;
import net.ellise.backend.model.*;
import net.ellise.backend.model.factory.ChessBoardFactory;
import net.ellise.backend.repository.ChessBoardRepository;
import net.ellise.backend.validator.ChessMoveValidator;
import net.ellise.backend.validator.ValidatedChessMove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class MoveService {

    @Autowired
    private final ChessBoardFactory chessBoardFactory;

    @Autowired
    private final ChessBoardRepository chessBoardRepository;

    @Autowired
    private final Converter<BoardMove, ChessMove> boardMoveToChessMoveConverter;

    @Autowired
    private final ChessMoveValidator validator;

    @Autowired
    private final ChessEngine chessEngine;

    @Autowired
    private final Converter<ChessBoard, List<BoardPiece>> chessBoardListConverter;

    public MoveService(
            ChessBoardFactory chessBoardFactory,
            ChessBoardRepository chessBoardRepository,
            Converter<BoardMove, ChessMove> boardMoveToChessMoveConverter,
            ChessMoveValidator validator,
            ChessEngine chessEngine,
            Converter<ChessBoard, List<BoardPiece>> chessBoardListConverter) {
        this.chessBoardFactory = chessBoardFactory;
        this.chessBoardRepository = chessBoardRepository;
        this.boardMoveToChessMoveConverter = boardMoveToChessMoveConverter;
        this.validator = validator;
        this.chessEngine = chessEngine;
        this.chessBoardListConverter = chessBoardListConverter;
    }

    public Board newBoard() {
        ChessBoard chessBoard = chessBoardFactory.newBoard();
        chessBoardRepository.setChessBoard(chessBoard);
        List<BoardPiece> pieces = chessBoardListConverter.convert(chessBoard);
        return new Board(Colour.BLACK, null, pieces);
    }

    public Board applyMove(BoardMove move) {
        ChessBoard preMoveChessBoard = chessBoardRepository.getChessBoard();
        ChessMove chessMove = boardMoveToChessMoveConverter.convert(move);

        ValidatedChessMove validatedChessMove = validator.validate(chessMove, preMoveChessBoard);
        Board board;
        if (Validity.VALID.equals(validatedChessMove.validity())) {
            log.info("Applying valid move: "+chessMove);
            ChessBoard postMoveChessBoard = chessEngine.applyMove(validatedChessMove, preMoveChessBoard);
            chessBoardRepository.setChessBoard(postMoveChessBoard);
            List<BoardPiece> pieces = chessBoardListConverter.convert(postMoveChessBoard);
            board = new Board(postMoveChessBoard.getTurn(), null, pieces, move, validatedChessMove.validity(), validatedChessMove.invalidMessage());
        } else {
            log.info("Rejecting invalid move: "+chessMove);
            List<BoardPiece> pieces = chessBoardListConverter.convert(preMoveChessBoard);
            board = new Board(preMoveChessBoard.getTurn(), null, pieces, move, validatedChessMove.validity(), validatedChessMove.invalidMessage());
        }
        return board;
    }
}
