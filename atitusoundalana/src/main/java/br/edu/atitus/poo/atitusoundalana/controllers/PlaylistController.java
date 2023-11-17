package br.edu.atitus.poo.atitusoundalana.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.poo.atitusoundalana.dtos.Playlistdto;
import br.edu.atitus.poo.atitusoundalana.entities.PlaylistEntity;
import br.edu.atitus.poo.atitusoundalana.services.GenericService;
import br.edu.atitus.poo.atitusoundalana.services.PlaylistService;

@RestController
@RequestMapping("/playlist")
public class PlaylistController extends GenericController<PlaylistEntity, Playlistdto>{

	private final PlaylistService service;
	
	public PlaylistController(PlaylistService service) {
		super();
		this.service = service;
	}

	@Override
	protected GenericService<PlaylistEntity> getService() {
		return service;
	}

	@Override
	protected PlaylistEntity convertdto2Entity(Playlistdto dto) {
		PlaylistEntity playlist = new PlaylistEntity();
		playlist.setName(dto.getName());
		playlist.setPublic_share(dto.getPublic_share());
		return playlist;
	}

}
