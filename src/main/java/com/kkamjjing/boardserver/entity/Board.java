package com.kkamjjing.boardserver.entity;

import com.kkamjjing.boardserver.dto.BoardRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Table(name = "Board")
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String createAt;

    public Board (BoardRequestDto requestDto) {
        this.title = getTitle();
        this.name = getName();
        this.password = getPassword();
        this.content = getContent();
        this.createAt = getCreateAt();
    }

    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
