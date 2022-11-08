package com.nvlinh.blog.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "APP_USER")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_APP_SEQ")
	@SequenceGenerator(name = "USER_APP_SEQ",
			sequenceName = "USER_APP_SEQ",
			allocationSize = 1)
	@Column(name = "ID", nullable = false)
	private Long id;

	private String username;
	private String password;
	private String displayName;
	private Date dateJoin;
	private String email;
	private String phone;
	private String company;

	@Column(length = 1000)
	private String userAvatarUrl;

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<Post> posts;
}
