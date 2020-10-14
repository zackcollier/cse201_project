public class AppOrganizationTool {
    public static void main() {
        Application app1("App 1 Name", "App 1 Description", "App 1 Company", "App 1 Platforms", "App 1 Version", "App 1 Genre");
        Application app2("App 2 Name", "App 2 Description", "App 2 Company", "App 2 Platforms", "App 2 Version", "App 2 Genre");
        System.out.println(app1.toArray());
        System.out.println(app2.toArray());
    }
}
