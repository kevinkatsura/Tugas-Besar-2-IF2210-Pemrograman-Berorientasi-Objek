public class World {
    private
    Cell[][] coordinates;
    int baris;
    int kolom;
    public
    World(int baris, int kolom){
        coordinates = new Cell[baris][kolom];
        this.baris = baris;
        this.kolom = kolom;
        for(int i = 0; i < baris; i++){
            for(int j = 0; j < kolom; j++){
                coordinates[j][i] = new Cell(i, j);
            }
        }
    }

    Entity getEntities(int x, int y){
        return coordinates[y][x].getEntity();
    }

    void addEntities(Entity e, int x, int y){
        coordinates[y][x].setEntity(e);
    }

    void removeEntities(int x, int y){
        coordinates[y][x].setEntity(new Air(x, y));
    }

    void moveEntities(int xold, int yold, int xnew, int ynew){
        addEntities(getEntities(xold, yold), xnew, ynew);
        removeEntities(xold, yold);
    }

    int getBaris(){
        return baris;
    }

    int getKolom(){
        return kolom;
    }

    CellType getCellType(int x, int y){
        return  coordinates[y][x].cellType;
    }
}
