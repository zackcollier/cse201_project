import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Before;
import org.junit.Test;

public class DeveloperTest {
    private AppOrganizationTool AOT;
    private Application APP;
    
    @Before
    public void setUp() {
        // Creates an AOT
        AOT = new AppOrganizationTool();
        APP = new Application("App", "", "sampleCompany", "", "", "");
    }

    @Test
    public void testUpdateApp() {
        Developer dev1 = new Developer("dev1", "passwd", "sampleCompany");
        // Update name
        dev1.updateApp(APP, 1, "TestName");
        assertTrue("Name is not updating", "TestName".equals(APP.name));
        // Update description
        dev1.updateApp(APP, 2, "TestDescription");
        assertTrue("Description is not updating", "TestDescription".equals(APP.description));
        // Update company
        dev1.updateApp(APP, 3, "TestCompany");
        assertTrue("Company is not updating", "TestCompany".equals(APP.company));
        // Trying to update any values should now fail
        dev1.updateApp(APP, 1, "TestName2");
        assertFalse("Name is updating when the companies do not match", "TestName2".equals(APP.name));
        // Update developer company to continue test
        dev1 = new Developer("dev1", "passwd", "TestCompany");
        // Update platforms
        dev1.updateApp(APP, 4, "TestPlatform");
        assertTrue("Platforms is not updating", "TestPlatform".equals(APP.platforms));
        // Update version
        dev1.updateApp(APP, 5, "TestVersion");
        assertTrue("Version is not updating", "TestVersion".equals(APP.version));
        // Update genre
        dev1.updateApp(APP, 6, "TestGenre");
        assertTrue("Genre is not updating", "TestGenre".equals(APP.genre));
    }

    @Test
    public void testSubmitRequest() {
        Developer dev2 = new Developer("dev2", "passwd", "sampleCompany");
        // Submit request
        dev2.submitRequest(AOT, APP);
        // The queue to compare to
        LinkedBlockingQueue<Application> apps = new LinkedBlockingQueue<Application>();
        apps.add(APP);
        // Queues can't be checked for equality, thus arrays are used
        assertArrayEquals("List of apps not the same", apps.toArray(), AOT.requests.toArray());
    }
}
