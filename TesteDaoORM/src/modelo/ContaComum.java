package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class ContaComum 
{
	protected final long numero;
	protected final Date abertura;
	protected Date fechamento;
	protected byte situacao;
	protected int senha;
	protected double saldo;
	
	protected ArrayList<Pessoa> titulares;
	
	public ContaComum(long numero, Date abertura) {
		this.numero = numero;
		this.abertura = abertura;
		
		this.saldo = 0.0;
		this.situacao = 1;
		
		this.titulares = new ArrayList<Pessoa>();
	}
	
	public Date getFechamento() {
		return fechamento;
	}
	public void setFechamento(Date fechamento) {
		this.fechamento = fechamento;
	}
	public byte getSituacao() {
		return situacao;
	}
	public void setSituacao(byte situacao) {
		this.situacao = situacao;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public long getNumero() {
		return numero;
	}
	public Date getAbertura() {
		return abertura;
	}

	public ArrayList<Pessoa> getTitulares() {
		return titulares;
	}

	public void setTitulares(ArrayList<Pessoa> titulares) {
		this.titulares = titulares;
	}
	
	public static ContaComum abrirConta() {
		
		//Estrat�gia para gerar um n�mero de conta (pseudo)aleat�rio.
		Random r = new Random();
		
		long n = r.nextLong() + 1;
		
		if(n < 0) {
			n = n *(-1);
		}
		
		//Data de abertura da conta
		Date abertura = new Date();
		
		//Cria��o da conta
		ContaComum cc = new ContaComum(n , abertura);
		
		return cc;
		
	}
	
}
