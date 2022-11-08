package com.nvlinh.blog.service.converter;

import com.nvlinh.blog.dto.PostDto;
import com.nvlinh.blog.entity.Post;
import com.nvlinh.blog.entity.User;

public class PostConverterService {
	public PostDto convertToDto(Post post){
		UserConverterService userConverterService = new UserConverterService();
		return PostDto.builder()
				.id(post.getId())
				.author(userConverterService.convertUserInfoInPost(post.getAuthor()))
				.postRead(post.getPostRead())
				.title(post.getTitle())
				.createdDate(post.getCreatedDate())
				.lastModifier(post.getLastModifier())
				.urlTitle(post.getUrlTitle())
				.imageUrl(post.getImageUrl())
				.description(post.getDescription())
				.content(post.getContent()).build();
	}

	public Post convertToEntity(PostDto postDto){
		User author = User.builder().id(postDto.getAuthor().getId()).build();
		return Post.builder()
				.author(author)
				.postRead(postDto.getPostRead())
				.title(postDto.getTitle())
				.createdDate(postDto.getCreatedDate())
				.urlTitle(postDto.getUrlTitle())
				.imageUrl(postDto.getImageUrl())
				.description(postDto.getDescription())
				.content(postDto.getContent()).build();
	}
}
