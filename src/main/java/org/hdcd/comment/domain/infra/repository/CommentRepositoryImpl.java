package org.hdcd.comment.domain.infra.repository;

import org.hdcd.comment.domain.entity.Comment;
import org.hdcd.comment.domain.entity.QComment;
import org.hdcd.comment.domain.representation.CommentSearch;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CommentRepositoryImpl extends QuerydslRepositorySupport implements CommentRepositoryCustom {

    public CommentRepositoryImpl() {
        super(Comment.class);
    }

    @Override
    public List<Comment> findAllByCondition(CommentSearch search) {
        QComment comment = QComment.comment;
        return from(comment)
            .where(search.getPredicate())
            .orderBy(comment.commentId.asc())
            .limit(10)
            .fetch();
    }

}
