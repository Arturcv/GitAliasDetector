
public class Usuario {
	private String nome;
	private String email;
	private String prefixo;
	private boolean temAlias;
	
	public Usuario (String nome, String email) {
		this.nome = nome;
		this.email = email;
		if(email.indexOf("@") < 0)
			this.prefixo = email;
		else
			this.prefixo = email.substring(0, email.indexOf("@"));
		this.temAlias = false;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPrefixo() {
		return prefixo;
	}
	
	public String getPrimeiroNome() {
		String[] nomeInfo = nome.split(" ");
		return nomeInfo[0];
	}
	
	public boolean hasAlias() {
		return this.temAlias;
	}
	
	public void setAlias() {
		this.temAlias = true;
	}
	
	public boolean equal(Usuario commit) {
		return (nome.equalsIgnoreCase(commit.getNome())) && (email.equalsIgnoreCase(commit.getEmail()));
	}
	
	public String imprimir() {
		String texto = "";
		//texto += "Nome do Usuario: " + nome + "\n";
		//texto += "E-mail: " + email + "\n";
		texto += nome + " ; " + email;
		return texto;
	}
}
