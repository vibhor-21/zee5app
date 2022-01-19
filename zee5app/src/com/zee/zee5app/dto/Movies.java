package com.zee.zee5app.dto;

import lombok.Data;

@Data

public class Movies {
	private String Name;
	private String release_date;
	private String trailer;
	private String language;
	private String[] cast;
	private long length;
	private String id;
	
}
