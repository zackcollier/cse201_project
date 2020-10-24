import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private AppOrganizationTool AOT;

    @Before
    public void setUp() {
        // Creates an AOT
        AOT = new AppOrganizationTool();
    }

    @Test
    public void testSignUp() {
        // Create a map to compare the users that are added to the AOT
        HashMap<String, String> userComparison = new HashMap<String, String>();
        // Create users
        User user1 = new User("testName", "passwd");
        User user2 = new User("testName", "passwd");
        // User sign up with free username
        assertTrue(user1.signUp(AOT, user1.username, "passwd"));
        userComparison.put("testName", "passwd");
        // Checks that the user is added to the AOT
        assertEquals(AOT.users, userComparison);
        // User sign up with taken username
        assertFalse(user1.signUp(AOT, user2.username, "passwd"));
        // Checks that in the case that a username is already taken a new entry is not
        // added
        assertEquals(AOT.users, userComparison);
    }

    @Test
    public void testLogin() {

    }

    @Test
    public void testLogout() {

    }

    @Test
    public void testComment() {

    }

    @Test
    public void testSearch() {

    }
}
