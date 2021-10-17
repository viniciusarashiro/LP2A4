package modelo;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.persistence.*;

@Entity
@Table(name = "constascomuns")
public class ContaComum implements Serializable
{
	private static final long serialVersionUID = 1l;
	
	
	@Id
	protected final long numero;
	
	@Column(name = "data_abertura")
	@Temporal(TemporalType.TIMESTAMP)
	protected final Date abertura;
	
	@Column(name = "data_fechamento")
	@Temporal(TemporalType.TIMESTAMP)
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
		
		//Estratégia para gerar um número de conta (pseudo)aleatório.
		Random r = new Random();
		
		long n = r.nextLong() + 1;
		
		if(n < 0) {
			n = n *(-1);
		}
		
		//Data de abertura da conta
		Date abertura = new Date();
		
		//Criação da conta
		ContaComum cc = new ContaComum(n , abertura);
		
		return cc;
		
	}
	
}
