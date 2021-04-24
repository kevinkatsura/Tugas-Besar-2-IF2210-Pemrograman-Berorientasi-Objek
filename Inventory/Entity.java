import java.util.ArrayList;

public abstract class Entity {
    protected Cell coordinate;

    public Entity(){}

    public Entity(int x, int y){ coordinate = new Cell(x,y); }

    public Entity(Entity target){
        if(target != null){
            coordinate = target.coordinate;
        }
    }

    public Cell getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Cell coordinate) {
        this.coordinate = coordinate;
    }

    public abstract Entity clone();
}
