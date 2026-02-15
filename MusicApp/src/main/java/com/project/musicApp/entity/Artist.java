package com.project.musicApp.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Artist")
public class Artist {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String bio;
	private String genre;
	private String formedYear;
	private String socialLink;
	private String image;
	private String origin;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "artist")
	private List<Tracks> track;
	
}
