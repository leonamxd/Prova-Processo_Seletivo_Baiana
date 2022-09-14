package br.com.provaBaiana.autenticacaoUsuario.Controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.provaBaiana.autenticacaoUsuario.dtos.UsuarioDto;
import br.com.provaBaiana.autenticacaoUsuario.model.Usuario;
import br.com.provaBaiana.autenticacaoUsuario.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody UsuarioDto _usuario) {
		
		Usuario usuario = new Usuario();
		if (_usuario.validarSenha(_usuario.getSenha())) {
			
			BeanUtils.copyProperties(_usuario, usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuario));
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: Senha não contem"
				+ "os pré-requisitos de uma senha forte");
	}

}
