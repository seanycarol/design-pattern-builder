package builder;

import java.util.Date;

public class UsuarioBuilder {
    private Usuario usuario;

    public UsuarioBuilder() {
        usuario = new Usuario();
    }

    public Usuario build() {
        if (usuario.getEmail().equals("")) {
            throw new IllegalArgumentException("Email inválido");
        }
        if (usuario.getSenha().equals("")) {
            throw new IllegalArgumentException("Senha inválida");
        }
        if (usuario.getConfirmaSenha().equals("")) {
            throw new IllegalArgumentException("Confirma senha inválida");
        }
        if(!usuario.getSenha().equals(usuario.getConfirmaSenha())) {
            throw new IllegalArgumentException("As senhas não são iguais");
        }
        return usuario;
    }

    public UsuarioBuilder setNomeCompleto(String nomeCompleto) {
        usuario.setNomeCompleto(nomeCompleto);
        return this;
    }

    public UsuarioBuilder setCelular(String celular) {
        usuario.setCelular(celular);
        return this;
    }

    public UsuarioBuilder setSexo(String sexo) {
        usuario.setSexo(sexo);
        return this;
    }

    public UsuarioBuilder setDataNascimento(Date dataNascimento) {
        usuario.setDataNascimento(dataNascimento);
        return this;
    }

    public UsuarioBuilder setEmail(String email) {
        usuario.setEmail(email);
        return this;
    }

    public UsuarioBuilder setSenha(String senha) {
        usuario.setSenha(senha);
        return this;
    }

    public UsuarioBuilder setConfirmaSenha(String confirmaSenha) {
        usuario.setConfirmaSenha(confirmaSenha);
        return this;
    }
}
