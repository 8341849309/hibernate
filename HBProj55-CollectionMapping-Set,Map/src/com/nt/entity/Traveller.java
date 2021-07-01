package com.nt.entity;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Traveller {

	private Integer travellerId;
	@NonNull
	private String tavellerName;
	@NonNull
	private LocalDate dob;
	@NonNull
	private Set<Long> phones;
	@NonNull
	private Map<String, String> placesVisited;
}
