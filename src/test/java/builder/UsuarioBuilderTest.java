package builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UsuarioBuilderTest {

    @Test
    public void deveRetornarExcecaoParaUsuarioSemEmail() {
        try {
            UsuarioBuilder usuarioBuilder = new UsuarioBuilder();
            Usuario usuario = usuarioBuilder
                    .setEmail("")
                    .setSenha("123456")
                    .setConfirmaSenha("123456")
                    .build();
            fail();
        }catch (IllegalArgumentException e) {
            assertEquals("Email inválido", e.getMessage());
        }
    }

    @Test
    public void deveRetornarExcecaoParaUsuarioSemSenha() {
        try {
            UsuarioBuilder usuarioBuilder = new UsuarioBuilder();
            Usuario usuario = usuarioBuilder
                    .setEmail("teste@gmail.com")
                    .setSenha("")
                    .setConfirmaSenha("teste123456")
                    .build();
            fail();
        }catch (IllegalArgumentException e) {
            assertEquals("Senha inválida", e.getMessage());
        }
    }

    @Test
    public void deveRetornarExcecaoParaUsuarioSemConfirmaSenha() {
        try {
            UsuarioBuilder usuarioBuilder = new UsuarioBuilder();
            Usuario usuario = usuarioBuilder
                    .setEmail("teste@gmail.com")
                    .setSenha("teste123456")
                    .setConfirmaSenha("")
                    .build();
            fail();
        }catch (IllegalArgumentException e) {
            assertEquals("Confirma senha inválida", e.getMessage());
        }
    }

    @Test
    public void deveRetornarExcecaoParaUsuarioComSenhasDiferentes() {
        try {
            UsuarioBuilder usuarioBuilder = new UsuarioBuilder();
            Usuario usuario = usuarioBuilder
                    .setEmail("teste@gmail.com")
                    .setSenha("teste123456")
                    .setConfirmaSenha("teste654321")
                    .build();
            fail();
        }catch (IllegalArgumentException e) {
            assertEquals("As senhas não são iguais", e.getMessage());
        }
    }

    @Test
    public void deveRetornarUsuarioValido() {

        UsuarioBuilder usuarioBuilder = new UsuarioBuilder();
        Usuario usuario = usuarioBuilder
                .setEmail("teste@gmail.com")
                .setSenha("teste123456")
                .setConfirmaSenha("teste123456")
                .build();

        assertNotNull(usuario);

    }
}