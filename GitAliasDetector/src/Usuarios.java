import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import info.debatty.java.stringsimilarity.JaroWinkler;

public class Usuarios {
	private final double _similaridade = 0.95;
	private List<Usuario> usuarios;
	private List<Alias> aliasList;

	public Usuarios() {
		this.usuarios = new ArrayList<Usuario>();
		this.aliasList = new ArrayList<Alias>();
	}

	public void addUsuario(String nome, String email) {
		Usuario user = new Usuario(nome, email);
		if(!usuarioExistente(user)){
			usuarios.add(user);
		}
	}

	private boolean usuarioExistente(Usuario user) {
		for(Usuario usuario : usuarios) {
			if(usuario.equal(user)) return true;
		}
		return false;
	}

	public List<Alias> verificarAlias() {

		for(Usuario usuario : usuarios) {
			if(!usuario.hasAlias()) {
				boolean alias = false;
				int indexUsuario = 0;
				while(!alias && indexUsuario < usuarios.size()) {
					Usuario usuarioParaVerificar = usuarios.get(indexUsuario);
					if(!usuario.equal(usuarioParaVerificar)) {
						if(isAlias(usuario, usuarioParaVerificar)) {
							adicionarAlias(usuario, usuarioParaVerificar);
							alias = true;
						}
					}
					indexUsuario++;

				}
			}
		}
		return aliasList;
	}

	private void adicionarAlias(Usuario usuarioAlias, Usuario usuarioBase) {
		usuarioAlias.setAlias();
		usuarioBase.setAlias();

		Iterator<Alias> aliasParaVerificar = aliasList.iterator();
		boolean adicionou = false;
		while(aliasParaVerificar.hasNext()) {
			Alias alias = aliasParaVerificar.next();
			if(alias.hasUsuario(usuarioBase)) {
				alias.addUsuario(usuarioAlias);
				adicionou = true;
			}
		}

		if(!adicionou) {
			Alias alias = new Alias(usuarioBase.getPrimeiroNome());
			alias.addUsuario(usuarioAlias);
			alias.addUsuario(usuarioBase);

			aliasList.add(alias);
		}
	}

	private boolean isAlias(Usuario usuario1, Usuario usuario2) {
		if(usuario1.getEmail().equalsIgnoreCase(usuario2.getEmail()))
			return true;
		
		JaroWinkler jw = new JaroWinkler();
		double similaridade = jw.similarity(usuario1.getNome(), usuario2.getNome());
		if(similaridade > 0.9){
			
			if(usuario1.getPrefixo().equalsIgnoreCase(usuario2.getPrefixo()))
				return true;


			if(emailNomeSimilar(usuario1, usuario2))
				return true;
			if(emailNomeSimilar(usuario2, usuario1))
				return true;	
		}

		return false;
	}

	private boolean emailNomeSimilar(Usuario usuario1, Usuario usuario2) {
		JaroWinkler jw = new JaroWinkler();

		double similaridade = jw.similarity(usuario1.getPrefixo(), usuario2.getNome());
		if(similaridade > _similaridade)
			return true;
		String[] nomeInfo = usuario2.getNome().split(" ");
		for(int index = 0; index < nomeInfo.length; index++) {
			similaridade = jw.similarity(usuario1.getPrefixo(), nomeInfo[index]);
			if(similaridade > _similaridade)
				return true;
		}
		return false;
	}

	public String imprimirUsuarios() {
		String imprimir = "";
		for(Usuario user : usuarios) {
			imprimir += user.imprimir() + "\n";
		}
		return imprimir;
	}

	public String imprimirAlias() {
		String imprimir = "";
		for(Alias alias : aliasList) {
			imprimir += alias.imprimir() + "\n";
		}
		return imprimir;
	}
}
