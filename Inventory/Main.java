import java.io.File;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        /*Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        World world = new World(8, 10, fileName);
        GameState gameState = new GameState(world);
        while (true) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 10; j++) {
                    if (world.getEntities(j, i) instanceof Player) {
                        System.out.print("P");
                    }
                    if (world.getEntities(j, i) instanceof Engimon) {
                        System.out.print("E");
                    }
                    if (world.getEntities(j, i) instanceof Air) {
                        switch (world.getCellType(j, i)) {
                            case GRASSLAND -> System.out.print("w");
                            case MOUNTAINS -> System.out.print("^");
                            case SEA -> System.out.print("-");
                            case TUNDRA -> System.out.print("u");
                            default -> System.out.print("X");
                        }
                    }
                    if (j == 9) {
                        System.out.print("\n");
                    }
                    *//*System.out.println(world.getEntities(j, i).getClass());
                    if (world.getEntities(j, i) instanceof Engimon) {
                        ((Engimon) world.getEntities(j, i)).showStat();
                    }*//*
                }
            }
            gameState.reload();
        }*/
        ArrayList<Engimon> engimons = new ArrayList<>();
        engimons.add(new EngimonInitializer().getEngimon(1).cloneDefaultWild(1));
        engimons.add(new EngimonInitializer().getEngimon(2).cloneDefaultWild(1));
        System.out.println(engimons);
        engimons.remove(0);
        System.out.println(engimons);
        engimons.add(new EngimonInitializer().getEngimon(9).cloneDefaultWild(1));
        System.out.println(engimons);
        System.out.println(engimons.size());
    }
}
