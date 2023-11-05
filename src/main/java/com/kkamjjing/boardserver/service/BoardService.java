package com.kkamjjing.boardserver.service;

import com.kkamjjing.boardserver.dto.BoardRequestDto;
import com.kkamjjing.boardserver.dto.BoardResponseDto;
import com.kkamjjing.boardserver.dto.UpdateRequestDto;
import com.kkamjjing.boardserver.entity.Board;
import com.kkamjjing.boardserver.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
private final BoardRepository boardRepository;
public BoardService(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
}
    // 게시글 전체 조회
    public List<BoardResponseDto> FindAll() {
        return boardRepository.findAllByOrderByCreatedAtDesc().stream().map(BoardResponseDto::new).toList();
    }

    // 게시글 단건 조회
    public BoardResponseDto findOne(long id) {
        Board returnBoard = boardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다."));
         return new BoardResponseDto(returnBoard);
    }


    // 게시글 작성
    public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {
        Board board = new Board(boardRequestDto);
        Board saveBoard = boardRepository.save(board);
        return new BoardResponseDto(saveBoard);
    }



    // 게시글 수정
    @Transactional
    public BoardResponseDto updateBoard(Long id, UpdateRequestDto updateRequestDto) {
    Board board = findBoard(id);
    checkPassword(board, updateRequestDto.getPassword());
    board.update(updateRequestDto);
    BoardResponseDto boardResponseDto = new BoardResponseDto(board);
    return new BoardResponseDto(board);
    }

    private void checkPassword(Board board, String inputPassword) {
        if (!board.getPassword().equals(inputPassword)) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }
    }


    // 게시글 삭제
    public String deleteBoard(Long id) {
    Board board = findBoard(id);
    boardRepository.delete(board);
        return "삭제되었습니다.";
    }

    private Board findBoard(Long id) {
        return boardRepository.findById(id).orElseThrow(()->
            new IllegalArgumentException("게시글이 없습니다."));
    }
}
