import java.util.ArrayList;
import java.util.List;

/**
 * inventoryengimon
 */
public class InventoryEngimon extends Inventory<Engimon> {
    List<Engimon> listEngimon;

    // Constructor
    public InventoryEngimon(){
        listEngimon = new ArrayList<Engimon>();
    }

    @Override
    public Engimon getSpesifikMember(int index){
        return listEngimon.get(index);
    }
    public List<Engimon> getListEngimon() {
        return listEngimon;
    }
    @Override
    public void addMember(Engimon newMember ){
        // Belum di-group berdasarkan element dan level
        listEngimon.add(newMember);
        totalMember+=1;
    }

    public Engimon changeEngimon(Engimon engimon, int index){
        Engimon bufferEngimon = listEngimon.get(index);
        listEngimon.set(index,engimon);
        return bufferEngimon;
    }
    public void showListEngimon(){
        for (int i = 0; i < listEngimon.size(); i++) {
            // Menyesuaikan dengan Engimon
            System.out.println(i+1 + ". " + getSpesifikMember(i)); // Belum selesai
        }
    }
}