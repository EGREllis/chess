package net.ellise.backend.model.factory;

import lombok.extern.slf4j.Slf4j;
import net.ellise.backend.model.*;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
abstract class VectorValidatorPointFactory implements PointFactory {
    abstract protected Set<Vector> getDirections();
    abstract protected int maxDistance();

    @Override
    public Set<Point> generateValidMoves(ChessMove move, ChessBoard chessBoard) {
        Set<Point> validMoves = new TreeSet<>();

        for (Vector direction : getDirections()) {
            Vector current = Vector.NULL_ADDITION;
            for (int distance = 1; distance <= maxDistance(); distance++) {
                current = current.add(direction);
                Point destination = move.from().apply(current);
                if (Util.isOnBoard(destination)) {
                    Token atDestination = chessBoard.get(destination);
                    if (atDestination == null) {
                        // Empty space, a valid move
                        validMoves.add(destination);
                    } else if (atDestination.colour().equals(chessBoard.getTurn().getEnemy())) {
                        // Enemy piece is a capturable, a valid move.
                        validMoves.add(destination);
                        break;
                    } else if (atDestination.colour().equals(chessBoard.getTurn())) {
                        // Blocked by own piece, not a valid move.
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return Collections.unmodifiableSet(validMoves);
    }
}
