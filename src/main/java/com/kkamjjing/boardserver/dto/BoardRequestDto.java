package com.kkamjjing.boardserver.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequestDto {
    private String title;
    private String name;
    private String password;
    private String content;
    private String createAt;
}
