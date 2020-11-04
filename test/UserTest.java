import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private AppOrganizationTool AOT;
    private Application APP;
    @Before
    public void setUp() {
        // Creates an AOT
        AOT = new AppOrganizationTool();
        APP = new Application("App", "", "", "", "", "");
    }

    @Test
    public void testSignUp() {
        // Create a map to compare the users that are added to the AOT
        HashMap<String, String> userComparison = new HashMap<String, String>();
        // Create users
        User user1 = new User("testName", "passwd");
        User user2 = new User("testName", "passwd");
        // User sign up with free username
        assertTrue(user1.signUp(AOT));
        userComparison.put("testName", "passwd");
        // Checks that the user is added to the AOT
        assertEquals(AOT.users, userComparison);
        // User sign up with taken username
        assertFalse(user1.signUp(AOT));
        // Checks that in the case that a username is already taken a new entry is not
        // added
        assertEquals(AOT.users, userComparison);
    }

    @Test
    public void testLogin() {
        // Create User
    	User user3 = new User("testName", "passwd");
    	user3.signUp(AOT);
    	// Test User Login
    	assertTrue(user3.login(AOT, user3.username, "passwd"));
    	// Checks the user logged in is the current user 
    	assertTrue(AOT.currentUser.equals(user3));
    }

    @Test
    public void testLogout() {
        // Create User
    	User user4 = new User("testName", "passwd");
    	user4.signUp(AOT);
    	// User Login
    	user4.login(AOT, user4.username, "passwd");
    	// Checks the user logged in is the current user 
    	assertTrue(AOT.currentUser.equals(user4));
    	// Test User logout
    	assertTrue(user4.logout(AOT));
    	// Checks that current user is no longer signed in
    	assertTrue(AOT.currentUser == null);
    }

    @Test
    public void testComment() {
        // Create User
        User user5 = new User("testName", "passwd");
        user5.signUp(AOT);
        // User Login
        user5.login(AOT, user5.username, "passwd");
        // Checks if user leaves comment
        user5.comment(AOT, APP, "Comment1");
        assertTrue(APP.comments.contains("Comment1"));
        // User Logs out
        user5.logout(AOT);
        user5.comment(AOT, APP, "Comment2");
        // Checks to make sure user cannot comment when signed out
        assertFalse(APP.comments.contains("Comment2"));
    }

    @Test
    public void testSearch() {
        // Create User
    	User user6 = new User("testName", "passwd");
    	user6.signUp(AOT);
    	// User Login
    	user6.login(AOT, user6.username, "passwd");
    	// Add APP to AOT
    	AOT.apps.add(APP);
    	// Check that search results are found
    	assertTrue(user6.search(AOT, "App"));
    	// Check that search results are not found
    	assertFalse(user6.search(AOT, "apple"));

    }
    @Test
    public void testSort() {
        // Create a user and sign in
        User user7 = new User("testName", "passwd");
        user7.signUp(AOT);
        user7.login(AOT, user7.username, "passwd");
        // There are currently three different parameters that applications can be sorted on. Name, genre, and rating. There is currently no way for an app to get a rating so this will only be testing the name and genre
        Application app1 = new Application("first", "", "", "", "", "2nd genre");
        Application app2 = new Application("second", "", "", "", "", "3rd genre");
        Application app3 = new Application("third", "", "", "", "", "1st genre");
        // Add apps to the AOT
        AOT.apps.add(app1);
        AOT.apps.add(app2);
        AOT.apps.add(app3);
        // Sort AOT apps by name
        user7.sort(AOT, 1);
        // Create an ArrayList to compare the sorting with for names 
        ArrayList<Application> firstComparison = new ArrayList<Application>();
        firstComparison.add(app1);
        firstComparison.add(app2);
        firstComparison.add(app3);
        // Check equality
        assertEquals("Name sort is not working", AOT.apps, firstComparison);
        // Create an ArrayList to compare the sorting with genres
        ArrayList<Application> secondComparison = new ArrayList<Application>();
        secondComparison.add(app3);
        secondComparison.add(app1);
        secondComparison.add(app2);
        // Sort by genre
        user7.sort(AOT, 2);
        assertEquals("Genre sort is not working", AOT.apps, secondComparison);
    }
}
