package com.project.musicApp.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Track")
@Builder
public class Tracks {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int trackId;
	private String title;
	private  String albumName;
	private String releaseDate;
	private String duration;
	private String genre;
	private String description;
	private long playcount;
	private String fileUrl;
	private String coverImage;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="artist_value")
	private Artist artist;
	

}
