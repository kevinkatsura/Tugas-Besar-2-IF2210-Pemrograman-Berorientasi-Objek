import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class InventorySkill extends Inventory<Skill>{
    private Map<Skill,Integer> mapOfSkill;

    // Constructor
    public InventorySkill(){
        mapOfSkill = new TreeMap<Skill,Integer>( new SortByBasePower());
    }
    @Override
    public Skill getSpesifikMember(int index) {
        return mapOfSkill;
    }

    public Map<Skill,Integer> getMapSkill() {
        return mapOfSkill;
    }

    @Override
    public void addMember(Skill newMember) {
        if(mapOfSkill.containsKey(newMember)){
            mapOfSkill.put(newMember,(k,v)->v+1);
        }else{
            mapOfSkill.put(newMember,1);
        }
        totalMember+=1;
    }
}

class SortByBasePower implements Comparator<Skill> {
    @Override
    public int compare(Skill o1, Skill o2) {
        // Contoh return kalau berdasarkan base power : o1.basepower - o2.basepower
        return 0;
    }
}

