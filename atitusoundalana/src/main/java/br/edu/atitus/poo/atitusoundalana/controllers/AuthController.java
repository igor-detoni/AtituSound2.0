package br.edu.atitus.poo.atitusoundalana.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.poo.atitusoundalana.dtos.Signindto;
import br.edu.atitus.poo.atitusoundalana.dtos.Userdto;
import br.edu.atitus.poo.atitusoundalana.entities.UserEntity;
import br.edu.atitus.poo.atitusoundalana.services.UserService;
import br.edu.atitus.poo.atitusoundalana.utils.JwtUtil;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final UserService service;
	private final AuthenticationConfiguration authConfig;

	public AuthController(UserService service, AuthenticationConfiguration authConfig) {
		super();
		this.service = service;
		this.authConfig = authConfig;
	}
	
	@PostMapping("/signup")
	public ResponseEntity<UserEntity> PostSignup(@RequestBody Userdto dto ){
		UserEntity  entidade = new UserEntity();
		entidade.setName(dto.getName());
		entidade.setEmail(dto.getEmail());
		entidade.setUsername(dto.getUsername());
		entidade.setPassword(dto.getPassword());
		
		try {
			service.save(entidade);
		} catch (Exception e) {
			return ResponseEntity.badRequest().header("error", e.getMessage()).build();
		}
			return ResponseEntity.status(HttpStatus.CREATED).body(entidade);
		
	}
		
	
	@PostMapping("/signin")
	
		public ResponseEntity<String> postSignin(@RequestBody Signindto signin) {
		try {
			var auth = authConfig.getAuthenticationManager().authenticate(
					new UsernamePasswordAuthenticationToken(signin.getUsername(), signin.getPassword()));
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).header("error", e.getMessage()).build();
		}
		return ResponseEntity.ok(JwtUtil.generateTokenFromUsername(signin.getUsername()));
		
	}
	}
			