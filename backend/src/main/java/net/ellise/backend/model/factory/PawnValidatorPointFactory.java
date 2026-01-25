package net.ellise.backend.model.factory;

import net.ellise.backend.model.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PawnValidatorPointFactory implements PointFactory {

    @Override
    public Set<Point> generateValidMoves(ChessMove move, ChessBoard board) {
        final Vector forward;
        final int startingY;

        if (Colour.BLACK.equals(board.getTurn())) {
            forward = Vector.SOUTH;
            startingY = 1;
        } else {
            forward = Vector.NORTH;
            startingY = 6;
        }

        Set<Point> validMoves = new HashSet<>();
        // If space is empty, move forward once is valid
        Point forwardOnce = move.from().apply(forward);
        if (board.get(forwardOnce) == null) {
            validMoves.add(forwardOnce);
        }

        // If both spaces are empty, move forward twice is valid, if at starting y.
        Point forwardTwice = move.from().apply(forward.add(forward));
        if (move.from().y() == startingY &&
            board.get(forwardOnce) == null &&
            board.get(forwardTwice) == null) {
            // Move forward twice is valid if at the starting point
            validMoves.add(forwardTwice);
        }

        // Moving diagonal is valid if an enemy piece is present
        Point forwardLeft = move.from().apply(forward.add(Vector.WEST));
        Point forwardRight = move.from().apply(forward.add(Vector.EAST));
        for (Point candidate : Set.of(forwardLeft, forwardRight)) {
            if (board.get(candidate) != null &&
                board.get(candidate).colour().equals(board.getTurn().getEnemy())) {
                validMoves.add(candidate);
            }
        }

        //TODO: Add en-passent (requires history of moves)
        //TODO: Add revealed check (here or elsewhere?)

        Set<Point> result = Util.cropToBoard(validMoves);

        return Collections.unmodifiableSet(result);
    }
}
