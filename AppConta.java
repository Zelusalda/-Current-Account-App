package contaCorrente;

import java.util.Scanner;

public class AppContaCorrente {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite o número da conta: ");
		String numero = scanner.nextLine();
		System.out.print("Digite o nome do correntista: ");
		String usuario = scanner.nextLine();

		Conta conta = new Conta(numero, usuario);
		dialog(numero, usuario, conta);
	}

	public static void dialog(String n, String us, Conta conta) {
		Scanner scanner = new Scanner(System.in);
		int caso;
		String numero = n;
		String user = us;
		do {
			System.out.println("Digite qual função quer usar:");
			System.out.println("(1) Saque:");
			System.out.println("(2) Deposito:");
			System.out.println("(3) Consulta Saldo:");
			System.out.println("(4) Sair:");
			caso = scanner.nextInt();

			switch (caso) {
			case 1:
				System.out.print("Digite o valor do saque ");
				System.out.println("seu saldo atual é de: ");
				System.out.println(conta.consultarSaldo());
				double valorSaque = scanner.nextDouble();
				conta.saque(valorSaque);
				break;
			case 2:
				System.out.println("Digite o valor do deposito: ");
				double valorDeposito = scanner.nextDouble();
				conta.deposito(valorDeposito);
				break;

			case 3:
				System.out.printf("Saldo atual: R$ %.2f%n", conta.consultarSaldo());
				System.out.println("Digite 1 para voltar ao menu");
				System.out.println("Digite 2 para sair");
				int escolher = scanner.nextInt();
				do {
					if (escolher == 2) {
						Conta.sair();
						caso = 4;
					} else if (escolher == 1) {
						dialog(numero, user, conta);
						caso = 4;
					} else {
						System.out.println("Numero invalido, digite novamente!");
						escolher = scanner.nextInt();
					}
				} while (escolher != 1 && escolher != 2);
				break;
			case 4:
				Conta.sair();
				break;
			default:
				System.out.println("Valor invalido!");
				for (int i = 0; i < 10; i++) {
					System.out.println(" ");
				}
				dialog(numero, user, conta);
				break;
			}
		} while (caso != 4);
		scanner.close();

	}

}
