package br.com.bancomalvader.dao;

import br.com.bancomalvader.model.Usuario;

public class UsuarioDAO {

    /**
     * Autentica um usuário no banco de dados.
     * @param cpf O CPF do usuário.
     * @param senha A senha (já em hash MD5, por exemplo).
     * @return Um objeto Usuario se a autenticação for bem-sucedida, ou null caso contrário.
     */
    public Usuario autenticar(String cpf, String senha) {
        // TODO: Implementar a lógica SQL para:
        // 1. Conectar ao banco de dados.
        // 2. Fazer um "SELECT * FROM usuario WHERE cpf = ? AND senha_hash = ?".
        // 3. Se encontrar o usuário, criar um objeto Usuario e retorná-lo.
        // 4. Se não encontrar, retornar null.

        System.out.println("DAO: Tentando autenticar usuário com CPF: " + cpf);
        // Simulação: se o CPF for "admin", o login funciona.
        if ("admin".equals(cpf)) {
            Usuario usuarioSimulado = new Usuario();
            usuarioSimulado.setId(1);
            usuarioSimulado.setCpf(cpf);
            usuarioSimulado.setNome("Administrador");
            usuarioSimulado.setTipoUsuario("FUNCIONARIO");
            return usuarioSimulado;
        }
        return null;
    }

    /**
     * Registra uma tentativa de login na tabela de auditoria. 
     * @param cpf O CPF que tentou logar.
     * @param sucesso Se o login teve sucesso ou não.
     */
    public void registrarTentativaLogin(String cpf, boolean sucesso) {
        // TODO: Implementar a lógica SQL para:
        // 1. Inserir um registro na tabela `auditoria`. 
        // Ex: INSERT INTO auditoria (id_usuario, acao, detalhes) VALUES (?, 'LOGIN', ?);
        // Onde `detalhes` pode ser 'Sucesso' ou 'Falha'.

        System.out.println("DAO: Registrando tentativa de login para CPF " + cpf + ". Resultado: " + (sucesso ? "Sucesso" : "Falha"));
    }

    /**
     * Busca o OTP ativo e sua expiração no banco.
     */
    public boolean validarOtp(int idUsuario, String otp) {
        // TODO: Implementar a lógica SQL para:
        // SELECT otp_ativo, otp_expiracao FROM usuario WHERE id_usuario = ?
        // Verificar se o OTP bate e se a data de expiração é maior que NOW().

        System.out.println("DAO: Validando OTP " + otp + " para o usuário " + idUsuario);
        // Simulação: qualquer OTP com 6 dígitos funciona.
        return otp != null && otp.length() == 6;
    }
}