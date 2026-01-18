public class Build {
    private String projectName;
    private int version;
    private boolean isStable;


    public String getProjectName() {
        return projectName;
    }

    Build() {
        this.projectName = "Unnamed Project";
        this.version = 1;
        this.isStable = false;
    }

    public void setProjectName(String projectName) {
        if(projectName != null && !projectName.isEmpty()) {
            this.projectName = projectName;
        } else {
            System.out.println("Invalid project name!");
        }
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        if(version > 0) {
            this.version = version;
        } else {
            System.out.println("Version must be greater than 0!");
        }
    }

    public boolean isStable() {
        return isStable;
    }

    public void setStable(boolean isStable) {
        this.isStable = isStable;
    }

    public void displayBuildInfo() {
            System.out.println("Project: " + projectName +
                            ", Version: " + version +
                            ", Stable: " + isStable);
    }

    
    public static void main(String[] args) {
        Build build = new Build(); 
        Build build2 = new Build(); 
        // Using setters to assign values 
        build.setProjectName("AI Copilot"); 
        build.setVersion(1); 
        build.setStable(true); 

        System.out.println("Project Name: " + build.getProjectName()); 
        System.out.println("Version: " + build.getVersion()); 
        System.out.println("Is Stable: " + build.isStable());
        build.displayBuildInfo();
        build2.displayBuildInfo();
    }
}
