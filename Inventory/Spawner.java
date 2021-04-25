import java.util.ArrayList;
import java.util.Random;

public class Spawner {
    private static ArrayList<Engimon> wildEngimons = new ArrayList<>();
    private static int currWildCount;
    public static final int MAX_WILD = 15;
    public static final int MIN_WILD = 11;

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
            Engimon e = (Engimon) validEngimons.get(rand.nextInt(validEngimons.size())).cloneDefaultWild(1);
            e.setCoordinate(world.getCell(x, y));
            wildEngimons.add(e);
            world.addEntities(e, x, y);
        }
        currWildCount = numWild;
    }

    public static ArrayList<Engimon> getWildEngimons() {
        return wildEngimons;
    }

    public static void moveWildEngimons(World world){
        Random random = new Random();
        for (Engimon e: wildEngimons) {
            int k, l;
            int m = e.getCoordinate().getX();
            int n = e.getCoordinate().getY();
            int randDir = random.nextInt(5);
            if(randDir == 0){
                k = m - 1;
                l = n;
            } else if(randDir == 1){
                k = m + 1;
                l = n;
            } else if(randDir == 2){
                k = m;
                l = n - 1;
            } else if(randDir == 3){
                k = m;
                l = n + 1;
            } else {
                k = m;
                l = n;
            }
            if(world.validCell(k, l)){
                if(world.getEntities(k, l) instanceof Air && e.suitableInCellType(world.getCellType(k, l))){
                    world.moveEntities(m, n, k, l);
                    e.setCoordinate(world.getCell(k, l));
                }
            }
        }
    }

    public static void spawnMoreEngimons(World world, EngimonInitializer initializer){
        Random random = new Random();
        int numSpawn = random.nextInt(MAX_WILD - currWildCount);
        for(int i = 0; i < numSpawn; i++){
            // Pilih petak kosong acak
            int x = random.nextInt(world.getKolom());
            int y = random.nextInt(world.getBaris());
            while(!(world.getEntities(x, y) instanceof Air)){
                x = random.nextInt(world.getKolom());
                y = random.nextInt(world.getBaris());
            }

            // Dapatkan list engimon yang elemennya sesuai
            CellType cellType = world.getCellType(x, y);
            ArrayList<Element> validElements = cellType.getValidElements();
            ArrayList<Engimon> validEngimons = new ArrayList<Engimon>();
            for (Element e: validElements) {
                validEngimons.addAll(initializer.getAllEngimonContainElement(e));
            }

            // Pilih engimon random
            Engimon engimon = (Engimon) validEngimons.get(random.nextInt(validElements.size())).clone();

            // Taruh di map
            world.addEntities(engimon, x, y);
            currWildCount++;
        }
    }

    public static void levelUpEngimons(){
        for (Engimon engimon: wildEngimons) {
            engimon.xpUp(100);
        }
    }

    public static int getCurrWildCount(){
        return currWildCount;
    }
}
