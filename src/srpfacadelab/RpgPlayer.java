package srpfacadelab;

import java.util.List;
import java.util.ArrayList;


public class RpgPlayer {
    public static final int MAX_CARRYING_CAPACITY = 1000;

    public final IGameEngine gameEngine;

    private int health;

    private int maxHealth;

    private int armour;

    private List<Item> inventory;

    // How much the player can carry in pounds
    private int carryingCapacity;

    public RpgPlayer(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        inventory = new ArrayList<Item>();
        carryingCapacity = MAX_CARRYING_CAPACITY;
    }

    public void useItem(Item item) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = gameEngine.getEnemiesNear(this);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

//    public boolean pickUpItem(Item item) {
//        int weight = calculateInventoryWeight();
//        if (weight + item.getWeight() > carryingCapacity)
//            return false;
//
//        if (item.isUnique() && checkIfItemExistsInInventory(item))
//            return false;
//
//        // Don't pick up items that give health, just consume them.
//        if (item.getHeal() > 0) {
//            health += item.getHeal();
//
//            if (health > maxHealth)
//                health = maxHealth;
//
//            if (item.getHeal() > 500) {
//                gameEngine.playSpecialEffect("green_swirly");
//            }
//
//            return true;
//        }
//
//        if (item.isRare())
//            gameEngine.playSpecialEffect("cool_swirly_particles");
//
//        if (item.isRare() && item.isUnique())
//            game.Engine.playSpecialEffect("blue_swirly");
//
//        inventory.add(item);
//
//        calculateStats();
//
//        return true;
//    }

//    private void calculateStats() {
//        for (Item i: inventory) {
//            armour += i.getArmour();
//        }
//    }
//
//    private boolean checkIfItemExistsInInventory(Item item) {
//        for (Item i: inventory) {
//            if (i.getId() == item.getId())
//                return true;
//        }
//        return false;
//    }
//
//    private int calculateInventoryWeight() {
//        int sum=0;
//        for (Item i: inventory) {
//            sum += i.getWeight();
//        }
//        return sum;
//    }

//    public void takeDamage(int damage) {
//        if (damage < armour) {
//            gameEngine.playSpecialEffect("parry");
//        }
//
//        int damageToDeal = damage - armour;
//
//        if (calculateInventoryWeight() <= carryingCapacity)
//            damageToDeal = damageToDeal * .75;
//
//        health -= damageToDeal;
//
//        gameEngine.playSpecialEffect("lots_of_gore");
//    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }
}
