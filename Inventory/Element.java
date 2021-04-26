import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Element {
    private int id;
    private String elementName;
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

    public String getElementName(){
        return this.elementName;
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

    public ArrayList<Element> inheritedElementsWhenBreed(Element e){
        ArrayList<Element> elements = new ArrayList<Element>();
        if(getAdvantageToElement(e) > 1){
            elements.add(this);
        } else if(getAdvantageToElement(e) < 1){
            elements.add(e);
        } else {
            elements.add(this);
            elements.add(e);
        }
        return elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return id == element.id && elementName.equals(element.elementName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, elementName);
    }
}
