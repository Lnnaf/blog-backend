package com.nvlinh.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nvlinh.blog.entity.User;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
	private Long id;
	private UserDto author;
	private Date createdDate;
	private Date lastModifier;
	private String postRead;
	private String imageUrl;
	private String title;
	private String urlTitle;
	private String description;
	private String content;
}
