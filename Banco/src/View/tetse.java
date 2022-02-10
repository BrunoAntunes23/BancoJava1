package View;

import Helper.Util;
import Model.Cliente;
import Model.Conta;

public class tetse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente alpha=new Cliente(
				"alpha","alpha@alpha.com","123.456.789.00",
				Util.stringParaDate("01/01/2022")
				);
		
		Cliente beta=new Cliente(
				"beta","beta@beta.com","111.222.333.44",
				Util.stringParaDate("02/02/2022"));
			
	/*	System.out.println(alpha);
		System.out.println("\n");
		System.out.println(beta);*/
		
		Conta C=new Conta(alpha);
		Conta c=new Conta(beta);
		//teste de deposito
		 //valor positivo**
		C.depositar(500.00);
		c.depositar(500.00);
		C.depositar(0.00);
	
		System.out.print(C);
		
		}
		
	}


