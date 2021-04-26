public abstract class Command {
    protected GameState gameState;

    public Command(GameState gameState){
        this.gameState = gameState;
    }

    public abstract void execute();
}
