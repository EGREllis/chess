package net.ellise.backend.model;

public interface ChessBoardVisitor {
    void visit(Point point, Token token);
}
