package org.hdcd.comment.domain.infra.repository;

import org.hdcd.comment.domain.entity.Comment;
import org.hdcd.comment.domain.representation.CommentSearch;

import java.util.List;

public interface CommentRepositoryCustom {
	List<Comment> findAllByCondition(CommentSearch search);
}
