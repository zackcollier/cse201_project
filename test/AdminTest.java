import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

// viewRequest method should be entirely visual
public class AdminTest {
	private AppOrganizationTool AOT;
	private Application APP;
	private Developer dev;
	
	@Before
	public void setUp() {
		AOT = new AppOrganizationTool();
		APP = new Application("App", "", "sampleCompany", "", "", "");
		dev = new Developer("test", "test123", "testCompany");
	}
	
	@Test
	public void testApproveRequest() {
		// Add an app to be approved
		dev.submitRequest(AOT, APP);
		Admin admin = new Admin("testAdmin", "test1234");
		admin.approveRequest(AOT, APP);
		ArrayList<Application> reference = new ArrayList<Application>();
		reference.add(APP);
		assertEquals("Arraylists not equal", AOT.getApps(), reference);
	}
}
