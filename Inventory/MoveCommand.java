public class MoveCommand extends Command{
    private String direction;

    public MoveCommand(GameState gameState, String direction){
        super(gameState);
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
