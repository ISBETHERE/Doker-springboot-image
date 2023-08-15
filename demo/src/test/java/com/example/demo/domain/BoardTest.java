package com.example.demo.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Board Entity Test")
public class BoardTest {

    @Test
    @DisplayName("Should set the id correctly")
    void setIdCorrectly() {
        Board board = new Board();
        Long id = 1L;

        board.setId(id);

        assertEquals(id, board.getId());
    }

}