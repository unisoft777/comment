package org.hdcd.comment.app;

import org.hdcd.comment.domain.entity.Comment;
import org.hdcd.comment.domain.infra.CommentCommandService;
import org.hdcd.comment.domain.infra.CommentQueryService;
import org.hdcd.comment.domain.representation.CommentRequest;
import org.hdcd.comment.domain.representation.CommentResponse;
import org.hdcd.comment.domain.representation.CommentSearch;
import org.hdcd.common.exception.UserNotMatchedException;
import org.hdcd.domain.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * query서비스와 comment서비스를 이어주는 중간단계의 서비스
 */
@Service
public class CommentAppService {

    private final CommentCommandService commentCommandService;
    private final CommentQueryService commentQueryService;

    public CommentAppService(CommentCommandService commentCommandService, CommentQueryService commentQueryService) {
        this.commentCommandService = commentCommandService;
        this.commentQueryService = commentQueryService;
    }

    public void save(CommentRequest request, Member member) {
        Comment comment = Comment.of(request, member.getUserName());
        commentCommandService.save(comment);
    }

    @Transactional
    public void update(CommentRequest request, Member member) throws UserNotMatchedException {
        if (isNotWriter(request, member)) {
            throw new UserNotMatchedException("작성자가 일치하지 않습니다.");
        }
        Comment comment = commentQueryService.findByCommentId(request.getCommentId());
        comment.populate(request);
    }

    public void remove(long commentId) throws Exception {
        commentCommandService.deleteById(commentId);
    }

    public List<CommentResponse> list(CommentSearch search) {
        return commentQueryService.findAllByCondition(search).stream()
            .map(e -> {
                long nestedCommentsCount = 0;
                // ParentId이 0이면 댓글이라는 뜻이여서 대댓글의 개수를 파악하는 로직을 돌림.
                if (e.getParentId() == 0) {
					nestedCommentsCount = commentQueryService.countByParentId(e.getCommentId());
				}
                return CommentResponse.of(e, nestedCommentsCount);
            }).collect(Collectors.toList());
    }

    private boolean isNotWriter(CommentRequest request, Member member) {
        return !request.getWriter().equals(member.getUserName());
    }
//
//	public List<Comment> list(PageRequestVO pageRequestVO) throws Exception {
//		String searchType = pageRequestVO.getSearchType();
//		String keyword = pageRequestVO.getKeyword();
//
//		int pageNumber = pageRequestVO.getPage() - 1;
//		int sizePerPage = pageRequestVO.getSizePerPage();
//
//		Pageable pageRequest = PageRequest.of(pageNumber, sizePerPage, Sort.Direction.DESC, "boardNo");
//
//		return repository.findByCondition(null, null);
//	}

}
