package com.project.musicApp.dto.playlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPlaylistDto {

	private String name;
	private String description;
}
