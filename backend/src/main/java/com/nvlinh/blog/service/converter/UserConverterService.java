package com.nvlinh.blog.service.converter;

import com.nvlinh.blog.dto.UserDto;
import com.nvlinh.blog.entity.User;

public class UserConverterService {
	public UserDto convertUserInfoInPost(User user){
		return UserDto.builder()
				.displayName(user.getDisplayName())
				.userAvatarUrl(user.getUserAvatarUrl())
				.build();
	}
}
