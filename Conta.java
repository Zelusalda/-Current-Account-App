package contaCorrente;

public class Conta {
	private String numero_Conta;
	private String user;
	private double saldo_Conta;

	public Conta(String numero_Conta, String user ) {
		 this.numero_Conta = numero_Conta;
	     this.user = user;
	     this.saldo_Conta = 0.0; 
	}

	public void saque(double valor) {
		double saldo_Sacado = 10;
		if (saldo_Conta >= saldo_Sacado) {
			saldo_Conta -= saldo_Sacado;
			System.out.println("Saque no valor de R$ " + valor + " realizado com sucesso");
		}else if(saldo_Sacado > saldo_Conta) {
			System.out.println("Saldo insuficiente para saque");
		} else {
			System.out.println("Valor invalido");
		}
	}

	public void deposito(double valor) {
		if (valor > 0) {
			saldo_Conta += valor;
			System.out.println("Depósito no valor de R$ " + valor + " realizado com sucesso.");
		} else {
			System.out.println("Valor de depósito inválido.");
		}
	}
	
	public double consultarSaldo() {
		return saldo_Conta;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public static void sair() {
		System.out.println("Encerrando sessão...");
	}

}
