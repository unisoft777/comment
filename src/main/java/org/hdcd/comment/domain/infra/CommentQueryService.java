package org.hdcd.comment.domain.infra;

import org.hdcd.comment.domain.entity.Comment;
import org.hdcd.comment.domain.infra.repository.CommentRepository;
import org.hdcd.comment.domain.representation.CommentSearch;
import org.hdcd.vo.PageRequestVO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* CQRS의 패턴에서의 조회만 하는 서비스
* CQRS은 인터넷으로 공부해보시면 됩니다.
* 해당 서비스는 입력값은 없고 조회만 합니다.
* 조회만 하므로 readOnly = true로 설정합니다 속도가 훨씬 빠르니 참고 하세요
* */
@Service
@Transactional(readOnly = true)
public class CommentQueryService {

	private final CommentRepository repository;

	public CommentQueryService(CommentRepository repository) {
		this.repository = repository;
	}

	public Comment findByCommentId(Long commentId) {
		return repository.findById(commentId).orElseThrow(RuntimeException::new); //람다 메서드 참조
	}

	public List<Comment> findAllByCondition(CommentSearch search) {
		return repository.findAllByCondition(search);
	}

	public long countByParentId(long parentId) {
		return repository.countByParentId(parentId);
	}
	
}
