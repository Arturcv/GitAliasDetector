import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

public class AliasDetector {

	public static void main(String[] args) {
		/*Scanner ler = new Scanner(System.in);
		String s;
		System.out.printf("Informe a URL do repositorio:\n");
		s = ler.next();
		ler.close();
		 */
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
				
				//System.out.println(commit.getAuthorIdent().getName() + " ; " + commit.getAuthorIdent().getEmailAddress());
			}
			
			List<Alias> aliasList = usuarios.verificarAlias();
			
			String imprimir = "";
			for(Alias alias : aliasList) {
				imprimir += alias.imprimir();
			}
			System.out.println(imprimir);
			
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


