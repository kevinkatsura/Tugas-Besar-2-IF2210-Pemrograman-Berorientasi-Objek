import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

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
        if (totalMember >= max_capacity){
            System.out.println("Inventory Penuh!"); // Sesuaikan dengan GUI
        } else{
            listEngimon.add(newMember);
            totalMember+=1;
            this.listEngimon = listEngimon.stream()
                    .sorted(comparingInt(Engimon::getLevel).reversed())
                    .collect(groupingBy(Engimon::getName, LinkedHashMap::new, toList()))
                    .values().stream()
                    .flatMap(Collection::stream)
                    .collect(toList());

//            Collections.sort(listEngimon, new Comparator<Engimon>() {
//                @Override
//                public int compare(Engimon o1, Engimon o2) {
//                    if(o1.getName().compareTo(o2.getName()) == 0){
//                        return o2.getLevel() - o1.getLevel();
//                    } else{
//                        return o1.getName().compareTo(o2.getName());
//                    }
//                }
//            });

        }
    }

    public List<Engimon> getListEngimon() {
        return listEngimon;
    }

    public int getSize(){
        return listEngimon.size();
    }

    public List<Engimon> getInventoryEngimon() {
        return listEngimon;
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