package modelo;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;
import javax.persistence.*;

@Entity
@Table(name = "contascomuns")
@Inheritance(strategy = InheritanceType.JOINED)
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
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	protected Collection<Movimento> movimentos;
	
	public ContaComum(long numero, Date abertura)
	{
		this.numero = numero;
		this.abertura = abertura;		
		this.saldo = 0.0;
		this.situacao = 1;
	}
	
	public ContaComum()
	{
		this.numero = ContaComum.obterNumeroContaAleatorio();
		this.abertura = new Date();		
		this.saldo = 0.0;
		this.situacao = 1;
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
	
	public Collection<Movimento> getMovimentos() {
		return this.movimentos;
	}
	
	public static long obterNumeroContaAleatorio()
	{
		// Gerar um número de conta (pseudo)aleatório.
		Random r = new Random();
		long n = r.nextLong();
		if(n < Long.MAX_VALUE && n != -1) n++;
		if(n < 0) n = n*(-1);
		return n;
	}
	
	
	public void Registra(Movimento movimento) 
	{
		this.movimentos.add(movimento);
		this.saldo += movimento.getValor();
		
	}
	
}
