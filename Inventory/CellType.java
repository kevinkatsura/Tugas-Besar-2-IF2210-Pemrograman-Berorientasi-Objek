import java.util.ArrayList;

public enum CellType {
    MOUNTAINS, SEA, GRASSLAND, TUNDRA;
    public ArrayList<Element> getValidElements(){
        ArrayList<Element> validElements = new ArrayList<Element>();
        if(this == CellType.MOUNTAINS){
            validElements.add(new Element("Fire"));
        } else if(this == CellType.GRASSLAND){
            validElements.add(new Element("Electric"));
            validElements.add(new Element("Ground"));
        } else if(this == CellType.SEA){
            validElements.add(new Element("Sea"));
        } else if(this == CellType.TUNDRA){
            validElements.add(new Element("Ice"));
        }
        return validElements;
    }
}
