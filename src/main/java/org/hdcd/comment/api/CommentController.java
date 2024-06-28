package org.hdcd.comment.api;

import org.hdcd.comment.app.CommentAppService;
import org.hdcd.comment.domain.representation.CommentRequest;
import org.hdcd.comment.domain.representation.CommentResponse;
import org.hdcd.comment.domain.representation.CommentSearch;
import org.hdcd.common.exception.BusinessException;
import org.hdcd.common.exception.UserNotMatchedException;
import org.hdcd.common.security.domain.CustomUser;
import org.hdcd.common.support.BindingResultChecker;
import org.hdcd.domain.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    private final CommentAppService commentAppService;
    // BindingResult 체크 처리해주는 클래스
    private final BindingResultChecker bindingResultChecker;

    public CommentController(CommentAppService commentAppService, BindingResultChecker bindingResultChecker) {
        this.commentAppService = commentAppService;
        this.bindingResultChecker = bindingResultChecker;
    }
    
    

    /**
     * CommentRequest의 데이터를 저장한다.
     * 댓글과 대댓글 공통
     * 댓글은 parentId가 0으로 고정
     * 대댓글은 parentId가 상위 댓글의 아이디를 갖는다.
     */
    @PostMapping("")
    @PreAuthorize("hasRole('MEMBER')")
    public ResponseEntity<CommentRequest> save(@RequestBody @Valid CommentRequest request,
                                               BindingResult bindingResult,
                                               Authentication authentication) throws BusinessException {
        bindingResultChecker.check(bindingResult);
        commentAppService.save(request, getUser(authentication));
        return new ResponseEntity<>(request, HttpStatus.OK);
    }
   
    /**
     * CommentRequest안에 writer와 session의 유저가 같으면 업데이트를 진행한다.
     * CommentRequest안에 content 내용만 업데이트 된다.
     * 댓글과 대댓글 공통
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MEMBER')")
    public ResponseEntity<CommentRequest> update(@RequestBody @Valid CommentRequest request,
                                                 BindingResult bindingResult,
                                                 @PathVariable("id") long commentId,
                                                 Authentication authentication) throws BusinessException, UserNotMatchedException {
        bindingResultChecker.check(bindingResult);
        commentAppService.update(request, getUser(authentication));
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    /**
     *
     * commentId로 삭제를 진행
     * 댓글과 대댓글 공통
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MEMBER')")
    public ResponseEntity remove(@PathVariable("id") long commentId,
                                                 Authentication authentication) throws Exception {
        commentAppService.remove(commentId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * CommentSearch안의 commentId, boardNo, parentId로 검색
     *
     * page번호로 구별하는게 아니고 commentId의 번호보다 큰걸 불러온다.(limit은 10으로 하드코딩)
     * 처음에는 commentId를 디폴트값을 0으로 보내면 0보다 큰 아이디의 데이터를 10개 불러옵니다.
     * 예를 들어 10개가 가져와졌고 코멘트아이디는 1~10이라고 가정하겠습니다.
     * 그 후 호출된 데이터중에서 가장 큰 commentId 10을 넣고 다시 호출하면 11부터 20까지 데이터를 가져옵니다.
     *
     * boardNo회원 게시판의 번호
     * parentId가 0이면 댓글 0이 아니면 대댓글
     */
    @GetMapping("")
    public ResponseEntity<List<CommentResponse>> list(CommentSearch search) throws Exception {
        return new ResponseEntity<>(commentAppService.list(search), HttpStatus.OK);
    }

    private Member getUser(Authentication authentication) {
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        return customUser.getMember();
    }

}
