import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Conta {
    private double saldoClienteEspecial = -200; // Saldo inicial do cliente especial
    private double saldoClienteComum = -200; // Saldo inicial do cliente comum
    private boolean isClienteEspecial; // Flag para identificar o tipo de cliente

    @Given("^Um cliente (especial|comum) com saldo atual de -(\\d+) reais$")
    public void um_cliente_com_saldo_atual_de_reais(String tipoCliente, int saldoInicial) throws Throwable {
        if (tipoCliente.equals("especial")) {
            saldoClienteEspecial = -saldoInicial; // Define o saldo inicial do cliente especial
            isClienteEspecial = true;
            System.out.println("Saldo inicial do cliente especial: " + saldoClienteEspecial);
        } else {
            saldoClienteComum = -saldoInicial; // Define o saldo inicial do cliente comum
            isClienteEspecial = false;
            System.out.println("Saldo inicial do cliente comum: " + saldoClienteComum);
        }
    }

    @When("^for solicitado um saque no valor de (\\d+) reais$")
    public void for_solicitado_um_saque_no_valor_de_reais(int valorSaque) throws Throwable {
        if (isClienteEspecial) {
            realizarSaqueClienteEspecial(valorSaque); // Realiza o saque para o cliente especial
        } else {
            realizarSaqueClienteComum(valorSaque); // Realiza o saque para o cliente comum
        }
    }

    @Then("^deve efetuar o saque e atualizar o saldo da conta para -(\\d+) reais$")
    public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(int novoSaldo) throws Throwable {
        if (isClienteEspecial) {
            assert saldoClienteEspecial == -novoSaldo;
            System.out.println("Saldo do cliente comum: " + saldoClienteComum);
            if (saldoClienteComum <= 0) {
            	System.out.println("O cliente comum não pode efetuar o saque. Saldo negativo.");
                
            } else {
            	saldoClienteComum -= novoSaldo; // Atualiza o saldo do cliente comum após o saque
                System.out.println("Novo saldo do cliente comum após saque: " + saldoClienteComum);
            }}
    }

    @Then("^check more outcomes$")
    public void check_more_outcomes() throws Throwable {
        // Adicione aqui mais verificações ou ações se necessário
        throw new PendingException();
    }

    public void realizarSaqueClienteEspecial(double valorSaque) {
        saldoClienteEspecial -= valorSaque; // Atualiza o saldo do cliente especial após o saque
        System.out.println("Saque de " + valorSaque + " realizado com sucesso para o cliente especial.");
        System.out.println("Novo saldo do cliente especial: " + saldoClienteEspecial);
    }

    public void realizarSaqueClienteComum(double valorSaque) {
        if (saldoClienteComum >= 0) {
            saldoClienteComum -= valorSaque; // Atualiza o saldo do cliente comum após o saque
            System.out.println("Saque de " + valorSaque + " realizado com sucesso para o cliente comum.");
            System.out.println("Novo saldo do cliente comum: " + saldoClienteComum);
        } else {
            System.out.println("O cliente comum não pode efetuar o saque. Saldo negativo.");
        }
    }

    public static void main(String[] args) throws Throwable {
        Conta conta = new Conta();

        // Realizando saque para o cliente especial
        conta.for_solicitado_um_saque_no_valor_de_reais(100);

        // Realizando saque para o cliente comum
        conta.for_solicitado_um_saque_no_valor_de_reais(100);
    }
}
