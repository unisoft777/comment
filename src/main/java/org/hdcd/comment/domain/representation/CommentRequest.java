package org.hdcd.comment.domain.representation;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class CommentRequest {
    private Long commentId;
    @NotNull(message = "회원 게시판 번호가 없습니다.")
    private Long boardNo;
    private long parentId;
    @NotNull(message = "허용하지 않는(1 ~ 250) 댓글 길이 입니다.")
    @Size(min = 1, max = 250, message = "허용하지 않는(1 ~ 250) 댓글 길이 입니다.")
    private String content;
    private String writer;
}
