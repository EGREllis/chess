package net.ellise.backend.io;

import net.ellise.backend.model.Colour;
import net.ellise.backend.model.Type;

public record BoardPiece(int x, int y, Colour colour, Type type) {
}
