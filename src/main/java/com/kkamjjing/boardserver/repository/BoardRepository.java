package com.kkamjjing.boardserver.repository;

import com.kkamjjing.boardserver.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByCreatedAtDesc();
//    List<Board> findAllByContentContainsOrderByModifiedAtDesc(id);
}
