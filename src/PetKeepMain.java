import java.util.Scanner;

public class PetKeepMain {
    public static void main(String[] args) {

//HELLOOO
//
//      1. Add pet
//      2. See list of pets
//      3. Info about a pet (choose by name)
//      4. Add medicine for a pet
//      5. Add vaccine for a pet
//      6. Add info about food for a pet
//      7. See vaccine schedule
//      8. Add info about allergies
//      9. Delete medicine for a pet
//      10. Delete vaccine for a pet
//      11. Delete food info
//      12. Delete pet
//      13. EXIT

        Scanner scanner = new Scanner(System.in);
        int menuItem = 1;

        do {
            System.out.println("~~~~");
            System.out.println("HELLO");
            System.out.println("~~~~");
            System.out.println("CHOOSE YOUR OPTION");
            System.out.println("1. - ADD PET");
            System.out.println("2. - SEE THE LIST OF PETS");
            System.out.println("3. - SEE THE INFO ABOUT A PET");
            System.out.println("4. - SEE THE VACCINATION SCHEDULE");
            System.out.println("5. - SEE THE INFO ABOUT MEDICINE");
            System.out.println("6. - ADD FOOD INFORMATION");
            System.out.println("7. - ADD A NEW MEDICINE FOR A PET");
            System.out.println("8. - ADD A NEW VACCINE FOR A PET");
            System.out.println("9. - ADD INFO ABOUT ALLERGIES");
            System.out.println("10. - DELETE MEDICINE FOR A PET");
            System.out.println("11. - DELETE VACCINE FOR A PET");
            System.out.println("12. - DELETE FOOD FOR A PET");
            System.out.println("13. - DELETE  A PET :(");
            System.out.println("0. - EXIT");


        }
        while (menuItem != 0);


    }

    public static void addPet() {

    }


}
