import java.util.Random;

public class Player {

    //private variables
    private static Random r = new Random();
    private int hitPoint;
    private int strength;

    //constructor to set hit points and strength
    public Player(){
        this.hitPoint = 100;
        this.strength = 1;
    }

    //setter for strength with random generator
    public void setStrength(){
        this.strength = r.nextInt(25)+1;
    }

    //setter for receiving damage
    public int setHitPoint(int damage) {
        this.hitPoint -= damage;
        return hitPoint;
    }

    //Strength getter
    public int getStrength(){
        return strength;
    }

    //Hit point getter
    public int getHitPoint(){
        return hitPoint;
    }


}
