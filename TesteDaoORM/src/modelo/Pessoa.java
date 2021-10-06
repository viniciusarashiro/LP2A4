package modelo;

public class Pessoa {
	protected int id;
	protected String nome;
	protected String endereco;
	protected long cep;
	protected String telefone;
	protected float renda;
	protected byte situacao;
	
	public Pessoa() {
		this.situacao = 1;
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
	
	
}
