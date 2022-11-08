package com.nvlinh.blog.service;

import com.nvlinh.blog.dto.PostDto;
import com.nvlinh.blog.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPostService {
	public List<Post> findAll();

	public Post save(Post post);

	Post findById(Long id);

	Post update(PostDto postDto);

	boolean deleteById(Long id);
}
