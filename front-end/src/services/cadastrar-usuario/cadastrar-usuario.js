import axios from 'axios';

export async function criarUsuario(data) {
    try {
      const resposta = await axios.post('http://localhost:8080/usuarios', data);
      return resposta;
    } catch (error) {
      return error;
    }
  }
  
  

