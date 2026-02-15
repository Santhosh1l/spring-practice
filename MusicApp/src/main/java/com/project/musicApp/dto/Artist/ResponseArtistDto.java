package com.project.musicApp.dto.Artist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseArtistDto {
	private int id;
	private String name;
	private String bio;
	private String genere;
	private String origin;
	private String formedYear;
	private String socialLink;
	private String image;


}
