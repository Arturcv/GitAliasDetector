import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Usuarios {
	private List<Usuario> usuarios;
	private List<Alias> aliasList;

	public Usuarios() {
		this.usuarios = new ArrayList<Usuario>();
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
		Iterator<Usuario> usuariosSendoVerificado = usuarios.iterator();
		Iterator<Usuario> usuariosParaVerificar = usuarios.iterator();

		while(usuariosSendoVerificado.hasNext()) {
			Usuario usuario = usuariosSendoVerificado.next();
			if(!usuario.hasAlias()) {
				boolean alias = false;
				while(!alias && usuariosParaVerificar.hasNext()) {
					Usuario usuarioParaVerificar = usuariosParaVerificar.next();
					if(!usuario.equal(usuarioParaVerificar)) {
						if(isAlias(usuario, usuarioParaVerificar)) {
							adicionarAlias(usuario, usuarioParaVerificar);
							alias = true;
						}
					}
				}
			}
		}

		return null;
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
		// TODO Auto-generated method stub
		return false;
	}
}
