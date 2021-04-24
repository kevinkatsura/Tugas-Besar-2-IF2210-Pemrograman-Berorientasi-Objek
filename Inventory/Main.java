import java.io.File;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        World world = new World(8, 10, fileName);
        GameState gameState = new GameState(world);
    }
}
