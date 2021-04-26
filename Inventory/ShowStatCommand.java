public class ShowStatCommand extends Command {
    public ShowStatCommand(GameState gameState){
        super(gameState);
    }
    @Override
    public void execute() {
        gameState.showEngimonStat();
    }
}
