package br.edu.atitus.poo.atitusoundalana.servicesimpl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.edu.atitus.poo.atitusoundalana.entities.PlaylistEntity;
import br.edu.atitus.poo.atitusoundalana.entities.UserEntity;
import br.edu.atitus.poo.atitusoundalana.repositories.GenericRepository;
import br.edu.atitus.poo.atitusoundalana.repositories.PlaylistRepository;
import br.edu.atitus.poo.atitusoundalana.services.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{
	
	private final PlaylistRepository repository;
	
	public PlaylistServiceImpl (PlaylistRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public GenericRepository<PlaylistEntity> getRepository() {
		return repository;
	}

	@Override
	public void validate(PlaylistEntity entity) throws Exception {
		PlaylistService.super.validate(entity);
		UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		entity.setUser(user);
	}

	@Override
	public Page<List<PlaylistEntity>> findByNameContainingIgnoreCase(Pageable pageable, String name) throws Exception {
		
		UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return repository.findByNameContainingIgnoreCaseAndUserOrPublicshare(pageable, name, user, true);
	
				}
	
}