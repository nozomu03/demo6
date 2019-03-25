package com.example.five.demo;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private String comment;

    @CreationTimestamp
    private LocalDateTime oriTime;
    @UpdateTimestamp
    private LocalDateTime editTime;
}
