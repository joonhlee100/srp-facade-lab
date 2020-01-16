package srpfacadelab;

public interface PlayerFacade {
    void calculateStats();
    int calculateInventoryWeight();
    void takeDamage(int damage);
    boolean checkIfItemExistsInInventory(Item item);
    boolean pickUpItem(Item item);
}