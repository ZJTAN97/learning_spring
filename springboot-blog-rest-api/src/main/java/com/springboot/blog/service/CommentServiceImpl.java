package com.springboot.blog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.BlogAPIException;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.repository.CommentRepository;
import com.springboot.blog.repository.PostRepository;

@Service
public class CommentServiceImpl implements CommentService {

	private CommentRepository commentRepository;
	private PostRepository postRepository;
	private ModelMapper mapper;

	public CommentServiceImpl(CommentRepository commentRepository,
			PostRepository postRepository, ModelMapper mapper) {
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
		this.mapper = mapper;
	}

	private CommentDto mapToDto(Comment comment) {
		CommentDto commentDto = mapper.map(comment, CommentDto.class);
		return commentDto;
	}

	private Comment mapToEntity(CommentDto commentDto) {
		Comment comment = mapper.map(commentDto, Comment.class);
		return comment;
	}

	@Override
	public CommentDto createComment(Long postId, CommentDto commentDto) {

		Comment comment = mapToEntity(commentDto);

		Post post = postRepository.findById(postId).orElseThrow(
				() -> new ResourceNotFoundException("Post", "id", postId));

		// set post to comment entity
		comment.setPost(post);

		// save to db
		Comment newComment = commentRepository.save(comment);

		return mapToDto(newComment);

	}

	@Override
	public List<CommentDto> getCommentsByPostId(Long postId) {

		List<Comment> comments = commentRepository.findByPostId(postId);

		return comments.stream().map(comment -> mapToDto(comment))
				.collect(Collectors.toList());
	}

	@Override
	public CommentDto getCommentbyId(Long postId, Long commentId) {

		Post post = postRepository.findById(postId).orElseThrow(
				() -> new ResourceNotFoundException("Post", "id", postId));

		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment",
						"id", commentId));

		if (!comment.getPost().getId().equals(post.getId())) {
			throw new BlogAPIException(HttpStatus.BAD_REQUEST,
					"Comment does not belong to post");
		}

		return mapToDto(comment);
	}

	@Override
	public CommentDto updateComment(Long postId, Long commentId,
			CommentDto commentDto) {

		Post post = postRepository.findById(postId).orElseThrow(
				() -> new ResourceNotFoundException("Post", "id", postId));

		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment",
						"id", commentId));

		if (!comment.getPost().getId().equals(post.getId())) {
			throw new BlogAPIException(HttpStatus.BAD_REQUEST,
					"Comment does not belong to post");
		}

		comment.setName(commentDto.getName()); // this need meh?
		comment.setEmail(commentDto.getEmail()); // this also need meh?
		comment.setBody(commentDto.getBody());

		Comment updatedComment = commentRepository.save(comment);

		return mapToDto(updatedComment);
	}

	@Override
	public void deleteComment(Long postId, Long commentId) {
		Post post = postRepository.findById(postId).orElseThrow(
				() -> new ResourceNotFoundException("Post", "id", postId));

		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment",
						"id", commentId));

		if (!comment.getPost().getId().equals(post.getId())) {
			throw new BlogAPIException(HttpStatus.BAD_REQUEST,
					"Comment does not belong to post");
		}

		commentRepository.delete(comment);
	}

}
