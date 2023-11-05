package com.kkamjjing.boardserver.dto;

import com.kkamjjing.boardserver.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String name;
    private String content;
    private String createAt;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.name = board.getName();
        this.content = board.getContent();
        this.createAt = board.getCreateAt();
    }
}
