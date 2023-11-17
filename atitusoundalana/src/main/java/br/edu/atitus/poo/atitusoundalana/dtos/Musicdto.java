package br.edu.atitus.poo.atitusoundalana.dtos;

import java.time.Duration;

public class Musicdto {
	private String name;
	
	private Duration duration;
	
	private String url;
	
	private DtoOnlyUuid artist;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public DtoOnlyUuid getArtist() {
		return artist;
	}

	public void setArtist(DtoOnlyUuid artist) {
		this.artist = artist;
	}

}
