package com.nt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {

	private Long pid;

	@NonNull
	private String pname;
	@NonNull
	private String addrs;

}
