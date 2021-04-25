import java.util.*;

public class Breeder {
    private Engimon engimon1;
    private Engimon engimon2;
    private Engimon child;
    public Breeder(Engimon e1, Engimon e2, EngimonInitializer initializer) throws IllegalLevelToBreedException {
        engimon1 = e1;
        engimon2 = e2;

        // Tentukan apakah legal untuk dikawinkan
        if(isLegalToBreed()){
            // Kurangi umur kedua parent
            e1.xpUp(-300);
            e2.xpUp(-300);
            // Pilih spesies anak
            child = initializer.getEngimon(inheritedSpecies(e1, e2, initializer));
            // Atur skill anak
            child.setSkills(inheritedSkill(child, e1, e2));
            // Atur nama anak
            Scanner scanner = new Scanner(System.in);
            System.out.println("Masukkan nama anak: ");
            String nama = scanner.nextLine();
            child.setNama(nama);
        } else {
            throw new IllegalLevelToBreedException();
        }
    }

    public Engimon getChild(){
        return (Engimon) child.clone();
    }

    private boolean isLegalToBreed(){
        if(engimon1.getLevel() >= 4 && engimon2.getLevel() >= 4){
            return true;
        } else {
            return false;
        }
    }

    private PriorityQueue<Skill> inheritedSkill(Engimon child, Engimon e1, Engimon e2){
        // TODO: Buat implementasi penurunan sikill
        PriorityQueue<Skill> childSkills = new PriorityQueue<Skill>();
        PriorityQueue<Skill> parent1Skills = e1.getSkills();
        PriorityQueue<Skill> parent2Skills = e2.getSkills();

        Skill naturalSkill = child.getSkills().peek();

        while(childSkills.size() < 4 && parent1Skills.size() > 0 && parent2Skills.size() > 0){
            Skill s1 = parent1Skills.peek();
            Skill s2 = parent2Skills.peek();
            if(s1.compareTo(s2) == -1){
                if(masteryLevelOn(childSkills, s2.getNama()) == 0 &&
                masteryLevelOn(parent1Skills, s2.getNama()) ==
                masteryLevelOn(parent2Skills, s2.getNama())){
                    if(s2.getMasteryLevel() < 3){
                        s2.setMasteryLevel(s2.getMasteryLevel() + 1);
                    }
                    childSkills.add(s2);
                } else if (masteryLevelOn(childSkills, s2.getNama()) == 0){
                    childSkills.add(s2);
                }
                parent2Skills.poll();
            } else {
                if(masteryLevelOn(childSkills, s1.getNama()) == 0 &&
                masteryLevelOn(parent2Skills, s1.getNama()) ==
                masteryLevelOn(parent2Skills, s1.getNama())){
                    if (s1.getMasteryLevel() < 3){
                        s1.setMasteryLevel(s1.getMasteryLevel() + 1);
                    }
                    childSkills.add(s1);
                } else if(masteryLevelOn(childSkills, s1.getNama()) == 0){
                    childSkills.add(s1);
                }
            }
        }

        while(childSkills.size() < 4 && (parent1Skills.size() > 0 || parent2Skills.size() > 0)){
            if(parent1Skills.size() > 0){
                Skill s1 = parent1Skills.peek();
                if(masteryLevelOn(childSkills, s1.getNama()) == 0){
                    childSkills.add(s1);
                }
                parent1Skills.poll();
            } else {
                Skill s2 = parent2Skills.peek();
                if(masteryLevelOn(childSkills, s2.getNama()) == 0){
                    childSkills.add(s2);
                }
                parent2Skills.poll();
            }
        }
        return childSkills;
    }

    private String inheritedSpecies(Engimon e1, Engimon e2, EngimonInitializer initializer){
        Random random = new Random();
        ArrayList<Element> elements = new ArrayList<Element>();

        // Pengecekan jumlah elemen parent
        if(e1.getNumberElements() == 1  && e2.getNumberElements() == 1){
            // Penentuan elemen anak
            elements.addAll(e1.getElements().get(0).inheritedElementsWhenBreed(e2.getElements().get(0)));
            // Penentuan spesies anak
            if(e1.getSpecies().equals(e2.getSpecies())){
                // Kasus spesies parent sama
                return e1.getSpecies();
            } else {
                // Kasus spesies parent beda
                Boolean elementOfe1 = (new HashSet(e1.getElements())).containsAll(elements);
                Boolean elementOfe2 = (new HashSet(e1.getElements())).containsAll(elements);
                if(elementOfe1 && elementOfe2){
                    // Kasus spesies parent beda, elemen sama -> Pilih spesies random
                    if(random.nextInt(2) == 0){
                        return e1.getSpecies();
                    } else {
                        return e2.getSpecies();
                    }
                // Kasus spesies parent beda, elemen beda, inherited element tunggal
                } else if(elementOfe1){
                    return e1.getSpecies();
                } else if(elementOfe2){
                    return e2.getSpecies();
                } else {
                    return initializer
                            .getAllEngimonOfElement(elements)
                            .get(random.nextInt(initializer.getAllEngimonOfElement(elements).size()))
                            .getSpecies();
                }
            }
        } else {
            // Kasus salah satu atau kedua parent punya elemen ganda -> Masing-masing parent dipilih elemen perwakilan
            Element el1 = e1.getElements().get(random.nextInt(e1.getNumberElements()));
            Element el2 = e2.getElements().get(random.nextInt(e2.getNumberElements()));
            elements.addAll(el1.inheritedElementsWhenBreed(el2));
            return initializer
                    .getAllEngimonOfElement(elements)
                    .get(random.nextInt(initializer.getAllEngimonOfElement(elements).size()))
                    .getSpecies();
        }
    }

    private int masteryLevelOn(PriorityQueue<Skill> priorityQueue, String skillName){
        PriorityQueue<Skill> priorityQueue1 = priorityQueue;
        boolean found = false;
        int retVal = 0;
        while (!priorityQueue1.isEmpty() && !found){
            if(priorityQueue1.peek().getNama().equals(skillName)){
                retVal = priorityQueue1.peek().getMasteryLevel();
                found = true;
            }
            priorityQueue1.poll();
        }
        return retVal;
    }

}
