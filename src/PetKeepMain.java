import java.util.Scanner;

public class PetKeepMain {
    public static void main(String[] args) {

        DBConnection petKeepDb = new DBConnection();

        Scanner scanner = new Scanner(System.in);
        int menuItem;

        do {
            System.out.println("~~~~");
            System.out.println("HELLO");
            System.out.println("~~~~");
            System.out.println("CHOOSE YOUR OPTION");
            System.out.println("1. - ADD A PET");
            System.out.println("2. - SEE THE LIST OF PETS");
            System.out.println("3. - SEE INFORMATION ABOUT A PET");
            System.out.println("4. - SEE THE VACCINATION SCHEDULE");
            System.out.println("5. - SEE INFORMATION ABOUT MEDICINE");
            System.out.println("6. - ADD FOOD INFORMATION");
            System.out.println("7. - ADD A NEW MEDICINE FOR A PET");
            System.out.println("8. - ADD A NEW VACCINE FOR A PET");
            System.out.println("9. - ADD INFO ABOUT ALLERGIES");
            System.out.println("10. - DELETE MEDICINE FOR A PET");
            System.out.println("11. - DELETE VACCINE FOR A PET");
            System.out.println("12. - DELETE FOOD FOR A PET");
            System.out.println("13. - DELETE A PET :(");
            System.out.println("0. - EXIT");
            menuItem = scanner.nextInt();

            switch (menuItem) {
                case 1:
                    // Creating a new Pets object
                    Pets myPet = new Pets();

                    // 1. Asking user to input their pet's name with some validation
                    String name;
                    int checkName = 0;

                    do {
                        System.out.println("Enter your pet's name");
                        name = scanner.next();
                        if (name.matches("[A-Z][a-zA-Z]*")) {
                            myPet.setName(name);
                            checkName = 1;
                        } else {
                            System.out.println("Invalid name.. try again.");
                        }
                    } while (checkName == 0);


                    // 2. Asking user to input their pet's type with some validation
                    String type;
                    int checkType = 0;

                    do {
                        System.out.println("What type of animal is it? (Dog, Cat, etc.");
                        type = scanner.next();
                        if (type.matches("[A-Z][a-zA-Z]*")) {
                            myPet.setAnimalType(type);
                            checkType = 1;
                        } else {
                            System.out.println("Invalid animal type.. try again.");
                        }
                    } while (checkType == 0);


                    // 3. Asking user to input their pet's breed with some validation

                    //..to be continued..



                    break;
                case 2:


                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 12:

                    break;
                case 13:

                    break;
                default:
                    if (menuItem != 0)
                        System.out.println("Menu item does not exist!");
                    System.out.println();
            }



        } while (menuItem != 0);





    }
}
