public class Player extends Entity{
    public
    Player(){ super();}
    Player(int x, int y){ super(x, y);}
    Player(Player target){
        super(target);
    }

    @Override
    public Entity clone() {
        return new Player(this);
    }
}
