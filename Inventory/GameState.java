import java.util.Random;

public class GameState {
    private World world;
    private EngimonInitializer initializer = new EngimonInitializer();
    private int round;
    private Player player = new Player();
    private Spawner spawner;
    private Random random = new Random();
    private Breeder breeder;
    public final int MOVE_ROUND = 5;
    public final int SPAWN_ROUND = 7;
    public final int START_ENGIMON = 3;
    public final int LEVELUP_ENGIMON = 6;

    public GameState(World world){
        this.world = world;
        this.round = 1;
        this.spawner = new Spawner(spawner.MIN_WILD + random.nextInt((spawner.MAX_WILD - spawner.MIN_WILD)), world, initializer);
        // TODO: Give player 3 engimons in inventory
    }

    public void reload(String command){
        round++;
        regenerateWildEngimons();
    }

    public void regenerateWildEngimons(){
        if(round % MOVE_ROUND == 0){
            spawner.moveWildEngimons(world);
        }
        if(round % SPAWN_ROUND == 0){
            spawner.spawnMoreEngimons(world, initializer);
        }
        if(round % LEVELUP_ENGIMON == 0){
            spawner.levelUpEngimons();
        }
    }
}
