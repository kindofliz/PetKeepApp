import java.util.Scanner;

public class PetKeepMain {
    public static void main(String[] args) {

        DBConnection petKeepDb = new DBConnection();

        Scanner scanner = new Scanner(System.in);
        int menuItem = 0;

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
