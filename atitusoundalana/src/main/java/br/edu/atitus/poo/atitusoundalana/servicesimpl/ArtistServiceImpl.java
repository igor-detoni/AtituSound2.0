package br.edu.atitus.poo.atitusoundalana.servicesimpl;

import org.springframework.stereotype.Service;
import br.edu.atitus.poo.atitusoundalana.entities.ArtistEntity;
import br.edu.atitus.poo.atitusoundalana.repositories.ArtistRepository;
import br.edu.atitus.poo.atitusoundalana.repositories.GenericRepository;
import br.edu.atitus.poo.atitusoundalana.services.ArtistService;


@Service
public class ArtistServiceImpl implements ArtistService {
	
	private final ArtistRepository repository;
	
	public ArtistServiceImpl(ArtistRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public GenericRepository<ArtistEntity> getRepository(){
		return repository;
	}

	
}
