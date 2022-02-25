import java.util.Scanner;

public class Battle
{

    public static void main (String[] args)
    {
        //main method variables
        Scanner in = new Scanner(System.in);
        String choice;
        int damage;

        //two instances of the player class
        Player you = new Player();//user
        Player cpu = new Player();//computer

        do {
            System.out.println("Your HP: " + you.getHitPoint());
            System.out.println("Other HP: " + cpu.getHitPoint());
            System.out.print("Press h to hit, q to quit: ");
            choice = in.nextLine();
            System.out.println();

            //check for invalid input
            while(!(choice.equalsIgnoreCase("q") || choice.equalsIgnoreCase("h")))
            {
                System.out.println(choice + " is an invalid choice. Please try again.");
                System.out.print("Press h to hit, q to quit: ");
                choice = in.nextLine();
            }

            if(choice.equalsIgnoreCase("q")){
                break;
            }

            //calling setStrength method to random generate numbers
            you.setStrength();
            cpu.setStrength();

            System.out.print("Your Strength: " + you.getStrength() + ", their strength: " +cpu.getStrength() + ". ");

            //if Player Strength is greater
            if (you.getStrength() > cpu.getStrength())
            {
                //calculating damage
                damage = you.getStrength() - cpu.getStrength();
                //sending damage to setHitPoint method to subtract damage from hp
                cpu.setHitPoint(damage);
                System.out.println("They have " + damage + " damage.");
            }

            //if Computer Strength is greater
            else if (you.getStrength() < cpu.getStrength())
            {
                //calculating damage
                damage = cpu.getStrength() - you.getStrength();
                //sending damage to setHitPoint method to subtract damage from hp
                you.setHitPoint(damage);
                System.out.println("You have " + damage + " damage");
            }

            //if both players have even strength
            else
            {
                System.out.println("Strength evenly matched. Both players take no damage.");
            }

            //Computer KO
            if (cpu.getHitPoint() <= 0){
                System.out.println("Computer KO. You win!");
                break;
            }
            //Player KO
            else if (you.getHitPoint() <= 0 ) {
                System.out.println("Player KO. Computer wins!");
                break;
            }
            //Tie
            else if(you.getHitPoint() <= 0 && cpu.getHitPoint() <= 0)
            {
                System.out.println("Both players KO. Tie Game!");
                break;
            }

        }while(!(choice.equalsIgnoreCase("q")));
    }
}
