package View;

import java.util.ArrayList;
import java.util.Scanner;

import Helper.Util;
import Model.Cliente;
import Model.Conta;

public class Banco {
	static String nome="geek bank";
	static Scanner teclado=new Scanner(System.in);
	static ArrayList<Conta>contas;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco.contas=new ArrayList<Conta>();
		Banco.menu();
		
	}

	private static void menu() {
		// TODO Auto-generated method stub
		int opc=0;
		System.out.println("=============================");
		System.out.println("\n=============ATM=============\n");
		System.out.println("========"+Banco.nome+"========");
		System.out.println("=============================");
		System.out.println("selecione uma opção abaixo");
		System.out.println("1-criar conta");
		System.out.println("2-saque");
		System.out.println("3-depositos");
		System.out.println("4-transferencia");
		System.out.println("5-listar contas");
		System.out.println("6-sair do sistema");
		try {
			opc=Integer.parseInt(Banco.teclado.nextLine());
			
		}catch(NumberFormatException e) {
			System.out.println("informe uma opção valida");
			Util.pausar(1);
			Banco.menu();
		}
		switch (opc) {
		case 1: 
			Banco.CriarConta();
			break;
		case 2:
			Banco.Saque();
			
			break;
		case 3:
			Banco.Deposito();
			break;
		case 4:
			Banco.Transferencia();
			break;
		case 5:
			Banco.ListarContas();
			break;
		case 6:
			System.out.println("até a proxima");
			Util.pausar(3);
			System.exit(0);
		
		default:
			System.out.println("opção invalida....");
			Util.pausar(2);
			Banco.menu();
			break;
		}
	}

	private static void ListarContas() {
		// TODO Auto-generated method stub
		if(Banco.contas.size()>0) {
			System.out.println("listagem de contas");
			System.out.println("\n");
			for(Conta conta:Banco.contas) {
				System.out.println(conta+"\n");
				Util.pausar(3);
			}
			
		}else {System.out.println("não existem contas cadastradas ainda");}
		
	}

	private static void Transferencia() {
		System.out.println("informe o numero da conta");
		int numero_O=Banco.teclado.nextInt();
		Conta conta_o=Banco.BuscarContaNumero(numero_O);
		if(conta_o !=null) {
			System.out.println("informe o valor da conta de destino:\n");
			int numero_d=Banco.teclado.nextInt();
			int conta_d=Banco.BuscarContaNumero(numero_d);
			if(conta_d !=null) {
				System.out.println("informe o valor da tranferencia:\n");
				Double valor=Banco.teclado.nextDouble();
				conta_o.Transferir(conta_d, valor);
				}else {
					System.out.println("não foi possivel encontrar a conta destino : "+numero_d);
				}Util.pausar(4);
				Banco.menu();
			
			
			
			
		}else {
			System.out.println("não foi possivel encontrar a conta de origem : "+numero_O);
		}Util.pausar(4);
		Banco.menu();
		
	}

	private static Conta BuscarContaNumero(int numero) {
		// TODO Auto-generated method stub
		Conta c=null;
		if(Banco.contas.size()>0) {
			for(Conta conta:Banco.contas) {
				if(conta.getNumero()==numero) {
					c=conta;
				}
			}
		}
		return c;
	}

	private static void Deposito() {
		// TODO Auto-generated method stub
		System.out.println("informe o numero da conta");
		int numero=Banco.teclado.nextInt();
		Conta conta=Banco.BuscarContaNumero(numero);
		if(conta !=null) {
			System.out.println("informe o valor do deposito:\n");
			Double valor=Banco.teclado.nextDouble();
			conta.depositar(valor);
			}else {
				System.out.println("não foi possivel encontrar a conta : "+numero);
			}Util.pausar(4);
			Banco.menu();
		
	}

	private static void Saque() {
		// TODO Auto-generated method stub
		System.out.println("informe o numero da conta");
		int numero=Banco.teclado.nextInt();
		Conta conta=Banco.BuscarContaNumero(numero);
		if(conta !=null) {
			System.out.println("informe o valor do saque:\n");
			Double valor=Banco.teclado.nextDouble();
			conta.sacar(valor);
			
		}else {
			System.out.println("não foi possivel encontrar a conta : "+numero);
		}Util.pausar(4);
		Banco.menu();
		
		
	}

	private static void CriarConta() {
		// TODO Auto-generated method stub
		System.out.println("informe os dados do cliente");
		String nome=Banco.teclado.nextLine();
		System.out.println("email");
		String email=Banco.teclado.nextLine();
		System.out.println(" cpf");
		String cpf=Banco.teclado.nextLine();
		System.out.println("Data de nascimento");
		String dataNasc=Banco.teclado.nextLine();
		
		Cliente cliente=new Cliente(nome,email,cpf,Util.stringParaDate(dataNasc));
		
		Conta conta=new Conta(cliente);
		Banco.contas.add(conta);
		
		System.out.println("conta criada com sucesso \n"+conta+"\n");
		Util.pausar(3);
		Banco.menu();
	}
	
}
