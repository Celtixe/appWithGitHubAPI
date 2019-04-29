package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import code.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.eclipse.egit.github.core.Repository;

/**
 * @author Mikolaj Miller
 *Tests for getLastModRepo() method in Reader class
 */

class getLastModRepoTest {

	Reader test = new Reader();
	List<Repository> repos = null;
	String output = null;
	Repository temp1 = new Repository();
	Repository temp2 = new Repository();
	

	@Test
	void testEmptyCollection() throws IOException {	
		//firstly we test against the case with 0 public repos
		repos = new ArrayList<>();
		
		output = test.getLastModRepo(repos);
		assertEquals("This user does not have any public repositories.", output );
	}
	
	@Test
	void testUnknownUser() throws IOException {
		//provided below username does not exit
		repos = test.getRepos("dafgrfasgawfwedsf");
		output = test.getLastModRepo(repos);
		assertEquals("This user is not recognized.", output );
	}
	
	
	@Test
	void testOneRepo() throws IOException {
		//creates a new repo and adds it to the list as the only one inside
		temp1.setName("repo1");
		temp1.setPushedAt(new Date(10000000));
		repos = Arrays.asList(temp1);
		output = test.getLastModRepo(repos);
		assertEquals("The name of lastly modified user's repository is: repo1", output );
	}
		
	@Test
	void testMultipleRepos() throws IOException {
		//tests the date comparison
		temp1.setName("repo1");
		temp1.setPushedAt(new Date(10000000));
		temp2.setName("repo2");
		temp2.setPushedAt(new Date(20000000));
		repos = Arrays.asList(temp1, temp2);
		output = test.getLastModRepo(repos);
		assertEquals("The name of lastly modified user's repository is: repo2", output );
	}
		
		

}


