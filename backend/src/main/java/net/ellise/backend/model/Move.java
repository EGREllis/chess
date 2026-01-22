package net.ellise.backend.model;

public class Move {
    private final String encoded;

    public Move(String encoded) {
        this.encoded = encoded;
    }

    public String getEncoded() {
        return encoded;
    }

    @Override
    public String toString() {
        return encoded;
    }
}
