package banco_ete;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		boolean testeLogico = true, autenticado = false;
		int conta = 0, ag = 0, dvcc = 0, dvcp = 1;
		double saldoCc = 0.0, saldoCp = 0.0, depositoCc, depositoCp, saqueCc, saqueCp;
		String nomeDoUsuario = "";

		do {

			Scanner sc = new Scanner(System.in);

			int menu;

			System.out.println("-----------------------------------------\n");
			System.out.println("|\t   Bem vindo ao Banco ETE\t|\n");
			System.out.println("|Escolha uma opção:\t\t\t|\n");
			System.out.println("|1: Criar uma conta\t\t\t|\n");
			System.out.println("|2: Mostrar saldo\t\t\t|\n");
			System.out.println("|3: Depositar na Conta corrente\t\t|\n");
			System.out.println("|4: Sacar na Conta corrente\t\t|\n");
			System.out.println("|5: Aplicar na Conta poupança\t\t|\n");
			System.out.println("|6: Resgatar da Conta poupança\t\t|\n");
			System.out.println("|7: Exibir contas\t\t\t|\n");
			System.out.println("|0: Para sair\t\t\t\t|\n");
			System.out.println("-----------------------------------------\n");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				if (nomeDoUsuario == "") {
					System.out.println("Digite seu nome: ");
					nomeDoUsuario = sc.next();

					System.out.println("Digite o número de sua agência: ");
					ag = sc.nextInt();

					System.out.println("Digite o número da sua conta: ");
					conta = sc.nextInt();

					System.out.println("\nBem vindo ao Banco ETE: " + nomeDoUsuario + "\n");
					System.out.println("Sua agência é : " + ag + "\n");
					System.out.println("Sua conta corrente é a: " + conta + "-" + dvcc + "\n");
					System.out.println("Sua conta poupança é a: " + conta + "-" + dvcp + "\n");

					autenticado = true;

					int depositoInicial = 0;
					System.out.println("\nVocê deseja fazer um depósito inicial? 1: Sim, 2: Não: ");
					depositoInicial = sc.nextInt();

					// Estrutura condicional baseada na resposta do usuário
					switch (depositoInicial) {
					case 1:
						System.out.println("\nDigite o valor do depósito: R$");
						saldoCc = sc.nextDouble();

						System.out.println("Seu saldo atual é: \n" + "Conta corrente: R$" + saldoCc
								+ "\tConta poupança: R$" + saldoCp + "\n");
						break;

					case 2:
						System.out.println("Tudo bem, escolha uma opção de nosso menu \n\n");
						break;
					}
				} else {
					System.out.println(
							"Desculpe, você já possui uma conta, é permitido apenas um usuário por execução \n\n");
				}
				break;

			case 2:
				// Verificação de autenticação do usuário
				if (autenticado == true) {
					System.out.println("Seu saldo atual na Conta corrente é: R$" + saldoCc + "\n");
					System.out.println("Seu saldo atual na Conta poupança é: R$" + saldoCp + "\n");
				} else {
					System.out
							.println("Desculpe, você precisa criar uma conta, antes de realizar qualquer operação!\n");
				}

				break;

			case 3:
				if (autenticado == true) {
					System.out.println("Digite o valor de depósito: R$");
					depositoCc = sc.nextDouble();

					// Lógica para o depósito na conta
					saldoCc += depositoCc;
					depositoCc = 0.0;

					System.out.println("Operação realizada com sucesso\n\n");
					System.out.println("Seu novo saldo é: R$" + saldoCc + "\n");
				} else {
					System.out
							.println("Desculpe, você precisa criar uma conta, antes de realizar qualquer operação!\n");
				}

				break;

			case 4:
				if (autenticado == true) {
					System.out.println("Digite o valor que você deseja sacar: R$");
					saqueCc = sc.nextDouble();

					// Lógica para garantir que o saque não será maior que o saldo atual na cc
					if (saqueCc > saldoCc) {
						System.out.println("Você não possui saldo suficiente para o saque!\n");
					} else {
						saldoCc -= saqueCc;
						saqueCc = 0.0;
						System.out.println("Operação realizada com sucesso\n\n");
						System.out.println("Seu novo saldo é de: R$" + saldoCc + "\n");
					}
				} else {
					System.out
							.println("Desculpe, você precisa criar uma conta, antes de realizar qualquer operação!\n");
				}

				break;

			case 5:
				if (autenticado == true) {
					System.out.println("Digite o valor que você deseja transferir para a conta poupança: R$");
					depositoCp = sc.nextDouble();

					// Lógica para garantir que a aplicação não será maior que o saldo atual na cc
					if (depositoCp > saldoCc) {
						System.out.println("Você não possui saldo suficiente para a transferência!\n");
					} else {
						saldoCc -= depositoCp;
						saldoCp += depositoCp;
						depositoCp = 0.0;
						System.out.println("Operação realizada com sucesso\n\n");
						System.out.println("Seu novo saldo na Conta corrente é de: R$" + saldoCc + "\n");
						System.out.println("Seu novo saldo na Conta poupança é de: R$" + saldoCp + "\n");
					}
				} else {
					System.out
							.println("Desculpe, você precisa criar uma conta, antes de realizar qualquer operação!\n");
				}
				break;

			case 6:
				if (autenticado == true) {
					System.out.println("Digite o valor que você deseja resgatar da conta poupança: R$");
					saqueCp = sc.nextDouble();

					// Lógica para garantir que o resgate não será maior que o saldo atual na cp
					if (saqueCp > saldoCp) {
						System.out.println("Você não possui saldo suficiente para resgatar!\n");
					} else {
						saldoCp -= saqueCp;
						saldoCc += saqueCp;
						saqueCp = 0.0;
						System.out.println("Operação realizada com sucesso\n\n");
						System.out.println("Seu novo saldo na Conta corrente é de: R$" + saldoCc + "\n");
						System.out.println("Seu novo saldo na Conta poupança é de: R$" + saldoCp + "\n");
					}
				} else {
					System.out
							.println("Desculpe, você precisa criar uma conta, antes de realizar qualquer operação!\n");
				}
				break;

			case 7:
				if (autenticado == true) {
					System.out.println("\n\nSuas contas são:\n");
					System.out.println("Conta corrente: " + conta + "-" + dvcc + "\n");
					System.out.println("Conta poupança: " + conta + "-" + dvcp + "\n\n");
				} else {
					System.out
							.println("Desculpe, você precisa criar uma conta, antes de realizar qualquer operação!\n");
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
				System.out.println("\n\nOpção inválida, por favor, selecione um opção apresentada no menu\n\n");
			}
			
			sc.close();

		} while (testeLogico == true);
		
		
	}
}
