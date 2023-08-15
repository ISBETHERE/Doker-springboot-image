// src/main/java/com/example/demo/service/BoardService.java

package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 조회
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    // 생성
    public Board insert(Board board) {
        return boardRepository.save(board);
    }

    // 삭제
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

  //수정
    public void updateBoard(long id, Board board) {
        Board oldBoard = boardRepository.findById(id).orElse(null);

        if (oldBoard != null) {
            oldBoard.setTitle(board.getTitle());
            oldBoard.setContents(board.getContents());
            boardRepository.save(oldBoard);
        } else {
            throw new RuntimeException("Board not found");
        }
    }


    public Board findById(Long id) {
        return boardRepository.findById(id).orElseThrow(() -> new RuntimeException("Board not found"));

    }
}


