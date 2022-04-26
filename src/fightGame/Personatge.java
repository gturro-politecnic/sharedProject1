package fightGame;

import fightGame.Inventory.Potion;

public class Personatge {
    
    private int mapHeight, mapWidth;
    private int[][] playerPosition= new int [mapHeight][mapWidth];

    private double maxHp;
    private double currentHp;

    private double bADmg; //basic attack damage
    private double sADmg; //special attack damge

    private int baseBADistance; //base basic attack distance
    private int currentBADistance; //current basic attack distance

    private int baseMovmentUnits;
    private int currentMovementUnits;

    //Inventory
    private int maxObjects;
    private int currentObjects;
    private int weapons;
    private int potions;
    private int miscellaneous;
    private int coinBag;

    //public Inventory[] bag = new Inventory[maxObjects];

//CONSTRUCTORS
    public Personatge (int maxHp, int movementUnits ,double attackDamage){
        this.maxHp=maxHp;
        this.baseMovmentUnits=movementUnits;
        this.bADmg=attackDamage;
    }


//GETTERS
    /** 
     * @return current player health
     */
    public double getCurrentHp(){
        return this.currentHp;
    }
    
    /** 
     * @return player basic attack damage
     */
    public double getBAdmg(){
        return this.bADmg;
    }
    
    /** 
     * @return player special attack damage
     */
    public double getSAdmg(){
        return this.sADmg;
    }
    
    /** 
     * @return current player basic attack distance
     */
    public int getCurrentBADistance(){
        return this.currentBADistance;
    }
    
    /** 
     * @return player movement possible distance
     */
    public int getCurrentMovmentUnits(){
        return this.currentMovementUnits;
    }
    
    /** 
     * @return cuurent player position on the grid
     */
    public int [][] getPlayerPosition(){
        return this.playerPosition;
    }

//SETTERS
    /** 
     * Sets player max health @param newMaxHp
     */
    public void setMaxHp(double newMaxHp){
        this.maxHp=newMaxHp;
        
    }
    
    /** 
     * Sets player basic attack damage @param newDamage
     */
    public void setBasicDamage(double newDamage){
        this.bADmg=newDamage;
    }
    
    /** 
     * Sets player special attack damage @param newSpecialDamage
     */
    public void setSpecialDamage(double newSpecialDamage){
        this.sADmg=newSpecialDamage;
    }
    
    /** 
     * Sets player initial basic attack distance @param newAttackDistance
     */
    public void setbaseAttackDistance (int newAttackDistance){
        this.baseBADistance=newAttackDistance;
        //then currentBADistance = baseBADistance????
    }
    
    /** 
     * Sets player possible movment distance possible on the grid (only int)@param newMovmentUnits
     */
    public void setBaseMovementUnits (int newMovmentUnits){
        this.baseMovmentUnits=newMovmentUnits;
    }
    
    /** Sets map size with the two param:
     * @param mapHeight
     * @param mapWidth
     * This is used (reference) to place player into the grid
     */
    //map config
    public void setMapSize(int mapHeight, int mapWidth){
        this.mapHeight=mapHeight;
        this.mapWidth=mapWidth;
    }

    
    /** 
     * Check if player health is less than 0.
     * If it's less player is Dead.
     */
    public void checkIfDead(){ //QUE PASA SI ESTA MORT??
        boolean isDead = false;
        if (currentHp < 0){
            isDead= true;
        }
    }


//HP
    /** 
     * Substract health to player equal to enemy @param damage.
     */
    public void loseHp(double damage){
        this.currentHp-=damage;
        checkIfDead();
    }
    
    /** 
     * Player gain health equal to @param heal.
     * If the heal exeeds player max hp --> currentHp is set to maxHp.
     */
    public void gainHp(double heal){
        this.currentHp+=heal;
        if (this.currentHp > this.maxHp){
            healFullHp();
        }
    }
    /**
     * Sets current health to max
     */
    public void healFullHp(){
        this.currentHp=this.maxHp;
    }
    
    /** 
     * Heals player for taking a @param potion
     * get healing amount of potion and += to player current health
     */
    public void takePotion (Potion potion){
        gainHp(potion.getHealingAmount());
    }


//MOV
    /** 
     * Increase player possible movement units by: @param buff
     */
    public void buffMovement(int buff){
        this.currentMovementUnits+= buff;
    }
    
    /** 
     * Decreases player possible movement units by: @param debuff
     */
    public void debuffMovement(int debuff){
        this.currentMovementUnits-=debuff;
    }

    /**
     * Sets player possible movement units to initial mov units
     */
    public void resetMovement(){
        this.currentMovementUnits=this.baseMovmentUnits;
    }

//COMBAT
    /** 
     * Current player attacks @param enemyPlayer
     * Substract enemy hp equal to thisPlayer basic attack damage
     */
    public void basicAttackPlayer (Personatge enemyPlayer){
        enemyPlayer.currentHp-=this.bADmg;
    }
    
    //public void specialAttackPlayer() ??

    /** 
     * Increase player basic attack distance by: @param buff
     */

    public void buffAttackDistance(int buff){
        this.currentBADistance+=buff;
    }
    
    /** 
     * Decrease player basic attack distance by: @param debuff
     */
    public void debuffAttackDistance(int debuff){
        this.currentBADistance-=debuff;
    }

    /**
     * Resets player basic attack distance to baseBADistance
     */
    public void resetAttackDistance(){
        this.currentBADistance=this.baseBADistance;
    }

  


}