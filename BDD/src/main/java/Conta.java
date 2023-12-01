import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Classe que representa uma conta bancária.
 */
public class Conta {

    /**
     * Saldo inicial do cliente especial.
     */
    private double saldoClienteEspecial = -200;

    /**
     * Saldo inicial do cliente comum.
     */
    private double saldoClienteComum = -200;

    /**
     * Flag para identificar o tipo de cliente.
     */
    private boolean isClienteEspecial;

    /**
     * Configura o saldo inicial para um cliente especial ou comum.
     *
     * @param tipoCliente   Tipo de cliente (especial ou comum).
     * @param saldoInicial  Saldo inicial a ser definido para o cliente.
     * @throws Throwable    Exceção lançada em caso de erro.
     */
    @Given("^Um cliente (especial|comum) com saldo atual de -(\\d+) reais$")
    public void um_cliente_com_saldo_atual_de_reais(String tipoCliente, int saldoInicial) throws Throwable {
        if (tipoCliente.equals("especial")) {
            saldoClienteEspecial = -saldoInicial;
            isClienteEspecial = true;
            System.out.println("Saldo inicial do cliente especial: " + saldoClienteEspecial);
        } else {
            saldoClienteComum = -saldoInicial;
            isClienteEspecial = false;
            System.out.println("Saldo inicial do cliente comum: " + saldoClienteComum);
        }
    }

    /**
     * Realiza um saque para o cliente atual.
     *
     * @param valorSaque    Valor a ser sacado.
     * @throws Throwable    Exceção lançada em caso de erro.
     */
    @When("^for solicitado um saque no valor de (\\d+) reais$")
    public void for_solicitado_um_saque_no_valor_de_reais(int valorSaque) throws Throwable {
        if (isClienteEspecial) {
            realizarSaqueClienteEspecial(valorSaque);
        } else {
            realizarSaqueClienteComum(valorSaque);
        }
    }

    /**
     * Verifica se o saque foi efetuado com sucesso e atualiza o saldo da conta.
     *
     * @param novoSaldo     Novo saldo após o saque.
     * @throws Throwable    Exceção lançada em caso de erro.
     */
    @Then("^deve efetuar o saque e atualizar o saldo da conta para -(\\d+) reais$")
    public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(int novoSaldo) throws Throwable {
        if (isClienteEspecial) {
            assert saldoClienteEspecial == -novoSaldo;
            System.out.println("Saldo do cliente comum: " + saldoClienteComum);
            if (saldoClienteComum <= 0) {
                System.out.println("O cliente comum não pode efetuar o saque. Saldo negativo.");
            } else {
                saldoClienteComum -= novoSaldo;
                System.out.println("Novo saldo do cliente comum após saque: " + saldoClienteComum);
            }
        }
    }

    /**
     * Realiza ações adicionais ou verificações, se necessário.
     *
     * @throws Throwable    Exceção lançada em caso de erro.
     */
    @Then("^check more outcomes$")
    public void check_more_outcomes() throws Throwable {
        // Adicione aqui mais verificações ou ações se necessário
        throw new PendingException();
    }

    /**
     * Realiza um saque para um cliente especial.
     *
     * @param valorSaque    Valor a ser sacado pelo cliente especial.
     */
    
    public void realizarSaqueClienteEspecial(double valorSaque) {
        saldoClienteEspecial -= valorSaque;
        System.out.println("Saque de " + valorSaque + " realizado com sucesso para o cliente especial.");
        System.out.println("Novo saldo do cliente especial: " + saldoClienteEspecial);
    }

    /**
     * Realiza um saque para um cliente comum.
     *
     * @param valorSaque    Valor a ser sacado pelo cliente comum.
     */
    public void realizarSaqueClienteComum(double valorSaque) {
        if (saldoClienteComum >= 0) {
            saldoClienteComum -= valorSaque;
            System.out.println("Saque de " + valorSaque + " realizado com sucesso para o cliente comum.");
            System.out.println("Novo saldo do cliente comum: " + saldoClienteComum);
        } else {
            System.out.println("O cliente comum não pode efetuar o saque. Saldo negativo.");
        }
    }

    /**
     * Método principal para execução de testes.
     *
     * @param args          Argumentos passados para o programa.
     * @throws Throwable    Exceção lançada em caso de erro.
     */
    public static void main(String[] args) throws Throwable {
        Conta conta = new Conta();

        // Realizando saque para o cliente especial
        conta.for_solicitado_um_saque_no_valor_de_reais(100);

        // Realizando saque para o cliente comum
        conta.for_solicitado_um_saque_no_valor_de_reais(100);
    }
}
