import java.util.List;

public class Developer {
    private String name;
    private List<Skill> skills;
    Developer(String name){
        this.name = name;
    }

    public void addSkill(String skill) {
        skills.add(new Skill(skill, 0));
    }

    public void addSkill(String skill, int level) {
        skills.add(new Skill(skill, level));
    }

    public void updateSkillLevel(String name, int indexPlace, int newLevel) {
        skills.set(indexPlace, new Skill(name,newLevel));
    }

    public String getName() {
        return name;
    }
    public List<Skill> showSkills(){
        return skills;
    }
    public String toString(){
        if(skills == null){
            return name;
        }
        return name + skills;
    }

}
