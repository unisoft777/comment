package org.hdcd.comment.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hdcd.comment.domain.representation.CommentRequest;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column
    private Long boardNo;

    @Column
    private long parentId;

    @Column(length = 250)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    @CreationTimestamp
    private LocalDateTime regDate;

    @UpdateTimestamp
    private LocalDateTime updDate;

    @Builder(access = AccessLevel.PRIVATE)
    private Comment(Long boardNo, long parentId, String content, String writer) {
        this.boardNo = boardNo;
        this.parentId = parentId;
        this.content = content;
        this.writer = writer;
    }

    public static Comment of(CommentRequest request, String writer) {
        return Comment.builder()
            .boardNo(request.getBoardNo())
            .content(request.getContent())
            .parentId(request.getParentId())
            .writer(writer)
            .build();
    }

    public void populate(CommentRequest request) {
        this.content = request.getContent();
    }

}
