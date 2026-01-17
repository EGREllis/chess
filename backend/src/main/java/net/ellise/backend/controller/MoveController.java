package net.ellise.backend.controller;

import net.ellise.backend.model.Board;
import net.ellise.backend.model.BoardFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoveController {
    @GetMapping("/api/start")
    public Board getStarterBoard() {
        BoardFactory factory = new BoardFactory();
        return factory.newBoard();
    }
}
