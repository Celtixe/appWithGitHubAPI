package code;

import java.io.IOException;
import java.util.List;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.service.RepositoryService;

/**
 * Main class responsible for retrieving the name of lastly modified users repository.
 * @author Mikolaj Miller
 *
 */
public class Reader {
	/**
	 * Gets the name of lastly modified repository, checks if the list of repos is empty
	 * @param repos
	 * @return String with the name of lastly modified repository or sentence stating there are none
	 * @throws IOException
	 */
	 public String getLastModRepo(List<Repository> repos) throws IOException{
		
		if(repos == null) return "This user is not recognized.";
		
		if(repos.size() == 0) return "This user does not have any public repositories.";
		
		//gets the first repo from the list
		Repository temp =  repos.get(0);
			
		for (Repository repo : repos) {
			   if(temp.getPushedAt().compareTo(repo.getPushedAt()) < 0 )
				   temp = repo;
		}	  
		
		return "The name of lastly modified user's repository is: " + temp.getName();
	}
	 
	 /**
	  * Get all repositories for the given user, returns null if not found
	  * @param name the string representing github username
	  * @return the List of Repository object, all repos from the given user
	  * @throws IOException
	  */
	 public List<Repository> getRepos(String name) throws IOException{
			RepositoryService service = new RepositoryService();
			List<Repository> repos = null;
			
			if(name == null || name == "") return repos;
			
			try {
				repos = service.getRepositories(name);
			} catch (IOException e) {}
			
			return repos;
	 }
}
