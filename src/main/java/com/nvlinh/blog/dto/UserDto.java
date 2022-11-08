package com.nvlinh.blog.dto;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private Long id;
	private String username;
	private String displayName;
	private Date dateJoin;
	private String email;
	private String phone;
	private String company;
	private String userAvatarUrl;
}
