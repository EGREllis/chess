package net.ellise.backend.io.converter;

import net.ellise.backend.io.BoardMove;
import net.ellise.backend.model.ChessMove;
import net.ellise.backend.model.Point;
import net.ellise.backend.model.Type;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BoardMoveToChessMoveConverter implements Converter<BoardMove, ChessMove> {
    private static final Pattern ENCODED_PATTERN = Pattern.compile("^([RNBQK])?([abcdefgh])([12345678])-([abcdefgh])([12345678])");
    private static final Map<String,Integer> COLUMNS = new HashMap<>();
    private static final Map<String,Integer> ROWS = new HashMap<>();

    static {
        COLUMNS.put("a", 0);
        COLUMNS.put("b", 1);
        COLUMNS.put("c", 2);
        COLUMNS.put("d", 3);
        COLUMNS.put("e", 4);
        COLUMNS.put("f", 5);
        COLUMNS.put("g", 6);
        COLUMNS.put("h", 7);
        ROWS.put("1", 0);
        ROWS.put("2", 1);
        ROWS.put("3", 2);
        ROWS.put("4", 3);
        ROWS.put("5", 4);
        ROWS.put("6", 5);
        ROWS.put("7", 6);
        ROWS.put("8", 7);
    }

    @Override
    public ChessMove convert(BoardMove input) {
        String encoded = input.getEncoded();
        Matcher matcher = ENCODED_PATTERN.matcher(encoded);
        if (!matcher.matches()) {
            InvalidMoveEncodingException.throwEncoded(encoded);
        }
        final Type type;
        switch (matcher.group(1)) {
            case null:
                type = Type.PAWN;
                break;
            case "R":
                type = Type.ROOK;
                break;
            case "N":
                type = Type.KNIGHT;
                break;
            case "B":
                type = Type.BISHOP;
                break;
            case "Q":
                type = Type.QUEEN;
                break;
            case "K":
                type = Type.KING;
                break;
            default:
                InvalidMoveEncodingException.throwEncoded(encoded);
                type = null;
        }
        Integer fromX = COLUMNS.get(matcher.group(2));
        Integer fromY = ROWS.get(matcher.group(3));
        Integer toX = COLUMNS.get(matcher.group(4));
        Integer toY = ROWS.get(matcher.group(5));
        if (fromX == null || fromY == null || toX == null || toY == null) {
            InvalidMoveEncodingException.throwEncoded(encoded);
        }
        Point from = new Point(fromX, fromY);
        Point to = new Point(toX, toY);
        return new ChessMove(type, from, to);
    }
}
