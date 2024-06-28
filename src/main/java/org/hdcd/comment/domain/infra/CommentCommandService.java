package org.hdcd.comment.domain.infra;

import lombok.RequiredArgsConstructor;
import org.hdcd.comment.domain.entity.Comment;
import org.hdcd.comment.domain.infra.repository.CommentRepository;
import org.hdcd.comment.domain.representation.CommentRequest;
import org.hdcd.domain.Member;
import org.hdcd.vo.PageRequestVO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * CQRS의 패턴에서의 입력/수정/삭제 하는 서비스
 * CQRS은  구글님한테 물어 보시고 지금은 모르셔도 됩니다.
 * 해당 서비스는 조회는 없고 입력/수정/삭제만 합니다.
 * */
@Service
@Transactional
public class CommentCommandService {

	private final CommentRepository repository;

	public CommentCommandService(CommentRepository repository) {
		this.repository = repository;
	}
	
	
	

	public void save(Comment comment) {
		repository.save(comment);
	}

	public void deleteById(Long commentId) {
		repository.deleteById(commentId);
	}

}
