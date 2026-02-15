package com.project.musicApp.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Playlist")
public class Playlist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int playlistId;
	private String playlistName;
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="tracK_info")
	private List<Tracks> track;
	

}
