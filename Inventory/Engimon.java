import java.util.ArrayList;
import java.util.PriorityQueue;

public class Engimon extends Entity{
    private
    int id;
    String species;
    ArrayList<Element> elements;
    String slogan;
    int maxExp;
    Engimon parent1;
    Engimon parent2;

    PriorityQueue<Skill> skills;
    char symbol;
    String name;
    int level;
    int life;
    int cumulXp;
    public
    Engimon(int id){
        super();
        this.id = id;
    }

    Engimon(int id, String species, String slogan, int maxExp){
        super();
        this.id = id;
        this.species = species;
        this.slogan = slogan;
        this.maxExp = maxExp;
    }

    Engimon(Engimon target){
        super(target);
        if(target != null){
            id = target.id;
            species = target.species;
            elements = target.elements;
            slogan = target.slogan;
            maxExp = target.maxExp;
            parent1 = target.parent1;
            parent2 = target.parent2;

            skills = target.skills;
            symbol = target.symbol;
            name = target.name;
            level = target.level;
            life = target.life;
            cumulXp = target.cumulXp;
        }
    }

    void setNama(String nama) {
        this.name = name;
    }

    int getLevel() { return level; }

    void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }

    int getNumberElements(){
        return elements.size();
    }

    PriorityQueue<Skill> getSkills() { return skills; }

    void xpUp(int addXp){
        if(cumulXp + addXp >= maxExp){
            // Mati
        } else {
            cumulXp += addXp;
            level = 1 + cumulXp / 100;
        }
    }

    @Override
    public Entity clone() {
        return new Engimon(this);
    }
}
