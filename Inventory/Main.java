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
        while (true){
            for(int i = 0; i< 8; i++){
                for(int j = 0; j < 10; j++){
                    if(world.getEntities(j, i) instanceof  Player){
                        System.out.print("P");
                    }
                    if(world.getEntities(j, i) instanceof Engimon){
                        System.out.print("E");
                    }
                    if (world.getEntities(j, i) instanceof Air){
                        switch (world.getCellType(j, i)){
                            case GRASSLAND -> System.out.print("w");
                            case MOUNTAINS -> System.out.print("^");
                            case SEA -> System.out.print("-");
                            case TUNDRA -> System.out.print("u");
                            default -> System.out.print("X");
                        }
                    }
                    if(j == 9){
                        System.out.print("\n");
                    }
                    System.out.println(world.getEntities(j, i).getClass());
                    if(world.getEntities(j, i) instanceof Engimon){
                        ((Engimon) world.getEntities(j, i)).showStat();
                    }
                }
            gameState.reload();*/
            EngimonInitializer initializer  = new EngimonInitializer();
            Engimon e1 = initializer.getEngimon("Charmeleon").cloneDefaultWild(4);
            e1.showStat();
            Engimon e2 = initializer.getEngimon("Pikachu").cloneDefaultWild(5);
            e2.showStat();
            try{
                Breeder breeder = new Breeder(e1, e2, initializer);
                breeder.getChild().showStat();
                e1.showStat();
                e2.showStat();
            } catch (IllegalLevelToBreedException e) {
                e.showErrorMessage();
            }
    }
}
