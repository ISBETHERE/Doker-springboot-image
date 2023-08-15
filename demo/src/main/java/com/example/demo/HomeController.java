package com.example.demo;

import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class HomeController {


    @Autowired
    private BoardService boardService;

    public HomeController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Board> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "home";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @PostMapping("/write/submit")
    public String writeSubmit(Board board, RedirectAttributes redirectAttributes) {
        boardService.insert(board);
        return "redirect:/home";
    }

    @PostMapping("/create/board")
    public ResponseEntity<Board> createBoard(@RequestBody Board board) {
        Board createdBoard = boardService.insert(board);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBoard);
    }
//
//    @GetMapping("/board/{id}")
//    public String board(@PathVariable Long id, Model model) {
//        Board board = boardService.findById(id);
//        model.addAttribute("board", board);
//        return "edit";
//    }
@GetMapping("/board/{id}")
public ModelAndView viewBoard(@PathVariable Long id) {
    ModelAndView modelAndView = new ModelAndView("board");
    Board board = boardService.findById(id);
    modelAndView.addObject("board", board);
    return modelAndView;
}




    @PostMapping("/update/{id}")
    public String update(@ModelAttribute Board updatedBoard, @PathVariable Long id) {
        boardService.updateBoard(id, updatedBoard);
        return "redirect:/board/" + id;
    }


    @GetMapping("/board/edit/{id}")
    public String editBoardGet(@PathVariable Long id, Model model) {
        Board board = boardService.findById(id);
        model.addAttribute("board", board);
        return "board";
    }

    // 게시물 수정
    @PostMapping("/board/edit/{id}/submit")
    public String editSubmit(@PathVariable Long id, Board board) {
        boardService.updateBoard(id, board);
        return "redirect:/board/{id}";
    }


//    @GetMapping("/board/delete/{id}")
//    public String delete(@PathVariable Long id) {
//        boardService.delete(id);
//        return "redirect:/home";
//    }

    @PostMapping("/board/delete/{id}") // 여기를 변경해주세요.
    public String delete(@PathVariable Long id) {
        boardService.delete(id);
        return "redirect:/home";
    }
}
