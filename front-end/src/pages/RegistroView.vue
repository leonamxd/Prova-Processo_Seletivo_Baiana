<template>
    <main>
        <div class="login-page">
            <div class="form">
                <h3>Cadastre um login e senha</h3>
                <form @submit="registrarUsuario">
                      <input
                        placeholder="Login"
                        type="text"
                        class="input-login"
                        v-model="user.login"
                      />
                      <input
                        placeholder="Senha"
                        type="password"
                        class="input-password"
                        v-model="user.Password"
                      />
                        <input type="submit" value="Cadastrar" class="login-button" />
                  </form>
                <!-- <form class="login-form">

                    <input type="text" name="login" placeholder="login" /> <input type="password" name="senha"
                        placeholder="senha" />

                    <h4 class="message">Senha deve conter 'numero', 'letra
                        Maiuscula e minuscula', 'caractere especial'</h4>

                    <br> <input type="password" name="confirmarSenha" placeholder="confirme senha" /> <a
                        href="login.html"><input class="button-cadastrar" type="button" value="Cadastrar"
                            onclick="Javascript:return validarEnvio();"></a>
                </form> -->
            </div>
        </div>
    </main>
</template>

<script>

    import { criarUsuario } from '../services/cadastrar-usuario/cadastrar-usuario';
    import '../styles/main.css';

    export default {
        title:"RegistroView", 
        data: function(){
            return{
                user:{}
            }
        }, 
        methods: {
            async registrarUsuario(e){
                try {
                    e.preventDefault()
                    const resposta = await criarUsuario(this.user);
                    console.log(resposta);
                } catch (error) {
                    console.log(error);
                }
            }
        }
    }

</script>