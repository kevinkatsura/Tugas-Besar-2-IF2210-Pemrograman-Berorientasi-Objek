import java.util.Scanner;

public class MoveCommand extends Command{
    private String direction;

    public MoveCommand(GameState gameState){
        super(gameState);
        System.out.println("Silakan tentukan arah pergerakan anda (A/S/W/D): ");
        Scanner scanner = new Scanner(System.in);
        String dir = scanner.nextLine();
        this.direction = direction;
    }

    @Override
    public void execute() {
        try {
            switch (direction){
                case "A":
                    gameState.movePlayerBy(-1, 0);
                    break;
                case "S":
                    gameState.movePlayerBy(0, 1);
                    break;
                case "W":
                    gameState.movePlayerBy(0, -1);
                    break;
                case "D":
                    gameState.movePlayerBy(1, 0);
                    break;
                default:
                    throw new InvalidCommandException();
            }
        } catch (InvalidCommandException e){
            e.showErrorMessage();
        } catch (PlayerOutOfMapException e){
            e.showErrorMessage();
        } catch (OccupiedCellException e){
            e.showErrorMessage();
        }
    }
}
