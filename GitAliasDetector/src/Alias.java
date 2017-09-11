import java.util.ArrayList;
import java.util.List;

public class Alias {
	private String nomeAlias;
	private List<Usuario> usuarios;
	

	public Alias(String primeiroNome) {
		this.nomeAlias = primeiroNome;
		usuarios = new ArrayList<Usuario>();
	}

	public boolean hasUsuario(Usuario usuarioBase) {
		for(Usuario user : usuarios) {
			if(user.equal(usuarioBase)) return true;
		}
		return false;
	}

	public void addUsuario(Usuario usuarioAlias) {
		usuarios.add(usuarioAlias);
	}
	
	public String imprimir() {
		String texto = "";
		texto += "Nome do Alias: " + nomeAlias + "\n";
		for(Usuario user : usuarios) {
			texto += "\tNome: " + user.getNome() + "\n";
			texto += "\tE-mail: " + user.getEmail() + "\n";
			texto += "\n";
		}
		return texto;
	}

}
