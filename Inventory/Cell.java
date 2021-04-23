import java.util.ArrayList;
import java.util.Collections;

public class Cell {
    private
    final int X;
    final int Y;
    CellType cellType;
    Entity entity;
    char symbol;
    public
    Cell(int X, int Y){
        this.X = X;
        this.Y = Y;
        this.entity = new Air(X, Y);
    }

    Cell(int X, int Y, CellType cellType){
        this.X = X;
        this.Y = Y;
        this.entity = new Air(X, Y);
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


}
