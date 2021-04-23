import java.util.ArrayList;

public class Skill {
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


}
