import java.util.Random;
import java.util.Scanner;

public class GameState {
    private World world;
    private EngimonInitializer initializer;
    private int round;
    private Player player;
    private Spawner spawner;
    private Random random = new Random();
    private Breeder breeder;
    public final int MOVE_ROUND = 5;
    public final int SPAWN_ROUND = 7;
    public final int START_ENGIMON = 3;
    public final int LEVELUP_ENGIMON = 9;

    public GameState(World world){
        this.world = world;
        this.round = 1;
        this.initializer = new EngimonInitializer();
        this.player = new Player(0, 0);
        for (int i = 0; i < 3; i++) {
            player.addEngimon(initializer.getEngimon(random.nextInt(EngimonInitializer.getNumEngimon())).cloneDefaultTamed());
        }
        world.addEntities(player, 0, 0);
        this.spawner = new Spawner(spawner.MIN_WILD + random.nextInt((spawner.MAX_WILD - spawner.MIN_WILD)), world, initializer);
    }

    public void reload(){
        try {
            executeCommand(readCommand());
            round++;
            regenerateWildEngimons();
            System.out.println("Ronde: " + round);
        } catch (InvalidCommandException e){
            e.showErrorMessage();
        }
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

    public void executeCommand(String command) throws InvalidCommandException {
        switch (command){
            case "Move":
                new MoveCommand(this).execute();
                break;
            case "Breed":
                new BreedCommand(this).execute();
                break;
            case "Stat":
                new ShowStatCommand(this).execute();
                break;
            default:
                throw new InvalidCommandException();
        }
    }

    public void movePlayerBy(int dx, int dy) throws PlayerOutOfMapException, OccupiedCellException {
        int x = player.getCoordinate().getX() + dx;
        int y = player.getCoordinate().getY() + dy;
        if(!world.validCell(x, y)){
            throw new PlayerOutOfMapException();
        }
        if(!(world.getEntities(x, y) instanceof Air)){
            throw new OccupiedCellException();
        }
        world.moveEntities(player.getCoordinate().getX(), player.getCoordinate().getY(), x, y);
        player.setCoordinate(world.getCell(x, y));
    }

    public Engimon getPlayerEngimonWithIndex(int idx){
        return player.getMyInventoryEngimon().getSpesifikMember(idx);
    }

    public void addNewEngimon(Engimon newEngimon){
        player.addEngimon(newEngimon);
    }

    public String readCommand(){
        System.out.println("Silakan masukkan command pilihan anda:");
        System.out.println("Command yang dapat dimasukkan:");
        System.out.println("1. Move (melakukan pergerakan)");
        System.out.println("2. Breed (mengawinkan engimon)");
        System.out.println("3. Stat (melihat data dari engimon yang dipunyai)");
        System.out.println("4. Switch (mengganti active engimon)");
        System.out.println("5. SkillItem (melihat dan mengatur skill item yang ada)");
        System.out.println("6. Battle (bertarung dengan wild engimon yang ada)");
        System.out.println("7. Interact (berinteraksi dengan active engimon)");
        System.out.println("8. Exit (untuk keluar dari permainan)");
        System.out.println("Command yang ingin dilakukan:");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        return command;
    }

    public void showEngimonStat(){
        for (Engimon e: player.getMyInventoryEngimon().getInventoryEngimon()) {
            e.showStat();
        }
    }
}
