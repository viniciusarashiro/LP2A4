package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "movimentos")
public class Movimento implements Serializable
{
	private static final long serialVersionUID = 1l;
	
	@Id
	private int id;
	
	@Column(name = "data_hora")
	@Temporal(TemporalType.DATE)
	private Date datahora;
	private double valor;
	
	public Movimento(double valor) {
		Date datahora = new Date();
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
}
