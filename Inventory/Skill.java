import java.util.ArrayList;
import java.util.Objects;

public class Skill implements Comparable<Skill>,Item {
    private String nama;
    private ArrayList<String> validElements;
    private int basePower;
    private int masteryLevel;

    public Skill(String nama, ArrayList<String> validElements, int basePower){
        this.nama = nama;
        this.basePower = basePower;
        this.validElements = validElements;
        this.masteryLevel = 1;
    }

    public Skill(String nama, ArrayList<String> validElements, int basePower, int masteryLevel){
        this.nama = nama;
        this.basePower = basePower;
        this.validElements = validElements;
        this.masteryLevel = masteryLevel;
    }

    public int getMasteryLevel(){
        return this.masteryLevel;
    }

    public int getBasePower(){
        return this.basePower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return basePower == skill.basePower && masteryLevel == skill.masteryLevel && nama.equals(skill.nama) && validElements.equals(skill.validElements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nama, validElements, basePower, masteryLevel);
    }

    @Override
    public int compareTo(Skill o) {
        if(this.masteryLevel > o.masteryLevel){
            return 1;
        } else if(this.masteryLevel < o.masteryLevel) {
            return -1;
        } else {
            return 0;
        }
    }
}
