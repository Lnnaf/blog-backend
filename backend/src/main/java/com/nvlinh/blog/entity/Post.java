package com.nvlinh.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "POST")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_SEQ")
	@SequenceGenerator(name = "POST_SEQ",
			sequenceName = "POST_SEQ",
			allocationSize = 1)
	@Column(name = "ID", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User author;

	private Date createdDate;
	private Date lastModifier;
	private String postRead;
	@Column(length = 1000)
	private String imageUrl;
	private String title;
	private String description;
	private String urlTitle;
	@Lob
	private String content;
}
