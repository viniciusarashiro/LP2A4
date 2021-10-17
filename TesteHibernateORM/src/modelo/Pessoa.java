package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;


@Entity
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable
{
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	@Column(length = 255)
	protected String nome;
	
	@Column(length = 255)
	protected String endereco;
	
	protected long cep;
	
	@Column(length = 17)
	protected String telefone;
	
	protected float renda;
	
	protected byte situacao;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	protected ArrayList<ContaComum> contas; 
	
	public Pessoa() {
		this.situacao = 1;
		
		this.contas = new ArrayList<ContaComum>();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public long getCep() {
		return cep;
	}

	public void setCep(long cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public float getRenda() {
		return renda;
	}

	public void setRenda(float renda) {
		this.renda = renda;
	}

	public byte getSituacao() {
		return situacao;
	}

	public void setSituacao(byte situacao) {
		this.situacao = situacao;
	}

	public ArrayList<ContaComum> getContas() {
		return contas;
	}

	public void setContas(ArrayList<ContaComum> contas) {
		this.contas = contas;
	}
	
	
}
