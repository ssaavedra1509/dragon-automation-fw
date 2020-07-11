package pe.com.swtestingdragons.dragonautomationfw.models;

public class Entity {

    private RedmineProject project;

    public Entity(){
    }

    public Entity(RedmineProject project) {
        this.project = project;
    }

    public RedmineProject getProject() {
        return project;
    }

    public void setProject(RedmineProject project) {
        this.project = project;
    }
}