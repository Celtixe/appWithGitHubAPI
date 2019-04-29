package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.eclipse.egit.github.core.Repository;
import org.junit.jupiter.api.Test;

import code.Reader;
/**
 * 
 * @author Mikolaj Miller
 *Tests for getReposTest() method in Reader class
 */
class getReposTest {

	Reader test = new Reader();
	String name = "";
	List<Repository> output = null;
	
	@Test
	void testEmptyString() throws IOException {
		output = test.getRepos(name);
		assertEquals(null, output );
	}
	
	@Test
	void testNull() throws IOException {
		name = null;
		output = test.getRepos(name);
		assertEquals(null, output );
	}

}
