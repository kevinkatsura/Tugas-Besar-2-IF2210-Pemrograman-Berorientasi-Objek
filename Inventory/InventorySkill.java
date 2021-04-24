import java.util.*;

public class InventorySkill extends Inventory<Skill>{
    private TreeMap<Skill,Integer> mapOfSkill;

    // Constructor
    public InventorySkill(){
        mapOfSkill = new TreeMap<Skill,Integer>();
    }

    public Map<Skill,Integer> getInventorSkill() {
        return mapOfSkill;
    }

    public int getSize() {
        return mapOfSkill.size();
    }

    @Override
    public Skill getSpesifikMember(int index) {
        Set<Map.Entry<Skill, Integer> > entrySet = mapOfSkill.entrySet();
        List<Map.Entry<Skill, Integer> > entryList = new ArrayList<>(entrySet);
        return entryList.get(index).getKey();
    }

    @Override
    public void addMember(Skill newMember) {
        if ( totalMember >= max_capacity){
            System.out.println("Inventory Penuh!"); // Sesuaikan sama GUI
        } else{
            int count = mapOfSkill.containsKey(newMember) ?mapOfSkill.get(newMember) : 0 ;
            mapOfSkill.put(newMember,count + 1);
            totalMember+=1;
        }

    }
}



