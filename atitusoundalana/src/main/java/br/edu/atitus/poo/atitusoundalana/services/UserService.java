package br.edu.atitus.poo.atitusoundalana.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.edu.atitus.poo.atitusoundalana.entities.UserEntity;

public interface UserService extends GenericService<UserEntity>, UserDetailsService{

}
