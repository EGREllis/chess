package net.ellise.backend.model;

public enum Colour {
    BLACK,
    WHITE;

    public Colour getEnemy() {
        for (Colour colour : Colour.values()) {
            if (!this.equals(colour)) {
                return colour;
            }
        }
        throw new IllegalArgumentException("We should never reach here!");
    }
}
