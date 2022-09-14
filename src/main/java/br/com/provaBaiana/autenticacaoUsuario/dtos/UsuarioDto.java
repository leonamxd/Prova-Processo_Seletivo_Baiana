package br.com.provaBaiana.autenticacaoUsuario.dtos;

public class UsuarioDto {

	private String login;
	private String senha;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
public boolean validarSenha(String _senha) {
		
		if (_senha.length() < 6) {
			return false;
		}
		boolean validarNumero = false;
		boolean validarLetraMaiuscula = false;
		boolean validarLetraMinuscula = false;
		boolean validarCaractereEspecial = false;
		
		for (char caractere : _senha.toCharArray()) {
			if (caractere >= '0' && caractere <= '9') {
				validarNumero = true;
			} else if(caractere >= 'A' && caractere <= 'Z'){
				validarLetraMaiuscula = true;
			}else if(caractere >= 'a' && caractere <= 'z'){
				validarLetraMinuscula = true;
			}
			else {
				validarCaractereEspecial = true;
			}
		}
		return validarNumero && validarLetraMaiuscula && validarLetraMinuscula && validarCaractereEspecial;
	}
}
