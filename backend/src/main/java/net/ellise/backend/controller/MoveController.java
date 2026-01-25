package net.ellise.backend.controller;

import lombok.extern.slf4j.Slf4j;
import net.ellise.backend.io.Board;
import net.ellise.backend.io.BoardMove;
import net.ellise.backend.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MoveController {

    @Autowired
    private MoveService moveService;

    @GetMapping("/api/start")
    public Board getStarterBoard() {
        return moveService.newBoard();
    }

    @PostMapping("/api/move")
    public Board applyMove(@RequestBody BoardMove boardMove) {
        return moveService.applyMove(boardMove);
    }
}
