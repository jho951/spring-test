package com.mysite.sbb;

import java.time.LocalDateTime;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;
    // N:1 관계 실제 데이터베이스에서는 외래키(foreign key) 관계가 생성된다.).
    @ManyToOne
    private Question question;
}
