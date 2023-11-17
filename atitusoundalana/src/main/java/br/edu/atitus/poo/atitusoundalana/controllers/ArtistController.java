package br.edu.atitus.poo.atitusoundalana.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.poo.atitusoundalana.dtos.Artistdto;
import br.edu.atitus.poo.atitusoundalana.entities.ArtistEntity;
import br.edu.atitus.poo.atitusoundalana.services.ArtistService;
import br.edu.atitus.poo.atitusoundalana.services.GenericService;


@RestController
@RequestMapping("/artists")
public class ArtistController extends GenericController<ArtistEntity, Artistdto>{
	
	private final ArtistService service;
	public ArtistController(ArtistService service) {
		super();
		this.service = service;
	}
	protected ArtistEntity convertdto2Entity(Artistdto dto) {
		ArtistEntity entity = new ArtistEntity();
		entity.setName(dto.getName());
		entity.setImage(dto.getImage());
		return entity;
	}
	@Override
	protected GenericService<ArtistEntity> getService() {
		return service;
	}
	
}