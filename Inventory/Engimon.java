import java.util.ArrayList;
import java.util.PriorityQueue;

public class Engimon extends Entity implements Item{
    private int id;
    private String species;
    private ArrayList<Element> elements;
    private String slogan;
    private int maxExp;
    private Engimon parent1;
    private Engimon parent2;

    private PriorityQueue<Skill> skills = new PriorityQueue<Skill>(4, Skill::compareTo);
    private char symbol;
    private String name;
    private int level;
    private int life;
    private int cumulXp;
    public Engimon(int id){
        super();
        this.id = id;
    }

    public Engimon(int id, String species, String slogan, int maxExp){
        super();
        this.id = id;
        this.species = species;
        this.slogan = slogan;
        this.maxExp = maxExp;
    }

    public Engimon(Engimon target){
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

    public void setNama(String nama) {
        this.name = name;
    }

    public int getLevel() { return level; }

    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }


    public int getNumberElements(){
        return elements.size();
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public String getSpecies() {
        return species;
    }

    public PriorityQueue<Skill> getSkills() { return skills; }

    public void xpUp(int addXp){
        if(cumulXp + addXp >= maxExp){
            // Mati
        } else {
            cumulXp += addXp;
            level = 1 + cumulXp / 100;
        }
    }

    public void setSkills(PriorityQueue<Skill> skills) {
        this.skills = skills;
    }

    public void addSkill(Skill skill){
        if(skills.size() < 4){
            skills.add(skill);
        } else {
            // TODO: Buat exception full skill
        }
    }

    public boolean suitableInCellType(CellType type){
        boolean retVal = false;
        for (Element e: elements) {
            retVal = retVal || type.getValidElements().contains(e);
        }
        return retVal;
    }

    @Override
    public Entity clone() {
        return new Engimon(this);
    }
}
