package org.hdcd.comment.domain.infra.repository;

import org.hdcd.comment.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryCustom {
    long countByParentId(long parentId);
}
