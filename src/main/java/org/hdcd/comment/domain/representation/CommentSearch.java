package org.hdcd.comment.domain.representation;

import com.querydsl.core.BooleanBuilder;
import lombok.Getter;
import lombok.Setter;

import static org.hdcd.comment.domain.entity.QComment.comment;

@Getter
@Setter
public class CommentSearch {
    private Long commentId;
    private Long boardNo;
    private long parentId;

    // queryDsl조회 조건을 검색객체(CommentSearch) 안에 캡슐화
    public BooleanBuilder getPredicate() {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        commentIdEqual(booleanBuilder);
        parentIdEqual(booleanBuilder);
        commentIdGt(booleanBuilder);
        return booleanBuilder;
    }

    private void commentIdEqual(BooleanBuilder booleanBuilder) {
        booleanBuilder.and(comment.boardNo.eq(boardNo));
    }

    private void parentIdEqual(BooleanBuilder booleanBuilder) {
        booleanBuilder.and(comment.parentId.eq(parentId));
    }

    private void commentIdGt(BooleanBuilder booleanBuilder) {
        booleanBuilder.and(comment.commentId.gt(getCommentId()));
    }

}
