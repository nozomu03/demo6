package com.example.five.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    List<Comment> findByAuthor(String author);
    List<Comment> findByUserId(Long id);
}
