package br.edu.atitus.poo.atitusoundalana.repositories;

import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import br.edu.atitus.poo.atitusoundalana.entities.PlaylistEntity;
import br.edu.atitus.poo.atitusoundalana.entities.UserEntity;


@Repository
public interface PlaylistRepository extends GenericRepository<PlaylistEntity>{
	Page<List<PlaylistEntity>> findByNameContainingIgnoreCaseAndUserOrPublicshare(Pageable pageable, String name, UserEntity user, boolean publicShare);
	}
