public class App {
    public static void main(String[] args) throws Exception {
        
        Cliente abraao = new Cliente();
		abraao.setNome("Abraao");
		
		Conta cc = new ContaCorrente(abraao);
		Conta poupanca = new ContaPoupanca(abraao);

		cc.depositar(200);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
    }
}
