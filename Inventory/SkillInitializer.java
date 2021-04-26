import java.util.ArrayList;
import java.util.Arrays;

public class SkillInitializer {
    private static ArrayList<Skill> allSkills = new ArrayList<Skill>();
    private static final int numSkills = 18;

    public SkillInitializer(){
        init();
    }

    public void init(){
        allSkills.add(new Skill("Fireball",
                    new ArrayList<Element>(Arrays.asList(new Element("Fire"))),
                    200));
        allSkills.add(new Skill("WaterCannon",
                    new ArrayList<Element>(Arrays.asList(new Element("Water"))),
                    190));
        allSkills.add(new Skill("SnowBall",
                    new ArrayList<Element>(Arrays.asList(new Element("Ice"))),
                    250));
        allSkills.add(new Skill("Kirin",
                    new ArrayList<Element>(Arrays.asList(new Element("Electric"))),
                    300));
        allSkills.add(new Skill("Tampar",
                    new ArrayList<Element>(Arrays.asList(new Element("Fire"),
                            new Element("Ground"),
                            new Element("Electric"),
                            new Element("Water"),
                            new Element("Ice"))),
                    100));
        allSkills.add(new Skill("TanahTinggi",
                new ArrayList<Element>(Arrays.asList(new Element("Ground"))),
                220));
        allSkills.add(new Skill("ApiAmarah",
                new ArrayList<Element>(Arrays.asList(new Element("Fire"))),
                300));
        allSkills.add(new Skill("SusuMilo",
                new ArrayList<Element>(Arrays.asList(new Element("Water"),
                        new Element("Ice"))),
                240));
        allSkills.add(new Skill("EsKepal",
                new ArrayList<Element>(Arrays.asList(new Element("Ice"))),
                300));
        allSkills.add(new Skill("FireDance",
                new ArrayList<Element>(Arrays.asList(new Element("Fire"))),
                150));
        allSkills.add(new Skill("LightningStrike",
                new ArrayList<Element>(Arrays.asList(new Element("Electric"))),
                280));
        allSkills.add(new Skill("Blizzaro",
                new ArrayList<Element>(Arrays.asList(new Element("Water"),
                        new Element("Ground"))),
                300));
        allSkills.add(new Skill("Jitak",
                    new ArrayList<Element>(Arrays.asList(new Element("Fire"),
                            new Element("Ground"),
                            new Element("Electric"),
                            new Element("Water"),
                            new Element("Ice"))),
                    120));
        allSkills.add(new Skill("Terbang",
                    new ArrayList<Element>(Arrays.asList(new Element("Fire"),
                            new Element("Ground"),
                            new Element("Electric"),
                            new Element("Water"))),
                    120));
        allSkills.add(new Skill("Pandemonium",
                    new ArrayList<Element>(Arrays.asList(new Element("Ground"),
                            new Element("Ice"))),
                    250));
        allSkills.add(new Skill("DomainExpansion",
                    new ArrayList<Element>(Arrays.asList(new Element("Electric"),
                            new Element("Fire"))),
                    320));
        allSkills.add(new Skill("Wadirmophism",
                    new ArrayList<Element>(Arrays.asList(new Element("Ground"))),
                    320));
        allSkills.add(new Skill("WaterSplash",
                    new ArrayList<Element>(Arrays.asList(new Element("Water"))),
                    90));
    }

    public Skill getSkill(int idx){
        return allSkills.get(idx);
    }
}
