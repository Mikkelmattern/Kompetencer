import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Developer {
    private String name;
    private List<Skill> skills;

    Developer(String name) {
        this.name = name;
    }

    public void addSkill(String skill) {
        skills.add(new Skill(skill, 0));
    }

    public void addSkill(String skill, int level) {
        skills.add(new Skill(skill, level));
    }

    public void updateSkillLevel(String name, int indexPlace, int newLevel) {
        skills.set(indexPlace, new Skill(name, newLevel));
    }

    public String getName() {
        return name;
    }

    public List<Skill> showSkills() {
        return skills;
    }

    public String toString() {
        if (skills == null) {
            return name;
        }
        return name + skills;
    }

    public int getSkillLevel(String skillName) {
        for (Skill s : skills) {
            if (skillName.equalsIgnoreCase(s.getName()))
                return s.getLevel();
        }
        return 0;
    }

    public boolean meetsRequirements(Map<String, Integer> requirements) {
        for (Map.Entry<String, Integer> req : requirements.entrySet()) {
            String skill = req.getKey();
            int level = req.getValue();
            if (getSkillLevel(skill) <= level) {
                return false;
            }
        }
        return true;
    }

}
