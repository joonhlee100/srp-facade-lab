package srpfacadelab;

public class Inventory implements PlayerFacade{
    private RpgPlayer player;

    public Inventory(RpgPlayer player) {
        this.player = player;
    }

    private void calculateStats() {
        for (Item i: player.getInventory()) {
            player.setArmour(player.getArmour + i.getArmour());
        }
    }

    private int calculateInventoryWeight() {
        int sum=0;
        for (Item i: player.getInventory()) {
            sum += i.getWeight();
        }
        return sum;
    }

    private void takeDamage(int damage) {
        if (damage < player.getArmour()) {
            player.gameEngine.playSpecialEffect("parry");
        }

        int damageToDeal = damage - player.getArmour();

        if (calculateInventoryWeight() <= player.getCarryingCapacity())
            damageToDeal = damageToDeal * .75;

        player.setHealth(player.getHealth()-damageToDeal);

        player.gameEngine.playSpecialEffect("lots_of_gore");
    }

    private boolean checkIfItemExistsInInventory(Item item) {
        for (Item i: player.getInventory()) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }

    private boolean pickUpItem(Item item) {
        int weight = calculateInventoryWeight();
        if (weight + item.getWeight() > player.getCarryingCapacity())
            return false;

        if (item.isUnique() && checkIfItemExistsInInventory(item))
            return false;

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            player.setHealth(player.getHealth() + item.getHeal());

            if (player.getHealth() > player.getMaxHealth())
                player.setHealth(player.getMaxHealth());

            if (item.getHeal() > 500) {
                player.gameEngine.playSpecialEffect("green_swirly");
            }

            return true;
        }

        if (item.isRare())
            player.gameEngine.playSpecialEffect("cool_swirly_particles");

        if (item.isRare() && item.isUnique())
            player.gameEngine.playSpecialEffect("blue_swirly");

        player.getInventory().add(item);

        calculateStats();

        return true;
    }
}