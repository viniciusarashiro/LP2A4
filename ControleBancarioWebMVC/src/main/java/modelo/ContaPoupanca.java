package modelo;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "contaspoupancas")
@PrimaryKeyJoinColumn(name = "numero")
public class ContaPoupanca extends ContaComum
{
	private static final long serialVersionUID = 1l;
	
	@Temporal(TemporalType.DATE)
	private Date aniversario;
	
	public ContaPoupanca(Date aniversario, long numero, Date abertura)
	{
		super(numero, abertura);
		this.aniversario = aniversario;
	}
	
	public Date getAniversario() {
		return aniversario;
	}
	
	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}
}
