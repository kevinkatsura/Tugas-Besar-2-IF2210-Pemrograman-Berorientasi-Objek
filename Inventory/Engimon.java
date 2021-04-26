import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

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
    private InventoryEngimon myInventoryEngimon;
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
        this.name = nama;
    }

    public String getName() {return name;}

    public int getLevel() { return level; }

    public int getLife() { return life; }

    public void setLevel(int level) { this.level = level; }

    public void setLife(int life) { this.life = life; }

    public void setCumulXp(int cumulXp) { this.cumulXp = cumulXp; }

    public int getCumulXp() { return cumulXp; }

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
            life--;
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

    public void addToInventoryEngimon(Engimon e){
        myInventoryEngimon.addMember(e);
    }

    public boolean suitableInCellType(CellType type){
        boolean retVal = false;
        for (Element e: elements) {
            retVal = retVal || type.getValidElements().contains(e);
        }
        return retVal;
    }

    public void showStat(){
        System.out.println("Nama: " + name);
        System.out.println("Spesies: " + species);
        System.out.println("Slogan: " + slogan);
        System.out.println("Elements: ");
        for (Element e: elements) {
            System.out.println("- " + e.getElementName());
        }
        System.out.println("Skills: ");
        for (Skill s: skills) {
            System.out.println("- " + s.getNama());
            System.out.println("   - " + s.getMasteryLevel());
            System.out.println("   - " + s.getBasePower());
        }
        System.out.println("Level: " + level);
        System.out.println("CumulXp: " +  cumulXp);
        System.out.println("Life: " + life);
        System.out.println("Parent 1: " + parent1.getName() + ", Spesies: " + parent1.getSpecies());
        System.out.println("Parent 2: " + parent2.getName() + ", Spesies: " + parent2.getSpecies());
    }

    @Override
    public Entity clone() {
        return new Engimon(this);
    }

    public Engimon cloneDefaultWild(int minLevel){
        Random random = new Random();
        Engimon wildEngimon = new Engimon(this);
        wildEngimon.setCumulXp(minLevel*100 + random.nextInt(500));
        wildEngimon.setLevel(wildEngimon.cumulXp/100 + 1);
        wildEngimon.setLife(1);
        wildEngimon.setNama(new WildEngimonNames().giveEngimonName(wildEngimon));
        Engimon parent1 = new Engimon(wildEngimon.id, wildEngimon.species, wildEngimon.slogan, wildEngimon.maxExp);
        Engimon parent2 = new Engimon(wildEngimon.id, wildEngimon.species, wildEngimon.slogan, wildEngimon.maxExp);
        parent1.setElements(wildEngimon.getElements());
        parent2.setElements(wildEngimon.getElements());
        parent1.setNama(new WildEngimonNames().giveEngimonName(parent1));
        parent2.setNama(new WildEngimonNames().giveEngimonName(parent2));
        wildEngimon.setParents(parent1, parent2);
        return wildEngimon;
    }

    public Engimon cloneDefaultTamed(){
        Random random = new Random();
        Engimon tamedEngimon = new Engimon(this);
        tamedEngimon.setCumulXp(0);
        tamedEngimon.setLevel(1);
        tamedEngimon.setLife(3);
        System.out.println("Selamat, Anda mendapatkan engimon berspesies " + tamedEngimon.getSpecies());
        System.out.println("Silakan beri nama engimon anda:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        tamedEngimon.setNama(name);
        Engimon parent1 = new Engimon(tamedEngimon.id, tamedEngimon.species, tamedEngimon.slogan, tamedEngimon.maxExp);
        Engimon parent2 = new Engimon(tamedEngimon.id, tamedEngimon.species, tamedEngimon.slogan, tamedEngimon.maxExp);
        parent1.setElements(tamedEngimon.getElements());
        parent2.setElements(tamedEngimon.getElements());
        parent1.setNama(new WildEngimonNames().giveEngimonName(parent1));
        parent2.setNama(new WildEngimonNames().giveEngimonName(parent2));
        tamedEngimon.setParents(parent1, parent2);
        System.out.println("Berikut adalah data dari engimonmu:");
        tamedEngimon.showStat();
        return tamedEngimon;
    }

    public void setMyInventoryEngimon(InventoryEngimon myInventoryEngimon) {
        this.myInventoryEngimon = myInventoryEngimon;
    }

    public void setParents(Engimon e1, Engimon e2) {
        parent1 = e1;
        parent2 = e2;
    }
}
