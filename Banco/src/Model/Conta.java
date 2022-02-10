package Model;

import Helper.Util;

public class Conta {
	private static int codigo=1001;
	private int numero;
	private Cliente cliente;
	private Double saldo=0.0;
	private Double limite=0.0;
	private Double saldo_tot;
	
	
	public Conta(Cliente cliente) {
		this.numero=Conta.codigo;
		this.cliente = cliente;
		Conta.codigo+=1;
		this.AtualizaSaldoTotal();
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Double getLimite() {
		return limite;
	}
	public void setLimite(Double limite) {
		this.limite = limite;
	}
	public Double getSaldo_tot() {
		return saldo_tot;
	}
	public void setSaldo_tot(Double saldo_tot) {
		this.saldo_tot = saldo_tot;
	}
	public Double getSaldo() {
		return saldo;
	}
	private void AtualizaSaldoTotal() {
		this.saldo=this.getSaldo()+this.getLimite();
	}
	@Override
	public String toString() {
		return "Conta numero=" +this.numero + ", cliente=" + getCliente() + ", saldo_tot=" +Util.doubleParaString(getSaldo_tot())+ "]";
	}
	public void depositar(Double valor) {
		if(valor>0) {
			this.saldo=this.getLimite()+valor;
			this.AtualizaSaldoTotal();
			System.out.println("deposito efetuado com sucesso");
			
		}else {
			System.out.println("erro ao efetuar deposito.tente novamente");
		}
	}
	public  void sacar(Double valor) {
		if(valor>0&&this.getSaldo_tot()>=valor) {
			if(this.getSaldo()>=valor) {
				this.saldo=this.getSaldo()-valor;
				this.AtualizaSaldoTotal();
				System.out.println("saque realizado com sucesso");
			}else {
				Double restante=this.getSaldo()-valor;
				this.saldo=0.0;
				this.AtualizaSaldoTotal();
				System.out.println("saque realizado com sucesso");
			}
			
		}else {
			System.out.println("saque não realizado,tente novamente");
		}
	}
	public void Transferir(Conta destino,Double valor) {
		if(valor>0&&this.getSaldo_tot()>=valor) {
			if(this.getSaldo()>=valor) {this.saldo=this.getSaldo()-valor;
			destino.saldo=destino.getSaldo()+valor;
			this.AtualizaSaldoTotal();
			destino.AtualizaSaldoTotal();
			}else {
				Double restante=this.getLimite()-valor;
				this.limite=this.getLimite()-restante;
				this.saldo=0.0;
				destino.saldo= destino.getSaldo() + valor;
				this.AtualizaSaldoTotal();
				destino.AtualizaSaldoTotal();
				System.out.println("transferencia realizada com sucesso");
				
				
			}
			
		}else {
			System.out.println("tranferencia não realizada ,tente novamente");
		}
	}
	
}
