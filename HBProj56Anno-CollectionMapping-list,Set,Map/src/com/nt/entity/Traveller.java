package com.nt.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ListIndexBase;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "ANNO_TRAVELLER")
public class Traveller {

	@Id
	@GenericGenerator(name = "incr", strategy = "identity")
	@GeneratedValue(generator = "incr")
	private Integer travellerId;

	@NonNull
	private String tavellerName;

	@NonNull
	private LocalDate dob;

	@NonNull
	@CollectionTable(name = "NICK_NAMES")
	@JoinColumn(name = "TR_ID", referencedColumnName = "TRAVELLERID")
	@ElementCollection
	@ListIndexBase(value = 1)
	@OrderColumn(name = "NAME_INDEX")
	private List<String> nickNames;

	@NonNull
	@CollectionTable(name = "PHONE_NUMBERS")
	@JoinColumn(name = "TR_ID", referencedColumnName = "TRAVELLERID")
	@ElementCollection
	@OrderColumn(name = "Numbers")
	private Set<Long> phones;

	@NonNull
	@CollectionTable(name = "PLACES_VISITED")
	@JoinColumn(name = "TR_ID", referencedColumnName = "TRAVELLERID")
	@ElementCollection
	@MapKeyColumn(name = "TOUR_NAME")
	private Map<String, String> placesVisited;

}
