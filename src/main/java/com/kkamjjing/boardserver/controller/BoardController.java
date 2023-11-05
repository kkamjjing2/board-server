package com.kkamjjing.boardserver.controller;

import com.kkamjjing.boardserver.dto.BoardRequestDto;
import com.kkamjjing.boardserver.dto.BoardResponseDto;
import com.kkamjjing.boardserver.dto.DeleteRequestDto;
import com.kkamjjing.boardserver.dto.UpdateRequestDto;
import com.kkamjjing.boardserver.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;


    @GetMapping()
    // 게시글 전체 조회
    public List<BoardResponseDto> FindAll() {
        return boardService.FindAll();
    }


    @GetMapping("/{id}")
    // 게시글 단건 조회
    public BoardResponseDto FindOne(@PathVariable long id) {
        return  boardService.findOne(id);
    }


    @PostMapping()
    // 게시글 작성
    public BoardResponseDto createBoard (@RequestBody BoardRequestDto boardRequestDto) {
        return boardService.createBoard(boardRequestDto);
    }


    @PutMapping("/{id}")
    // 게시글 수정
    public BoardResponseDto updateBoard (@PathVariable Long id,
                                         @RequestBody UpdateRequestDto updateRequestDto) {
        return boardService.updateBoard (id, updateRequestDto);
    }


    @DeleteMapping("/{id}")
    // 게시글 삭제
    public String deleteBoard (@PathVariable Long id,
                               @RequestBody DeleteRequestDto deleteRequestDto) {
        return boardService.deleteBoard(id, deleteRequestDto);
    }
}