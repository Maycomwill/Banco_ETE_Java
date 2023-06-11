package banco_ete;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		boolean testeLogico = true, autenticado = false;
		int conta = 0, ag = 0, dvcc = 0, dvcp = 1;
		double saldoCc = 0.0, saldoCp = 0.0, depositoCc, depositoCp, saqueCc, saqueCp;
		String nomeDoUsuario = "";

		Scanner sc = new Scanner(System.in);

		do {

			int menu;

			System.out.println("-----------------------------------------\n");
			System.out.println("|\t   Bem vindo ao Banco ETE\t|\n");
			System.out.println("|Escolha uma opcao:\t\t\t|\n");
			System.out.println("|1: Criar uma conta\t\t\t|\n");
			System.out.println("|2: Mostrar saldo\t\t\t|\n");
			System.out.println("|3: Depositar na Conta corrente\t\t|\n");
			System.out.println("|4: Sacar na Conta corrente\t\t|\n");
			System.out.println("|5: Aplicar na Conta poupanca\t\t|\n");
			System.out.println("|6: Resgatar da Conta poupanca\t\t|\n");
			System.out.println("|7: Exibir contas\t\t\t|\n");
			System.out.println("|0: Para sair\t\t\t\t|\n");
			System.out.println("-----------------------------------------\n");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				if (nomeDoUsuario == "") {
					System.out.println("Digite seu nome: ");
					sc.nextLine();
					nomeDoUsuario = sc.nextLine();

					System.out.println("Digite o numero de sua agencia: ");
					ag = sc.nextInt();

					System.out.println("Digite o numero da sua conta: ");
					conta = sc.nextInt();

					System.out.println("\nBem vindo ao Banco ETE: " + nomeDoUsuario + "\n");
					System.out.println("Sua agencia e: " + ag + "\n");
					System.out.println("Sua conta corrente e: " + conta + "-" + dvcc + "\n");
					System.out.println("Sua conta poupanca e: " + conta + "-" + dvcp + "\n");

					autenticado = true;

					int depositoInicial = 0;
					System.out.println("\nVoce deseja fazer um deposito inicial? 1: Sim, 2: Nao: ");
					depositoInicial = sc.nextInt();

					// Estrutura condicional baseada na resposta do usuário
					switch (depositoInicial) {
					case 1:
						System.out.println("\nDigite o valor do deposito: R$");
						depositoCc = sc.nextDouble();

						if (depositoCc > 0) {
							saldoCc += depositoCc;
							depositoCc = 0.0;
							System.out.println("Seu saldo atual e: \n" + "Conta corrente: R$" + saldoCc
									+ "\tConta poupanca: R$" + saldoCp + "\n");
						} else {
							System.out.println("O valor de deposito deve ser maior que zero.");
						}
						break;

					case 2:
						System.out.println("Tudo bem, escolha uma opcao de nosso menu \n\n");
						break;
					}
				} else {
					System.out.println(
							"Desculpe, voce ja possui uma conta, e permitido apenas um usuario por execucao \n\n");
				}
				break;

			case 2:
				// Verificação de autenticação do usuário
				if (autenticado == true) {
					System.out.println("Seu saldo atual na Conta corrente e: R$" + saldoCc + "\n");
					System.out.println("Seu saldo atual na Conta poupanca e: R$" + saldoCp + "\n");
				} else {
					System.out
							.println("Desculpe, voce precisa criar uma conta, antes de realizar qualquer operacao!\n");
				}

				break;

			case 3:
				if (autenticado == true) {
					System.out.println("Digite o valor de deposito: R$");
					depositoCc = sc.nextDouble();

					// Lógica para o depósito na conta
					if (depositoCc > 0) {
						saldoCc += depositoCc;
						depositoCc = 0.0;
						System.out.println("Operacao realizada com sucesso\n\n");
						System.out.println("Seu novo saldo e: R$" + saldoCc + "\n");
					} else {
						System.out.println("O valor de deposito deve ser maior que zero.");
					}

				} else {
					System.out
							.println("Desculpe, voce precisa criar uma conta, antes de realizar qualquer operacao!\n");
				}

				break;

			case 4:
				if (autenticado == true) {
					System.out.println("Digite o valor que voce deseja sacar: R$");
					saqueCc = sc.nextDouble();

					// Lógica para garantir que o saque não será maior que o saldo atual na cc
					if (saqueCc > saldoCc) {
						System.out.println("Você nao possui saldo suficiente para o saque!\n");
					} else {
						saldoCc -= saqueCc;
						saqueCc = 0.0;
						System.out.println("Operacao realizada com sucesso\n\n");
						System.out.println("Seu novo saldo e de: R$" + saldoCc + "\n");
					}
				} else {
					System.out
							.println("Desculpe, voce precisa criar uma conta, antes de realizar qualquer operacao!\n");
				}

				break;

			case 5:
				if (autenticado == true) {
					System.out.println("Digite o valor que voce deseja transferir para a conta poupanca: R$");
					depositoCp = sc.nextDouble();

					// Lógica para garantir que a aplicação não será maior que o saldo atual na cc
					if (depositoCp > saldoCc) {
						System.out.println("Você nao possui saldo suficiente para a transferencia!\n");
					} else {
						saldoCc -= depositoCp;
						saldoCp += depositoCp;
						depositoCp = 0.0;
						System.out.println("Operacao realizada com sucesso\n\n");
						System.out.println("Seu novo saldo na Conta corrente e de: R$" + saldoCc + "\n");
						System.out.println("Seu novo saldo na Conta poupança e de: R$" + saldoCp + "\n");
					}
				} else {
					System.out
							.println("Desculpe, voce precisa criar uma conta, antes de realizar qualquer operacao!\n");
				}
				break;

			case 6:
				if (autenticado == true) {
					System.out.println("Digite o valor que voce deseja resgatar da conta poupanca: R$");
					saqueCp = sc.nextDouble();

					// Lógica para garantir que o resgate não será maior que o saldo atual na cp
					if (saqueCp > saldoCp) {
						System.out.println("Voce nao possui saldo suficiente para resgatar!\n");
					} else {
						saldoCp -= saqueCp;
						saldoCc += saqueCp;
						saqueCp = 0.0;
						System.out.println("Operacao realizada com sucesso\n\n");
						System.out.println("Seu novo saldo na Conta corrente e de: R$" + saldoCc + "\n");
						System.out.println("Seu novo saldo na Conta poupança e de: R$" + saldoCp + "\n");
					}
				} else {
					System.out
							.println("Desculpe, voce precisa criar uma conta, antes de realizar qualquer operacao!\n");
				}
				break;

			case 7:
				if (autenticado == true) {
					System.out.println("\n\nSuas contas sao:\n");
					System.out.println("Conta corrente: " + conta + "-" + dvcc + "\n");
					System.out.println("Conta poupanca: " + conta + "-" + dvcp + "\n\n");
				} else {
					System.out
							.println("Desculpe, voce precisa criar uma conta, antes de realizar qualquer operacao!\n");
				}
				break;

			case 0:
				System.out.println("Obrigado por usar o Banco ETE, volte sempre!\n\n");

				// Remoção da autenticação do usuário
				autenticado = false;

				// Alteração do valor da variável, responsável pelo fim do loop do menu
				testeLogico = false;
				break;

			default:
				System.out.println("\n\nOpcao invalida, por favor, selecione um opcao apresentada no menu\n\n");
			}

		} while (testeLogico == true);

		sc.close();

	}
}
