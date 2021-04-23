public class Air extends Entity{
    public Air(int x, int y){ super(x, y); }
    public Air(Air target){ super(target);}

    @Override
    public Entity clone() {
        return new Air(this);
    }
}
