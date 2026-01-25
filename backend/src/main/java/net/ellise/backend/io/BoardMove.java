package net.ellise.backend.io;

public class BoardMove {
    private final String encoded;

    public BoardMove(String encoded) {
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
