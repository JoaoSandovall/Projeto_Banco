package br.com.bancomalvader.controller;

import br.com.bancomalvader.dao.UsuarioDAO;
import br.com.bancomalvader.model.Usuario;

public class LoginController {

    private UsuarioDAO usuarioDAO;

    public LoginController() {
        this.usuarioDAO = new UsuarioDAO(); // O Controller usa o DAO
    }

    /**
     * Orquestra a tentativa de login do usuário.
     * @param cpf O CPF digitado na tela.
     * @param senha A senha digitada na tela.
     * @param otp O código OTP digitado na tela.
     * @return Um objeto Usuario se o login for completo, ou null se falhar.
     */
    public Usuario tentarLogin(String cpf, String senha, String otp) {
        // A lógica de negócio fica aqui!
        // Requisito: O login exige senha e OTP. 

        // TODO: Converter a senha para MD5 antes de passar para o DAO.
        String senhaHash = senha; // Simulação

        // 1. Chama o DAO para verificar se o usuário e senha existem no banco.
        Usuario usuario = usuarioDAO.autenticar(cpf, senhaHash);

        // 2. Se o usuário existir, valida o OTP.
        if (usuario != null) {
            if (usuarioDAO.validarOtp(usuario.getId(), otp)) {
                // Sucesso! Registra na auditoria e retorna o usuário.
                usuarioDAO.registrarTentativaLogin(cpf, true); // 
                return usuario; // Login bem-sucedido
            }
        }

        // Se chegou aqui, algo falhou (usuário/senha ou OTP).
        usuarioDAO.registrarTentativaLogin(cpf, false); // 
        return null; // Login falhou
    }
}