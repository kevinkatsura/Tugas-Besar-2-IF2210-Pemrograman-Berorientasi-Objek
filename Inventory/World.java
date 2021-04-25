import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class World {
    private Cell[][] coordinates;
    private int baris;
    private int kolom;
    public World(int baris, int kolom){
        coordinates = new Cell[baris][kolom];
        this.baris = baris;
        this.kolom = kolom;
        for(int i = 0; i < baris; i++){
            for(int j = 0; j < kolom; j++){
                coordinates[j][i] = new Cell(i, j);
            }
        }
    }

    public World(int baris, int kolom, String namaFile){
        coordinates = new Cell[baris][kolom];
        this.baris = baris;
        this.kolom = kolom;
        try{
            File mapFile = new File(namaFile);
            Scanner mapFileReader = new Scanner(mapFile);
            int i = 0;
            while (mapFileReader.hasNextLine()){
                String line = mapFileReader.nextLine();
                char[] charArray = line.toCharArray();
                int j = 0;
                for(char ch: charArray){
                    if(ch == 'T'){
                       coordinates[i][j] = new Cell(j, i, CellType.TUNDRA);
                    } else if(ch == 'M'){
                        coordinates[i][j] = new Cell(j, i, CellType.MOUNTAINS);
                    } else if(ch == 'S'){
                        coordinates[i][j] = new Cell(j, i, CellType.SEA);
                    } else if(ch == 'G'){
                        coordinates[i][j] = new Cell(j, i, CellType.GRASSLAND);
                    } else {
                        throw new IllegalInputCellTypeException();
                    }
                    j++;
                }
                i++;
            }
        } catch(FileNotFoundException e){
            System.out.println("File tidak ditemukan");
        } catch (IllegalInputCellTypeException e){
            System.out.println("File map yang anda masukkan memuat input yang ilegal");
        }
    }

    public Entity getEntities(int x, int y){
        return coordinates[y][x].getEntity();
    }

    public void addEntities(Entity e, int x, int y){
        coordinates[y][x].setEntity(e);
    }

    public void removeEntities(int x, int y){
        coordinates[y][x].setEntity(new Air());
    }

    public void moveEntities(int xold, int yold, int xnew, int ynew){
        addEntities(getEntities(xold, yold), xnew, ynew);
        removeEntities(xold, yold);
    }

    public int getBaris(){
        return baris;
    }

    public int getKolom(){
        return kolom;
    }

    public CellType getCellType(int x, int y){
        return  coordinates[y][x].getCellType();
    }

    public boolean validCell(int x, int y){
        return(x >= 0 && y >= 0 && x < kolom && y < baris);
    }

    public Cell getCell(int x, int y){
        return coordinates[y][x];
    }
}
