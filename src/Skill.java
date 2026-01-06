public class Skill {
    private String name;
    private int level;

    Skill(String name, int level){
        this.name = name;
        this.level = level;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        if(level == 0){
            return name+"1 "+level;
        } else if (name.equals(null)) {
            return "";

        }
        return name;
    }
}
