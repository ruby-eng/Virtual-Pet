package Backend.java.pet;

public class Pet {
    private int hunger = 50;
    private int happiness = 50;
    private  int energy = 50;

    public int getHunger(){
        return hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getEnergy() {
        return energy;
    }

    public void feed() {
        hunger -= 10;
        if (hunger < 0) hunger = 0;
    }
    public void play(){
        happiness += 10;
        energy -= 10;
        if(happiness > 100) happiness = 100;
        if(energy < 0) energy = 0;
    }
    public void sleep(){
        energy += 20;
        if (energy > 100) energy = 100;
    }
}