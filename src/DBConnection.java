import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class DBConnection {

    Scanner scanner = new Scanner(System.in);

    public Connection conn;

    public DBConnection() {

        try {
            String dbUrl = "jdbc:sqlite:petKeep.db";
            conn = DriverManager.getConnection(dbUrl);

            if (conn != null) {
                DatabaseMetaData databaseMetadata = conn.getMetaData();
                System.out.println("Connected to " + databaseMetadata.getDatabaseProductName() + " " + databaseMetadata.getDatabaseProductVersion());


                // CREATING A TABLE FOR PETS
                Statement statement = conn.createStatement();
                String sqlStatement =
                        "CREATE TABLE IF NOT EXISTS pets" +
                                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "name TEXT NOT NULL UNIQUE, " +
                                "animal_type TEXT NOT NULL, " +
                                "animal_breed TEXT NOT NULL, " +
                                "date_of_birth TEXT NOT NULL, " +
                                "gender TEXT NOT NULL, " +
                                "weight REAL NOT NULL, " +
                                "owner TEXT NOT NULL )";

                statement.execute(sqlStatement);
                

                //CREATING A TABLE FOR VACCINES
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS vaccines" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "vaccination_type TEXT NOT NULL, " +
                                "date_vaccinated TEXT NOT NULL, " +
                                "date_to_vaccinate_next TEXT NOT NULL, " +
                                "pet_id INTEGER NOT NULL)";

                statement.execute(sqlStatement);


                //CREATING A TABLE FOR FOOD
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS food" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "food_brand TEXT NOT NULL, " +
                                "food_bag_weight INTEGER NOT NULL, " +
                                "daily_amount INTEGER NOT NULL, " +
                                "purchase_date TEXT NOT NULL, " +
                                "pet_id INTEGER NOT NULL)";

                statement.execute(sqlStatement);


                //CREATING A TABLE FOR MEDICINE
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS medicine" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "type_of_meds TEXT NOT NULL, " +
                                "regularity INTEGER NOT NULL, " +
                                "date_given TEXT NOT NULL, " +
                                "date_to_give_next TEXT NOT NULL, " +
                                "pet_id INTEGER NOT NULL)";

                statement.execute(sqlStatement);
            }
        } catch (SQLException exception) {
            System.out.println("Database issues " + exception);
        }
    }




    //METHODS FOR CREATING OBJECTS AND TABLE INPUT
    public void createPet(Pets pet) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO pets (" +
                    "name, animal_type, animal_breed, date_of_birth, gender, weight, owner) " +
                    "VALUES (" +
                    "'" + pet.getName() + "'," +
                    "'" + pet.getAnimalType() + "'," +
                    "'" + pet.getAnimalBreed() + "'," +
                    "'" + pet.getDateOfBirth() + "'," +
                    "'" + pet.getGender() + "'," +
                    +pet.getWeight() + "," +
                    "'" + pet.getOwner() + "'" +
                    ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error creating a Pet : " + exception);
        }
    }

    public void createFood(Food food) {

        try {
            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO food (" +
                    "food_brand, food_bag_weight, daily_amount, purchase_date, pet_id) " +
                    "VALUES (" +
                    "'" + food.getFoodBrand() + "'," +
                    +food.getFoodBagWeight() + "," +
                    +food.getDailyAmount() + "," +
                    "'" + food.getPurchaseDate()  + "'," +
                    + food.getPetId() + ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error entering Food info : " + exception);
        }
    }

    public void createMedicine(Medicine medicine) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO medicine (" +
                    "type_of_meds, regularity, date_given, date_to_give_next, pet_id) " +
                    "VALUES (" +
                    "'" + medicine.getTypeOfMeds() + "'," +
                    + medicine.getRegularity() + "," +
                    "'" + medicine.getDateGiven() + "'," +
                    "'" + medicine.getDateToGiveNext() + "'," +
                    + medicine.getPetId() + ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error entering Medicine info : " + exception);
        }
    }

    public void createVaccine(Vaccines vaccine) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO vaccines (" +
                    "vaccination_type, date_vaccinated, date_to_vaccinate_next, pet_id) " +
                    "VALUES (" +
                    "'" + vaccine.getVaccinationType() + "'," +
                    "'" + vaccine.getDateVaccinated() + "'," +
                    "'" + vaccine.getDateToVaccinateNext() + "'," +
                    + vaccine.getPetId() + ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error entering Vaccination info : " + exception);
        }
    }




    //METHODS TO SHOW PET INFORMATION WITHOUT OTHER TABLES
    public ArrayList<Pets> seeAllPets() {

        ArrayList<Pets> allPets = new ArrayList<>();

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM pets";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {

                // Create new Pet object
                Pets pet = new Pets();
                pet.setName(rs.getString("name"));
                pet.setAnimalType(rs.getString("animal_type"));
                pet.setAnimalBreed(rs.getString("animal_breed"));
                pet.setDateOfBirth(rs.getString("date_of_birth"));
                pet.setGender(rs.getString("gender").charAt(0));
                pet.setWeight(rs.getInt("weight"));
                pet.setOwner(rs.getString("owner"));

                System.out.println(pet);
            }


        } catch (SQLException exception) {
            System.out.println("Error getting Pet list: " + exception);
        }

        return allPets;
    }

    public ArrayList<Pets> getPetNames() {

        ArrayList<Pets> petList = new ArrayList<>();

        try {
            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT name FROM pets";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                //Create a new Pets object
                Pets pet = new Pets();
                pet.setName(rs.getString("name"));

                System.out.println(pet.getName());
            }
        } catch (SQLException exception) {
            System.out.println("Error getting Pet name list: " + exception);
        }
        return petList;
    }

    public ArrayList<Pets> getOnePet() {

        ArrayList<Pets> petJustOne = new ArrayList<>();

        try {
            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM pets WHERE name = " + "'" + scanner.next() + "'";
            System.out.println();

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                //Create a new Pet object
                Pets pet = new Pets();
                pet.setName(rs.getString("name"));
                pet.setAnimalType(rs.getString("animal_type"));
                pet.setAnimalBreed(rs.getString("animal_breed"));
                pet.setDateOfBirth(rs.getString("date_of_birth"));
                pet.setGender(rs.getString("gender").charAt(0));
                pet.setWeight(rs.getDouble("weight"));
                pet.setOwner(rs.getString("owner"));


                System.out.println(pet);
            }

        } catch (SQLException exception) {
            System.out.println("Error getting One pet's information: " + exception);
        }

        return petJustOne;
    }




    //METHODS TO SELECT AND SEE INFORMATION FROM TABLES

