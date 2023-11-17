package br.edu.atitus.poo.atitusoundalana.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.poo.atitusoundalana.dtos.Musicdto;
import br.edu.atitus.poo.atitusoundalana.entities.ArtistEntity;
import br.edu.atitus.poo.atitusoundalana.entities.MusicEntity;
import br.edu.atitus.poo.atitusoundalana.services.GenericService;
import br.edu.atitus.poo.atitusoundalana.services.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController extends GenericController<MusicEntity, Musicdto>{

	private final MusicService service;
	
	public MusicController(MusicService service) {
		super();
		this.service = service;
	}

	@Override
	protected GenericService<MusicEntity> getService() {
		return service;
	}

	@Override
	protected MusicEntity convertdto2Entity(Musicdto dto) {
		MusicEntity entidade= new MusicEntity();
		entidade.setName(dto.getName());
		entidade.setUrl(dto.getUrl());
		
		ArtistEntity entidadeArtista = new ArtistEntity();
		entidadeArtista.setUuid(dto.getArtist().getUuid());
		entidade.setArtist(entidadeArtista);
		
		return entidade;
	}

}
