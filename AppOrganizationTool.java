public class AppOrganizationTool {
    
    public ArrayList<Application> apps = new ArrayList<>();
        
    public Queue<Application> requests = new Queue<>();
    
    public static void main() {
        Application app1("App 1 Name", "App 1 Description", "App 1 Company", "App 1 Platforms", "App 1 Version", "App 1 Genre");
        Application app2("App 2 Name", "App 2 Description", "App 2 Company", "App 2 Platforms", "App 2 Version", "App 2 Genre");
        Admin a1 = new Admin("username", "password");
        requests.add(app1);
        requests.add(app2);
        a1.viewRequest(requests.remove());
        a1.viewRequest(requests.remove());
        System.out.println(apps.get(0).toArray());
        System.out.println(apps.get(1).toArray());
    }
}