//SHOWING INFO FROM TWO TABLES EXAMPLE
//                SELECT * FROM
//                pets
//                LEFT JOIN medicine
//                ON pets.id = medicine.pet_id
//                WHERE pets.name = 'Ezra'

    public void diffSeeVaccinationSchedule() {

        try {
            Statement statement = conn.createStatement();
            String sqlStatement;

            sqlStatement = "SELECT * FROM pets";
            ResultSet resultSet;

            sqlStatement =
                    "SELECT pets.name AS pet_name, vaccines.vaccination_type AS vaccine_type, vaccines.date_to_vaccinate_next AS next_vaccination " +
                            " FROM pets  " +
                            " JOIN vaccines  " +
                            " ON pets.id = vaccines.id " +
                            " ORDER BY vaccines.date_to_vaccinate_next";

            resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {
                String petsName = resultSet.getString("pet_name");
                String vaccineTitle = resultSet.getString("vaccine_type");
                String nextVaccination = resultSet.getString("next_vaccination");


                System.out.println("Next vaccination date: " + "|" + nextVaccination + "|" + " Vaccine: " + "|" + vaccineTitle + "|" + " PET ---> " + petsName.toUpperCase(Locale.ROOT));

            }
        } catch (SQLException exception) {

            System.out.println("Error getting vaccination schedule list " + exception);

        }

    }

    public void seeMedSchedule() {

        try {
            Statement statement = conn.createStatement();
            String sqlStatement;

            sqlStatement = "SELECT * FROM pets";
            ResultSet resultSet;

            sqlStatement =
                    "SELECT pets.name AS pet_name, medicine.type_of_meds AS medication_type, medicine.date_to_give_next AS administer_meds_next " +
                            " FROM pets  " +
                            " JOIN medicine  " +
                            " ON pets.name = medicine.pet_name " +
                            " ORDER BY medicine.date_to_give_next";

            resultSet = statement.executeQuery(sqlStatement);

            while (resultSet.next()) {
                String petsName = resultSet.getString("pet_name");
                String medicineTitle = resultSet.getString("medication_type");
                String nextMedAdministration = resultSet.getString("administer_meds_next");

                System.out.println(petsName.toUpperCase(Locale.ROOT) + " ---> " + " Next date to administer meds: " + "|" + nextMedAdministration + "|" + " Medication type: " + "|" + medicineTitle + "|");

            }
        } catch (SQLException exception) {

            System.out.println("Error getting medication schedule list " + exception);

        }

    }

    public ArrayList<Food> seeFoodInfo() {

        ArrayList<Food> allFood = new ArrayList<>();

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM food";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {

                // Create new Pet object
                Food food = new Food();
                food.setFoodBrand(rs.getString("food_brand"));
                food.setFoodBagWeight(rs.getInt("food_bag_weight"));
                food.setDailyAmount(rs.getInt("daily_amount"));
                food.setPurchaseDate(rs.getString("purchase_date"));

                System.out.println(food);
                System.out.println();
                System.out.println("This food bag will last you: " + food.foodDays() + " days from purchase date!");
                System.out.println("You will need to buy a new bag by: " + food.buyFood());
                System.out.println();
            }


        } catch (SQLException exception) {
            System.out.println("Error getting Pet list: " + exception);
        }

        return allFood;
    }




    //METHODS TO DELETE RECORDS FROM TABLES
    public void deleteMedRec() {
        try {

//            DELETE FROM employees
//            WHERE EXISTS
//            ( SELECT *
//                    FROM contacts
//            WHERE contacts.contact_id = employees.employee_id
//            AND contacts.contact_id < 100 );


            Statement statement = conn.createStatement();
            String sqlStatement = "DELETE FROM medicine" +
                    "WHERE medicine.pet_name = '%" + scanner.next() + "%' AND medicine.type_of_meds LIKE '%'" + scanner.next() + "%'";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error entering Vaccination info : " + exception);
        }
    }


}

