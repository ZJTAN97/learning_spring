package com.springboot.blog.service;

import java.util.List;

import com.springboot.blog.payload.CommentDto;

public interface CommentService {

	List<CommentDto> getCommentsByPostId(Long postId);

	CommentDto getCommentbyId(Long postId, Long commentId);

	CommentDto createComment(Long postId, CommentDto commentDto);

	CommentDto updateComment(Long postId, Long commentId,
			CommentDto commentDto);

	void deleteComment(Long postId, Long commentId);

}
