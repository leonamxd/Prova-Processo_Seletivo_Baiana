package br.com.provaBaiana.autenticacaoUsuario.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.provaBaiana.autenticacaoUsuario.dtos.UsuarioDto;
import br.com.provaBaiana.autenticacaoUsuario.model.Usuario;
import br.com.provaBaiana.autenticacaoUsuario.repositories.UsuarioRepository;
import br.com.provaBaiana.autenticacaoUsuario.services.UsuarioService;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@Autowired
	private UsuarioRepository repository;

	@CrossOrigin("*")
	@PostMapping("/usuario")
	public ResponseEntity<Object> save(@RequestBody UsuarioDto _usuario) {

		Usuario usuario;
		if (_usuario.validarSenha(_usuario.getSenha())) {
			usuario = new Usuario(_usuario.getLogin(), _usuario.getSenha());
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuario));
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("Erro: Senha não contem" + "os pré-requisitos de uma senha forte");
	}

	@CrossOrigin
	@GetMapping("/usuario")
	public ResponseEntity<List<Usuario>> findAll() {

		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			repository.findAll().forEach(usuarios::add);
			if (usuarios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
