public class Air extends Entity{
    public Air(){ super(); }
    public Air(Air target){ super(target);}

    @Override
    public Entity clone() {
        return new Air(this);
    }
}
