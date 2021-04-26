import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

public final class EngimonInitializer {
    private static ArrayList<Engimon> allEngimons = new ArrayList<>();
    private static SkillInitializer allSkills;
    private static final int numEngimon = 12;

    public EngimonInitializer(){
        allSkills = new SkillInitializer();
        init();
    }

    public void init(){
        initEngimon();
        initElement();
        initSkill();
    }

    public void initEngimon(){
        allEngimons.add(new Engimon(1, "Charmeleon", "Cha cha real smooth", 70000));
        allEngimons.add(new Engimon(2, "Omanyte", "Ooo man ooo man", 60000));
        allEngimons.add(new Engimon(3, "Doraemon", "Aku ini kucing, bukan musang",66000));
        allEngimons.add(new Engimon(4, "Pikachu", "Pika pika", 120000));
        allEngimons.add(new Engimon(5, "BoboiBoyGempa", "Terbaek", 75000));
        allEngimons.add(new Engimon(6, "LaCorona", "Siapa itu yang minta libur setahun?", 55500));
        allEngimons.add(new Engimon(7, "Buzz", "Ah yes, the floor here made of floor", 60000));
        allEngimons.add(new Engimon(8, "Boot", "Boot boot boot", 80000));
        allEngimons.add(new Engimon(9, "AHHA", "Ashiaaaap", 55500));
        allEngimons.add(new Engimon(10, "DewiUseless", "Wheee, Kazumaaaa", 77800));
        allEngimons.add(new Engimon(11, "YukiOnna", "Hurururururu", 88200));
        allEngimons.add(new Engimon(12, "Oopsie", "Ctor cctor dtor", 65000));
    }

    public void initElement(){
        allEngimons.get(0).setElements(new ArrayList<Element>(Arrays.asList(
                new Element("Fire"))));
        allEngimons.get(1).setElements(new ArrayList<Element>(Arrays.asList(
                new Element("Water"))));
        allEngimons.get(2).setElements(new ArrayList<Element>(Arrays.asList(
                new Element("Ice"))));
        allEngimons.get(3).setElements(new ArrayList<Element>(Arrays.asList(
                new Element("Electric"))));
        allEngimons.get(4).setElements(new ArrayList<Element>(Arrays.asList(
                new Element("Ground"))));
        allEngimons.get(5).setElements(new ArrayList<Element>(Arrays.asList(
                new Element("Water"), new Element("Ice"))));
        allEngimons.get(6).setElements(new ArrayList<Element>(Arrays.asList(
                new Element("Water"), new Element("Ground"))));
        allEngimons.get(7).setElements(new ArrayList<Element>(Arrays.asList(
                new Element("Fire"), new Element("Electric"))));
        allEngimons.get(8).setElements(new ArrayList<Element>(Arrays.asList(
                new Element("Electric"))));
        allEngimons.get(9).setElements(new ArrayList<Element>(Arrays.asList(
                new Element("Water"), new Element("Ice"))));
        allEngimons.get(10).setElements(new ArrayList<Element>(Arrays.asList(
                new Element("Ice"))));
        allEngimons.get(11).setElements(new ArrayList<Element>(Arrays.asList(
                new Element("Ground"))));
    }

    public void initSkill(){
        allEngimons.get(0).addSkill(allSkills.getSkill(0));
        allEngimons.get(0).addSkill(allSkills.getSkill(15));
        allEngimons.get(1).addSkill(allSkills.getSkill(11));
        allEngimons.get(1).addSkill(allSkills.getSkill(17));
        allEngimons.get(2).addSkill(allSkills.getSkill(2));
        allEngimons.get(2).addSkill(allSkills.getSkill(4));
        allEngimons.get(2).addSkill(allSkills.getSkill(13));
        allEngimons.get(3).addSkill(allSkills.getSkill(3));
        allEngimons.get(3).addSkill(allSkills.getSkill(10));
        allEngimons.get(3).addSkill(allSkills.getSkill(15));
        allEngimons.get(4).addSkill(allSkills.getSkill(4));
        allEngimons.get(4).addSkill(allSkills.getSkill(5));
        allEngimons.get(5).addSkill(allSkills.getSkill(4));
        allEngimons.get(5).addSkill(allSkills.getSkill(11));
        allEngimons.get(5).addSkill(allSkills.getSkill(14));
        allEngimons.get(6).addSkill(allSkills.getSkill(1));
        allEngimons.get(6).addSkill(allSkills.getSkill(11));
        allEngimons.get(6).addSkill(allSkills.getSkill(16));
        allEngimons.get(7).addSkill(allSkills.getSkill(4));
        allEngimons.get(7).addSkill(allSkills.getSkill(15));
        allEngimons.get(8).addSkill(allSkills.getSkill(10));
        allEngimons.get(8).addSkill(allSkills.getSkill(12));
        allEngimons.get(9).addSkill(allSkills.getSkill(4));
        allEngimons.get(9).addSkill(allSkills.getSkill(7));
        allEngimons.get(10).addSkill(allSkills.getSkill(4));
        allEngimons.get(10).addSkill(allSkills.getSkill(8));
        allEngimons.get(11).addSkill(allSkills.getSkill(13));
        allEngimons.get(11).addSkill(allSkills.getSkill(16));
    }

    public Engimon getEngimon(int idx){
        return (Engimon) allEngimons.get(idx).clone();
    }

    public Engimon getEngimon(String spesies){
        return (Engimon) allEngimons
                .stream()
                .filter(e -> e.getSpecies().equals(spesies))
                .findFirst()
                .get()
                .clone();
    }


    public static int getNumEngimon() {
        return numEngimon;
    }

    public ArrayList<Engimon> getAllEngimonContainElement(Element element){
        return allEngimons.stream()
                .filter(e -> e.getElements().contains(element))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Engimon> getAllEngimonOfElement(Element element){
        return new ArrayList<Engimon>(allEngimons.stream()
                .filter(e -> (e.getElements().contains(element) && e.getNumberElements() == 1))
                .collect(Collectors.toList()));
    }

    public ArrayList<Engimon> getAllEngimonOfElement(ArrayList<Element> elements){
        return allEngimons.stream()
                .filter(e -> (new HashSet(e.getElements())).containsAll(elements))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
