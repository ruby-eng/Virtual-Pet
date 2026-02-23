package Backend.java.pet;

public class PetService {
    private static Pet pet = new Pet();

    public static Pet getPet() {
        return pet;
    }
    public static void feedPet(){
        pet.feed();
    }
    public static void playwithPet(){
        pet.play();
    }
    public static void putPettosleep(){
        pet.sleep();
    }
}
