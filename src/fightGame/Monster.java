package fightGame;

public class Monster {
    private double maxHp;
    private double currentHp;
    private double basicAttackDmg;
    private double strongAttackDmg;

//CONSTRUCTORS
    public Monster(double maxHp, double basicDamage){
        this.maxHp=maxHp;
        this.basicAttackDmg=basicDamage;
    }
    public Monster(double maxHp, double basicDamage, double strongDamage){
        this.maxHp=maxHp;
        this.basicAttackDmg=basicDamage;
        this.strongAttackDmg=strongDamage;
    }

//MONSTER ATTACKS
    /** 
     * Monster attacks @param player
     * Player health is decreased by monster BASIC attack damage
     */
    public void monsterBasicAttack(Personatge player){
        player.loseHp(this.basicAttackDmg);
    }
    
    /** 
     * Monster attacks @param player
     * Player health is decrease by monster STRONG attack damage
     */
    public void monsterStrongAttack(Personatge player){
        player.loseHp(strongAttackDmg);
    }
}
