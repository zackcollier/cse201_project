import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ApplicationTest {
	private AppOrganizationTool AOT;
    private Application APP;
    private User userCommenter;
    
    @Before
	public void setUp() {
		AOT = new AppOrganizationTool();
		APP = new Application("App", "", "sampleCompany", "", "", "");
		userCommenter = new User("testName", "passwd");
	}
	
	@Test
	public void testCommentSystem() {	
		// Create User
    	User user = new User("testName", "passwd");
    	user.signUp(AOT);
    	// User Login
    	user.login(AOT, user.username, "passwd");
    	AOT.currentUser.equals(user);
		// Comment
    	user.comment(AOT, APP, "A");
    	assertTrue(user.username.equals(userCommenter.username));
	}

	@Test
	public void testCalcAvgRating() {
		User user1 = new User("user1", "sample");
		User user2 = new User("user2", "sample");
		User user3 = new User("user3", "sample");
		user1.signUp(AOT);
		user2.signUp(AOT);
		user3.signUp(AOT);
		user1.login(AOT, user1.username, user1.password);
		assertTrue(user1.rating(AOT, APP, 10.0f));
		APP.calcAvgRating();
		assertTrue(APP.averageRating < 10.0 + 0.00001 && APP.averageRating > 10 - 0.00001);
		user1.logout(AOT);
		user2.login(AOT, user2.username, user2.password);
		assertTrue(user2.rating(AOT, APP, 5.0f));
		APP.calcAvgRating();
		assertTrue(APP.averageRating < 7.5 + 0.00001 && APP.averageRating > 7.5 - 0.00001);
		user2.logout(AOT);
		user3.login(AOT, user3.username, user3.password);
		// Negative rating should fail
		assertFalse(user3.rating(AOT, APP, -5.6f));
		APP.calcAvgRating();
		// Rating should not have changed
		assertTrue(APP.averageRating < 7.5 + 0.00001 && APP.averageRating > 7.5 - 0.00001);
	}
}
