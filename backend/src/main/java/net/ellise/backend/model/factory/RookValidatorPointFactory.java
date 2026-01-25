package net.ellise.backend.model.factory;

import lombok.extern.slf4j.Slf4j;
import net.ellise.backend.model.*;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
public class RookValidatorPointFactory implements PointFactory {
    private static final Set<Vector> DIRECTIONS = Set.of(Vector.NORTH, Vector.SOUTH, Vector.EAST, Vector.WEST);

    @Override
    public Set<Point> generateValidMoves(ChessMove move, ChessBoard chessBoard) {
        Set<Point> validMoves = new TreeSet<>();

        for (Vector direction : DIRECTIONS) {
            Vector current = Vector.NULL_ADDITION;
            for (int distance = 1; distance < 8; distance++) {
                current = current.add(direction);
                Point destination = move.from().apply(current);
                if (Util.isOnBoard(destination)) {
                    Token atDestination = chessBoard.get(destination);
                    if (atDestination == null) {
                        // Empty space, a valid move
                        validMoves.add(destination);
                    } else if (atDestination.colour().equals(chessBoard.getTurn().getEnemy())) {
                        // Enemy piece is a captureable, a valid move.
                        validMoves.add(destination);
                        break;
                    } else if (atDestination.colour().equals(chessBoard.getTurn())) {
                        // Blocked by own piece
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        log.info("Valid moves for rook: "+validMoves);
        return Collections.unmodifiableSet(validMoves);
    }
}
