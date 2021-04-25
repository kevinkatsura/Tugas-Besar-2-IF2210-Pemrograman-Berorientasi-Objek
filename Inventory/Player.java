public class Player extends Entity{
    private int maxLevelEngimon;
    private Engimon myEngimon;
    private InventoryEngimon myInventoryEngimon;
    private InventorySkill myInventorySkill;


    public Player(int x, int y){
        super(x, y);
        this.myInventoryEngimon = new InventoryEngimon();
        this.myInventorySkill = new InventorySkill();
    }
    
    public Player(Entity target){
        super(target);
        this.myInventoryEngimon = new InventoryEngimon();
        this.myInventorySkill = new InventorySkill();
    }

    public  Engimon getMyEngimon(){
        return this.myEngimon;
    }
    public InventoryEngimon getMyInventoryEngimon(){
        return this.myInventoryEngimon;
    }
    public InventorySkill getMyInventorySkill(){
        return this.myInventorySkill;
    }
    public int getMaxLevelEngimon() { return maxLevelEngimon; }

    @Override
    public Entity clone() {
        return new Player(this);
    }
}
