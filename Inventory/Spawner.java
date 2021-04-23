import java.util.ArrayList;
import java.util.Random;

public class Spawner {
    private static ArrayList<Engimon> wildEngimons = new ArrayList<>();
    private static final int maxWild = 15;
    private static int currWildCount;

    public Spawner(int numWild, World world, EngimonInitializer initializer){
        for(int i = 0; i < numWild; i++){
            Random rand = new Random();
            int y = rand.nextInt(world.getBaris());
            int x = rand.nextInt(world.getKolom());
            while(!(world.getEntities(x, y) instanceof Air)){
                y = rand.nextInt(world.getBaris());
                x = rand.nextInt(world.getKolom());
            }
            ArrayList<Element> validElements = world.getCellType(x,y).getValidElements();
            ArrayList<Engimon> validEngimons = new ArrayList<Engimon>();
            for (Element e: validElements) {
                validEngimons.addAll(initializer.getAllEngimonContainElement(e));
            }
            Engimon e = (Engimon) validEngimons.get(rand.nextInt(validElements.size())).clone();
            wildEngimons.add(e);
            world.addEntities(e, x, y);
        }
        currWildCount = numWild;
    }

    public static ArrayList<Engimon> getWildEngimons() {
        return wildEngimons;
    }

}
