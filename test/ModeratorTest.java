import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ModeratorTest {
	private AppOrganizationTool AOT;
	private Application APP;
	private User user1;
	
	@Before
	public void setUp() {
		AOT = new AppOrganizationTool();
		APP = new Application("App", "", "sampleCompany", "", "", "");
		user1 = new User("testUser", "test123");
	}

	// This removes all comments that a user has posted on an app an is easy to test
	@Test
	public void testRemoveComment() {
		user1.comment(AOT, APP, "This is a sample comment");
		user1.comment(AOT, APP, "This is a second comment");
		Moderator mod = new Moderator("mod", "test1234");
		mod.removeComment(APP, user1.username);
		assertFalse("Comment not removed", APP.comments.containsKey(user1.username));
	}
}
