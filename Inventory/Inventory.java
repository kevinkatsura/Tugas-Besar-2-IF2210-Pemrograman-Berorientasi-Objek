/**
 * Inventory
 */
abstract class Inventory<T extends Item> { // Jangan lupa buat Engimon dan Skill implements item

    // Kapasitasi maksimum dari Inventory
    private final int max_capacity = 20;
    protected static int totalMember;

    // Constructor
    public Inventory(){
        totalMember = 0;
    }
    public abstract T getSpesifikMember(int index);
    public abstract void addMember(T newMember);
}
