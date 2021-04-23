import java.util.ArrayList;

public abstract class Entity {
    private Cell coordinate;

    public Entity(){ coordinate = new Cell(0,0);}

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
