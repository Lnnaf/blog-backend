package com.nvlinh.blog.controller;

import com.nvlinh.blog.Enum.ResponseType;
import com.nvlinh.blog.dto.PostDto;
import com.nvlinh.blog.dto.UserDto;
import com.nvlinh.blog.dto.MessageResponse;
import com.nvlinh.blog.entity.Post;
import com.nvlinh.blog.service.PostService;
import com.nvlinh.blog.service.converter.PostConverterService;
import com.nvlinh.blog.util.DateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RequiredArgsConstructor
@RestController()
@CrossOrigin(origins = "*" )
@RequestMapping(path = "post")
public class PostController {
	private final PostService postService;
	private final PostConverterService postConverterService = new PostConverterService();
	private final DateTimeUtils dateTimeUtils = new DateTimeUtils();
	@GetMapping("/posts")
	ArrayList<Object> getPosts(){

		var posts = postService.findAll();
		var postsDto = new ArrayList<>();
		posts.forEach(x -> {
			postsDto.add(this.postConverterService.convertToDto(x));
		});
		return postsDto;
	}

	@PostMapping("/create")
	ResponseEntity<?> createPost (@RequestBody PostDto post) {
		post.setCreatedDate(new Date());
		post.setAuthor(UserDto.builder().id(post.getAuthor().getId()).build());

		Post postCreate = postConverterService.convertToEntity(post);
		var result = this.postService.save(postCreate);
		var msgResponse = new MessageResponse();

		if(ObjectUtils.isEmpty(result)){
			msgResponse = MessageResponse.builder()
					.msg("Unfortunately, create new post failed, please try again later !")
					.dateTime(new Date())
					.type(ResponseType.E).build();
		}else{
			msgResponse = MessageResponse.builder()
					.msg("success")
					.dateTime(result.getCreatedDate())
					.type(ResponseType.S).build();
		}
		return ResponseEntity.status(201).body(msgResponse) ;
	}

	@PutMapping("/update")
	ResponseEntity<?> update(@RequestBody PostDto post){
		post.setLastModifier(new Date());
		var result = this.postService.update(post);

		var msgResponse = new MessageResponse();

		if(ObjectUtils.isEmpty(result)){
			msgResponse = MessageResponse.builder()
					.msg("Unfortunately, Update post failed, please try again later !")
					.dateTime(new Date())
					.type(ResponseType.E).build();
		}else{
			msgResponse = MessageResponse.builder()
					.msg("success")
					.dateTime(result.getCreatedDate())
					.type(ResponseType.S).build();
		}
		return ResponseEntity.status(200).body(msgResponse) ;
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<?> delete(@PathVariable Long id){
		if(ObjectUtils.isEmpty(postService.findById(id))){
			return ResponseEntity.status(404).body(MessageResponse.builder()
					.msg("Post not found!")
					.dateTime(new Date())
					.type(ResponseType.E).build());
		}
		if(postService.deleteById(id)){
			return ResponseEntity.status(204).body(MessageResponse.builder()
					.msg("Delete successfully !")
					.dateTime(new Date())
					.type(ResponseType.S).build());
		}
		return ResponseEntity.status(500).body(MessageResponse.builder()
				.msg("Can't not delete this post !")
				.dateTime(new Date())
				.type(ResponseType.E).build());
	}

}
