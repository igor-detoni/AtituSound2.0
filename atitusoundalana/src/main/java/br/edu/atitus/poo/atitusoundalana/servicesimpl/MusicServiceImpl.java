package br.edu.atitus.poo.atitusoundalana.servicesimpl;

import org.springframework.stereotype.Service;
import br.edu.atitus.poo.atitusoundalana.entities.MusicEntity;
import br.edu.atitus.poo.atitusoundalana.repositories.GenericRepository;
import br.edu.atitus.poo.atitusoundalana.repositories.MusicRepository;
import br.edu.atitus.poo.atitusoundalana.services.MusicService;

@Service
public class MusicServiceImpl implements MusicService{

	private final MusicRepository repository;
	
	public MusicServiceImpl(MusicRepository repository) {
		super();
		this.repository = repository;
	}


	@Override
	public GenericRepository<MusicEntity> getRepository() {
		return repository;
	}

}
