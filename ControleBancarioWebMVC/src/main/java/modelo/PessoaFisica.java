package modelo;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "pessoasfisicas")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaFisica extends Pessoa
{
	private static final long serialVersionUID = 1l;
	

	@Column(nullable = false)
	private long cpf;
	
	@Column(name = "data_nascto")
	@Temporal(TemporalType.DATE)
	private Date nascto;
	
	public long getCpf() {
		return cpf;
	}
	
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	public Date getNascto() {
		return nascto;
	}
	
	public void setNascto(Date nascto) {
		this.nascto = nascto;
	}
}
