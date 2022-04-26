package fightGame.Inventory;

public class Potion {
    private double healingAmount;

    public Potion(double healingAmount){
        this.healingAmount = healingAmount;
    }
    
    /** 
     * @return double
     */
    public double getHealingAmount(){
        return this.healingAmount;
    }
}
