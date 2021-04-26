import java.util.Scanner;

public class BreedCommand extends Command{
    public BreedCommand(GameState gameState){
        super(gameState);
    }

    @Override
    public void execute() {
        // TODO: Membuat pemilihan engimon untuk dikawinkan
        System.out.println("Silakan masukkan indeks dua engimon yang ingin dikawinkan: ");
        Scanner sc = new Scanner(System.in);
        int idx1 = sc.nextInt();
        int idx2 = sc.nextInt();
        Engimon e1 = gameState.getPlayerEngimonWithIndex(idx1);
        Engimon e2 = gameState.getPlayerEngimonWithIndex(idx2);
        try {
            Breeder breeder = new Breeder(e1, e2, new EngimonInitializer());
            Engimon child = breeder.getChild();
            gameState.addNewEngimon(child);
        } catch (IllegalLevelToBreedException e) {
            e.showErrorMessage();
        }
    }
}
