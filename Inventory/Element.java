import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Element {
    private
    int id;
    String elementName;
    static final double[][] advantage = {
            {1, 0, 1, 0.5, 2},
            {2, 1, 0, 1, 1},
            {1, 2, 1, 0, 1.5},
            {1.5, 1, 2, 1, 0},
            {0, 1, 0.5, 2, 1}
    };

    public Element(String elementName) {
        ArrayList<String> allElements = new ArrayList<String>(
                Arrays.asList("Fire", "Water", "Electric", "Ground", "Ice"));
        if(allElements.contains(elementName)){
            this.elementName = elementName;
            this.id = allElements.indexOf(elementName);
        } else {
            // Gagal
        }
    }

    public double getAdvantageToElement(Element e){
        return advantage[this.id][e.id];
    }

    public boolean isValidInCellType(CellType cellType){
        return (elementName.equals("Fire") && cellType == CellType.MOUNTAINS
                || elementName.equals("Water") && cellType == CellType.SEA
                || elementName.equals("Ground") && cellType == CellType.GRASSLAND
                || elementName.equals("Electric")  && cellType == CellType.GRASSLAND
                || elementName.equals("Ice") && cellType == CellType.TUNDRA);
    }

}
