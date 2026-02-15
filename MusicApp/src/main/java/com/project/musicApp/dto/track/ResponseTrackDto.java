package com.project.musicApp.dto.track;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseTrackDto {
	
	private int id;
	private String title;
	private String albumName;
	private String releaseData;
	private String duration;
	private String genre;
	private String description;
	private long playCount;
	private String filUrl;
	private String coverImage;

}
