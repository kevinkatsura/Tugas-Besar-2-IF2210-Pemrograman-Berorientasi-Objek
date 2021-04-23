import java.util.PriorityQueue;

public class Breeder {
    private
    Engimon engimon1;
    Engimon engimon2;
    Engimon child;
    public
    Breeder(Engimon e1, Engimon e2){
        engimon1 = e1;
        engimon2 = e2;
        if(isLegalToBreed(e1, e2)){

        }
    }

    boolean isLegalToBreed(Engimon e1, Engimon e2){
        if(e1.getLevel() >= 4 && e2.getLevel() >= 4){
            if(e1.getNumberElements() == 1 && e2.getNumberElements() == 1){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    PriorityQueue<Skill> inheritedSkill(Engimon e1, Engimon e2){
        return e1.getSkills();
    }
}
