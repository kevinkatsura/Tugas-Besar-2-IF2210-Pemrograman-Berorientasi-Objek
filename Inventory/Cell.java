import java.util.ArrayList;
import java.util.Collections;

public class Cell {
    private final int X;
    private final int Y;
    private CellType cellType;
    private Entity entity;
    char symbol;
    public
    Cell(int X, int Y){
        this.X = X;
        this.Y = Y;
        this.entity = new Air();
    }

    Cell(int X, int Y, CellType cellType){
        this.X = X;
        this.Y = Y;
        this.entity = new Air();
        this.cellType = cellType;
    }

    CellType getCellType() {
        return cellType;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
