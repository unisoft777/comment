package org.hdcd.comment.domain.representation;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import org.hdcd.comment.domain.entity.Comment;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
public class CommentResponse {
    private Long commentId;
    private Long boardNo;
    private long parentId;
    private String content;
    private String writer;
    private long nestedCommentsCount;
    private LocalDateTime regDate;
    
    
    //lombok @builder를 공부할 것
    @Builder(access = AccessLevel.PRIVATE)
    private CommentResponse(Long commentId, Long boardNo, long parentId, String content,
                          String writer, LocalDateTime regDate, long nestedCommentsCount) {
        this.commentId = commentId;
        this.boardNo = boardNo;
        this.parentId = parentId;
        this.content = content;
        this.writer = writer;
        this.regDate = regDate;
        this.nestedCommentsCount = nestedCommentsCount;
    }

    public static CommentResponse of(Comment comment, long nestedCommentsCount) {
        return CommentResponse.builder()
            .commentId(comment.getCommentId())
            .boardNo(comment.getBoardNo())
            .parentId(comment.getParentId())
            .content(comment.getContent())
            .writer(comment.getWriter())
            .regDate(comment.getRegDate())
            .nestedCommentsCount(nestedCommentsCount)
            .build();
    }

}
