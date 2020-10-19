import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class AppOrganizationTool {

	ArrayList<Application> apps = new ArrayList<>();
	Queue<Application> requests = new LinkedBlockingQueue<>();
	
	public AppOrganizationTool()  {}
    
	public ArrayList<Application> getApps() {
		return apps;
	}
	
	public Queue<Application> getRequests() {
		return requests;
	}
	
	public ArrayList<Application> search(String str) {
		ArrayList<Application> searchApps = new ArrayList<>();
		for (Application a : apps) {
			for (String s : a.toArray()) {
				if (s.contains(str)) {
					searchApps.add(a);
					break;
				}
			}
		}
		return searchApps;
	}
	
    public static void main(String args[]) {
        Application app1 = new Application("App 1 Name", "App 1 Description", "App 1 Company", "App 1 Platforms", "App 1 Version", "App 1 Genre");
        Application app2 = new Application("App 2 Name", "App 2 Description", "App 2 Company", "App 2 Platforms", "App 2 Version", "App 2 Genre");
        Admin a1 = new Admin("username", "password");
        AppOrganizationTool AOT = new AppOrganizationTool();
        AOT.requests.add(app1);
        AOT.requests.add(app2);
        a1.viewRequest(AOT.getRequests().peek());
        a1.approveRequest(AOT, AOT.getRequests().remove());
        a1.viewRequest(AOT.getRequests().peek());
        a1.approveRequest(AOT, AOT.getRequests().remove());
        AOT.getApps().get(0).printDetails();
        AOT.getApps().get(1).printDetails();
    }
}
