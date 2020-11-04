import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.Before;

class ApplicationTest {
	private AppOrganizationTool AOT;
    private Application APP;
    private User userCommenter;
    
    @Before
    public void setUp() {
        // Creates an AOT
        AOT = new AppOrganizationTool();
        APP = new Application("App", "", "sampleCompany", "", "", "");
        userCommenter = new User("testName", "passwd");
    }
	@Test
	public void testCommentSystem() {
		
		// Create User
    	User user = new User("testName", "passwd");
    	user.signUp(AOT, user.username, "passwd");
    	// User Login
    	user.login(AOT, user.username, "passwd");
    	AOT.currentUser.equals(user);
		// Comment
    	user.comment(AOT, APP, "A");
    	assertTrue(user.equals(userCommenter));
	}

}
