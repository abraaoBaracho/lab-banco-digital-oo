public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (saldo - valor >= 0) {
            saldo -= valor;
            System.out.println("O valor " + valor + " foi sacado e seu saldo restante é: " + saldo);
        } else {
            System.out.println("saldo insuficiente");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("O valor " + valor + " foi depositado e seu novo saldo é: " + saldo);
        } else {
            System.out.println("valor invalido");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (saldo - valor >= 0) {
            saldo -= valor;
            contaDestino.depositar(valor);
            System.out.println("O valor " + valor + " foi trasferido e seu saldo restante é: " + saldo);
        } else {
            System.out.println("saldo insuficiente");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

}
