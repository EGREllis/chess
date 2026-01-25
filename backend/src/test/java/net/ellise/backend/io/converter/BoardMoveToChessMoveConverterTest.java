package net.ellise.backend.io.converter;

import net.ellise.backend.io.BoardMove;
import net.ellise.backend.model.ChessMove;
import net.ellise.backend.model.Point;
import net.ellise.backend.model.Type;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BoardMoveToChessMoveConverterTest {

    @ParameterizedTest
    @MethodSource
    public void verifyValidConversion(String encoded, Type expectedType, Point expectedFrom, Point expectedTo) {
        BoardMove boardMove = new BoardMove(encoded);
        BoardMoveToChessMoveConverter subject = new BoardMoveToChessMoveConverter();

        ChessMove actual = subject.convert(boardMove);

        assertThat(actual).isNotNull();
        assertThat(actual.type()).isEqualTo(expectedType);
        assertThat(actual.from()).isEqualTo(expectedFrom);
        assertThat(actual.to()).isEqualTo(expectedTo);
    }

    @ParameterizedTest
    @MethodSource
    public void verifyInvalidConversion(String encoded, String expectedMessage) {
        BoardMove boardMove = new BoardMove(encoded);
        BoardMoveToChessMoveConverter subject = new BoardMoveToChessMoveConverter();

        assertThatThrownBy(() -> subject.convert(boardMove))
                .hasMessage(expectedMessage);
    }

    public static List<Arguments> verifyValidConversion() {
        return List.of(
                Arguments.of(
                        "a2-a3",
                    Type.PAWN,
                    new Point(0, 1),
                    new Point(0, 2)
                ),
                Arguments.of(
                    "Ra1-b1",
                    Type.ROOK,
                    new Point(0,0),
                    new Point(1, 0)
                ),
                Arguments.of(
                    "Nb1-a3",
                    Type.KNIGHT,
                    new Point(1, 0),
                    new Point(0,2)
                ),
                Arguments.of(
                    "Bc1-a3",
                    Type.BISHOP,
                    new Point(2, 0),
                    new Point(0,2)
                ),
                Arguments.of(
                    "Qe1-c2",
                    Type.QUEEN,
                    new Point(4,0),
                    new Point(2, 1)
                ),
                Arguments.of(
                    "Kd1-c2",
                    Type.KING,
                    new Point(3, 0),
                    new Point(2, 1)
                )
        );
    }

    public static List<Arguments> verifyInvalidConversion() {
        return List.of(
            Arguments.of("NONSENSE", "Move was: NONSENSE"),   // Gibberish
            Arguments.of("Aa1-b2", "Move was: Aa1-b2"),     // Invalid piece
            Arguments.of("Bi1-a8", "Move was: Bi1-a8"),     // Invalid from x
            Arguments.of("Ba9-a8", "Move was: Ba9-a8"),     // Invalid from y
            Arguments.of("Ba1-i8", "Move was: Ba1-i8"),     // Invalid to x
            Arguments.of("Ba1-h9", "Move was: Ba1-h9")      // Invalid to y
        );
    }

}
