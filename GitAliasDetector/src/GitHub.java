import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

public class GitHub {

	private Git git;	
	private Repository gitRepository;
	private String repoName;

	public GitHub(String repoName) throws InvalidRemoteException, TransportException, IOException, GitAPIException {
		this.repoName = repoName;
		this.getRepository();
	}

	public void getRepository () throws IOException, InvalidRemoteException, TransportException, GitAPIException{
		String URI = repoName + ".git";
		String[] URIinfo = URI.split("/");
		String dir = URIinfo[URIinfo.length-1].substring(0, URIinfo[URIinfo.length-1].length()-4);

		//Clone the respository in this project's directory
		String direc = System.getProperty("user.dir");
		dir = direc + "-Repository-" + dir;

		git = Git.cloneRepository()
				.setURI( URI )
				.setDirectory( new File(dir) )
				.call();

		System.out.println("\nRepository cloned to the root directory.\n");
		File gitDir = new File(dir + "/.git");

		RepositoryBuilder builder = new RepositoryBuilder();

		gitRepository = builder.setGitDir(gitDir).readEnvironment()
				.findGitDir().build();

	}

	public Iterator<RevCommit> getCommits() throws NoHeadException, GitAPIException{
		Iterable<RevCommit> logs = git.log().call();
		return logs.iterator();
	}

}
