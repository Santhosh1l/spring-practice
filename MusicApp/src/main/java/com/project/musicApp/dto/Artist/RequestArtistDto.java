package com.project.musicApp.dto.Artist;

import jakarta.validation.constraints.NegativeOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestArtistDto {
	
	private String name;
	private String bio;
	private String genere;
	private String origin;
	private String formedYear;
	private String socialLink;
	private String image;
}
