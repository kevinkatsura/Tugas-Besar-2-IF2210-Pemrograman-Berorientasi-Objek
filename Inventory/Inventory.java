/**
 * Inventory
 */
abstract class Inventory<T extends Item> { // Jangan lupa buat Engimon dan Skill implements item

    // Kapasitasi maksimum dari Inventory
    protected final int max_capacity = 20;
    protected static int totalMember;

    // Constructor
    public Inventory(){
    }
    public abstract T getSpesifikMember(int index);
    public abstract void addMember(T newMember);
}
