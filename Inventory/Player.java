public class Player extends Entity{
    public Player(){ super();}
    public Player(int x, int y){ super(x, y);}
    public Player(Player target){
        super(target);
    }

    @Override
    public Entity clone() {
        return new Player(this);
    }
}
