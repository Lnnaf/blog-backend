package com.nvlinh.blog.service;

import com.nvlinh.blog.dto.PostDto;
import com.nvlinh.blog.entity.Post;
import com.nvlinh.blog.repository.IPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService{
	private final IPostRepository postRepository;

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public Post save(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post findById(Long id) {
		return postRepository.findById(id).orElse(null);
	}

	@Override
	public Post update(PostDto postDto) {
		var post = postRepository.findById(postDto.getId()).orElse(null);

		if(ObjectUtils.isEmpty(post)){
			return null;
		}
		post.setPostRead(postDto.getPostRead());
		post.setCreatedDate(postDto.getCreatedDate());
		post.setContent(post.getContent());
		post.setLastModifier(post.getLastModifier());
		post.setTitle(post.getTitle());
		post.setDescription(postDto.getDescription());
		post.setImageUrl(postDto.getImageUrl());

		return postRepository.save(post);
	}

	@Override
	public boolean deleteById(Long id) {
		postRepository.deleteById(id);
		return ObjectUtils.isEmpty(findById(id));
	}
}
