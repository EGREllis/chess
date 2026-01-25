package net.ellise.backend.io.converter;

public class InvalidMoveEncodingException extends RuntimeException {
    public InvalidMoveEncodingException(String message) {
        super(message);
    }

    public static InvalidMoveEncodingException throwEncoded(String encoded) {
        throw new InvalidMoveEncodingException(String.format("Move was: %1$s", encoded));
    }
}
