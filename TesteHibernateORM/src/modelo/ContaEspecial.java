package modelo;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "contasespeciais")
@PrimaryKeyJoinColumn(name = "numero")
public class ContaEspecial extends ContaComum
{
	private static final long serialVersionUID = 1l;
	
	private double limite;
	
	public ContaEspecial(double limite, long numero, Date abertura)
	{
		super(numero, abertura);
		this.limite = limite;
	}
	
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public double getLimite() {
		return limite;
	}
}
