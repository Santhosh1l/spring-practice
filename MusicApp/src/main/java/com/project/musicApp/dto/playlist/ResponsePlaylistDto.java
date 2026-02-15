package com.project.musicApp.dto.playlist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponsePlaylistDto {
	private int id;
	private String name;
	private String description;

}
