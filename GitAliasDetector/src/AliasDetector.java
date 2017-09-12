import java.io.IOException;
import java.util.Iterator;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.revwalk.RevCommit;

public class AliasDetector {

	public static void main(String[] args) {
		String repoName = args[0];
		GitHub gitHub;

		try {
			gitHub = new GitHub(repoName);
			Iterator<RevCommit> commits = gitHub.getCommits();
			Usuarios usuarios = new Usuarios();
			while(commits.hasNext()) {
				RevCommit commit = commits.next();
				String nome = commit.getAuthorIdent().getName();
				String email = commit.getAuthorIdent().getEmailAddress();
				
				usuarios.addUsuario(nome, email);
			}
			
			usuarios.verificarAlias();
			
			System.out.println(usuarios.imprimirAlias());
			
		} catch (InvalidRemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TransportException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (GitAPIException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}


