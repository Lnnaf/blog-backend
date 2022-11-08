package com.nvlinh.blog.dto;

import com.nvlinh.blog.Enum.ResponseType;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageResponse {
	private Date dateTime;
	private ResponseType type;
	private String msg;
}
