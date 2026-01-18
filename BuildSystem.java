
class Build {
    private String projectName;
    private int version;
    private boolean isStable;

    // Constructor
    public Build() {
        this.projectName = "Unnamed Project";
        this.version = 1;
        this.isStable = false;
    }

    // Getters
    public String getProjectName() {
        return projectName;
    }

    public int getVersion() {
        return version;
    }

    public boolean isStable() {
        return isStable;
    }

    // Setters with validation
    public void setProjectName(String projectName) {
        if (projectName != null && !projectName.isEmpty()) {
            this.projectName = projectName;
        } else {
            System.out.println("Invalid project name!");
        }
    }

    public void setVersion(int version) {
        if (version > 0) {
            this.version = version;
        } else {
            System.out.println("Version must be greater than 0!");
        }
    }

    public void setStable(boolean isStable) {
        this.isStable = isStable;
    }

    // Display method (can be overridden)
    public void displayBuildInfo() {
        System.out.println("Project: " + projectName +
                        ", Version: " + version +
                        ", Stable: " + isStable);
    }
}

// BetaBuild subclass
class BetaBuild extends Build {
    @Override
    public void displayBuildInfo() {
        System.out.println("🚧 Beta Build - Project: " + getProjectName() +
                        ", Version: " + getVersion() +
                        ", Stable: " + isStable());
    }
}

// ReleaseBuild subclass
class ReleaseBuild extends Build {
    @Override
    public void displayBuildInfo() {
        System.out.println("✅ Release Build - Project: " + getProjectName() +
                        ", Version: " + getVersion() +
                        ", Stable: " + isStable());
    }
}

// Main class to test
public class BuildSystem {
    public static void main(String[] args) {
        // Test basic Build
        System.out.println("=== Basic Build ===");
        Build build = new Build();
        build.setProjectName("AI Copilot");
        build.setVersion(1);
        build.setStable(true);
        build.displayBuildInfo();

        System.out.println("\n=== Default Build ===");
        Build build2 = new Build();
        build2.displayBuildInfo();

        // Test BetaBuild
        System.out.println("\n=== Beta Build ===");
        BetaBuild betaBuild = new BetaBuild();
        betaBuild.setProjectName("Neural Engine");
        betaBuild.setVersion(2);
        betaBuild.setStable(false);
        betaBuild.displayBuildInfo();

        // Test ReleaseBuild
        System.out.println("\n=== Release Build ===");
        ReleaseBuild releaseBuild = new ReleaseBuild();
        releaseBuild.setProjectName("Cloud Platform");
        releaseBuild.setVersion(5);
        releaseBuild.setStable(true);
        releaseBuild.displayBuildInfo();

        // Demonstrate polymorphism
        System.out.println("\n=== Polymorphism Demo ===");
        Build[] builds = {build, betaBuild, releaseBuild};
        for (Build b : builds) {
            b.displayBuildInfo();
        }

        // Test validation
        System.out.println("\n=== Validation Tests ===");
        Build testBuild = new Build();
        testBuild.setProjectName(""); // Should print error
        testBuild.setVersion(-5); // Should print error
    }
}