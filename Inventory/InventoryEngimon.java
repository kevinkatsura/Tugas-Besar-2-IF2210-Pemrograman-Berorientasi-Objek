import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * inventoryengimon
 */
public class InventoryEngimon extends Inventory<Engimon> {

    // Atribut
    private List<Engimon> listEngimon;

    // Constructor
    public InventoryEngimon(){
        listEngimon = new ArrayList<Engimon>();
    }

    @Override
    public Engimon getSpesifikMember(int index){
        return listEngimon.get(index);
    }

    @Override
    public void addMember(Engimon newMember){
        // Belum di-group berdasarkan element dan level
        listEngimon.add(newMember);
        totalMember+=1;
        Collections.sort(listEngimon, new Comparator<Engimon>() {
            @Override
            public int compare(Engimon o1, Engimon o2) {
                if(o1.getName().compareTo(o2.getName()) == 0){
                    return o2.getLevel() - o1.getLevel();
                } else{
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });
    }

    public List<Engimon> getListEngimon() {
        return listEngimon;
    }

    public int getSize(){
        return listEngimon.size();
    }

    public Engimon changeEngimon(Engimon engimon, int index){
        Engimon bufferEngimon = listEngimon.get(index);
        listEngimon.set(index,engimon);
        return bufferEngimon;
    }

}