import java.util.ArrayList;
import java.util.Objects;

public class Skill implements Comparable<Skill>{
    String nama;
    ArrayList<String> validElements;
    int basePower;
    int masteryLevel;

    public Skill(String nama, ArrayList<String> validElements, int basePower){
        this.nama = nama;
        this.basePower = basePower;
        this.validElements = validElements;
        this.masteryLevel = validElements.size();
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
        return o.basePower - this.basePower;
    }
}
