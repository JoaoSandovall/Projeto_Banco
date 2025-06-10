package br.com.bancomalvader.controller;

// importações para DAO e Model aqui...

public class ClienteController {

    public ClienteController() {
        // Inicializar os DAOs necessários (ContaDAO, TransacaoDAO)
    }

    public double consultarSaldo(int idConta) {
        // Requisito: Exibe saldo e projeção de rendimentos. 
        // TODO: Chamar o ContaDAO para buscar o saldo da conta com id 'idConta'.
        System.out.println("Controller: Consultando saldo da conta " + idConta);
        return 1500.75; // Simulação
    }

    public boolean realizarSaque(int idConta, double valor) {
        // Requisito: Verifica saldo + limite; aplica taxa para saques excessivos. 
        // TODO:
        // 1. Chamar o ContaDAO para verificar o saldo/limite.
        // 2. Se o saldo for suficiente, chamar o TransacaoDAO para registrar o saque.
        //    (O trigger no banco vai atualizar o saldo automaticamente).
        // 3. Retornar true se o saque foi bem-sucedido.
        System.out.println("Controller: Tentando sacar " + valor + " da conta " + idConta);
        return true; // Simulação
    }

    public boolean realizarTransferencia(int idContaOrigem, int idContaDestino, double valor) {
        // Requisito: Transferência entre contas com validação e taxa. 
        // TODO:
        // 1. Chamar o ContaDAO para validar se a conta de origem tem saldo.
        // 2. Chamar o ContaDAO para validar se a conta de destino existe.
        // 3. Chamar o TransacaoDAO para registrar a transferência.
        System.out.println("Controller: Transferindo " + valor + " da conta " + idContaOrigem + " para " + idContaDestino);
        return true; // Simulação
    }

    // Outros métodos: realizarDeposito, emitirExtrato, consultarLimite...
}