package com.nt.entity;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {

	private Integer sid;
	@NonNull
	private String sname;
	@NonNull
	private String course;
	@NonNull
	private List<String> friends;
}
