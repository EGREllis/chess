package net.ellise.backend.model.factory;

import net.ellise.backend.model.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class RookValidatorPointFactoryTest {
    @Test
    public void checkLimitedByBoardSouthAndEast() {
        ChessBoard board = new ChessBoard(Colour.BLACK, Map.of(new Point(0,0), new Token(Colour.BLACK, Type.ROOK)));
        PointFactory subject = new RookValidatorPointFactory();
        Set<Point> expectedValidMoves = new TreeSet<>();
        expectedValidMoves.add(new Point(0,1));
        expectedValidMoves.add(new Point(0,2));
        expectedValidMoves.add(new Point(0,3));
        expectedValidMoves.add(new Point(0,4));
        expectedValidMoves.add(new Point(0,5));
        expectedValidMoves.add(new Point(0,6));
        expectedValidMoves.add(new Point(0,7));
        expectedValidMoves.add(new Point(1,0));
        expectedValidMoves.add(new Point(2,0));
        expectedValidMoves.add(new Point(3,0));
        expectedValidMoves.add(new Point(4,0));
        expectedValidMoves.add(new Point(5,0));
        expectedValidMoves.add(new Point(6,0));
        expectedValidMoves.add(new Point(7,0));
        expectedValidMoves = Collections.unmodifiableSet(expectedValidMoves);

        Set<Point> validMoves = subject.generateValidMoves(new ChessMove(Type.ROOK, new Point(0,0), new Point(1,0)), board);

        assertThat(validMoves).isEqualTo(expectedValidMoves);
    }

    @Test
    public void checkLimitedByBoardNorthAndWest() {
        ChessBoard board = new ChessBoard(Colour.BLACK, Map.of(new Point(7,7), new Token(Colour.BLACK, Type.ROOK)));
        PointFactory subject = new RookValidatorPointFactory();
        Set<Point> expectedValidMoves = new TreeSet<>();
        expectedValidMoves.add(new Point(7,0));
        expectedValidMoves.add(new Point(7,1));
        expectedValidMoves.add(new Point(7,2));
        expectedValidMoves.add(new Point(7,3));
        expectedValidMoves.add(new Point(7,4));
        expectedValidMoves.add(new Point(7,5));
        expectedValidMoves.add(new Point(7,6));
        expectedValidMoves.add(new Point(0,7));
        expectedValidMoves.add(new Point(1,7));
        expectedValidMoves.add(new Point(2,7));
        expectedValidMoves.add(new Point(3,7));
        expectedValidMoves.add(new Point(4,7));
        expectedValidMoves.add(new Point(5,7));
        expectedValidMoves.add(new Point(6,7));
        expectedValidMoves = Collections.unmodifiableSet(expectedValidMoves);

        Set<Point> validMoves = subject.generateValidMoves(new ChessMove(Type.ROOK, new Point(7,7), new Point(0,7)), board);

        assertThat(validMoves).isEqualTo(expectedValidMoves);
    }
}
