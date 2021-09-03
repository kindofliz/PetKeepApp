import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

    private Connection conn;

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
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "name TEXT NOT NULL, " +
                                "animal_type TEXT NOT NULL, " +
                                "animal_breed TEXT NOT NULL, " +
                                "date_of_birth TEXT NOT NULL, " +
                                "gender TEXT NOT NULL, " +
                                "weight REAL NOT NULL, " +
                                "owner TEXT NOT NULL)";

                statement.execute(sqlStatement);


//INTERMEDIATE MANY TO MANY TABLE
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS pets_vaccines" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "pet_id INTEGER NOT NULL, " +
                                "vaccine_id INTEGER NOT NULL, " +
                                "vaccination_date TEXT NOT NULL)";

                statement.execute(sqlStatement);


//VACCINES
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS vaccines" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "name TEXT NOT NULL, " +
                                "vaccination_regularity INTEGER NOT NULL)";

                statement.execute(sqlStatement);


// CREATING A TABLE FOR FOOD
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS food" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "food_brand TEXT NOT NULL, " +
                                "food_weight_bag REAL NOT NULL, " +
                                "daily_amount INTEGER NOT NULL, " +
                                "date_bought TEXT NOT NULL, " +
                                "preferences TEXT, " +
                                "dislikes TEXT)";

                statement.execute(sqlStatement);


//INTERMEDIATE MANY TO MANY TABLE
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS pets_food" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "pet_id INTEGER NOT NULL, " +
                                "food_id INTEGER NOT NULL, " +
                                "daily_amount REAL NOT NULL)";

                statement.execute(sqlStatement);


// CREATING A TABLE FOR MEDICINE
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS medicine" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "name TEXT NOT NULL, " +
                                "regularity INTEGER NOT NULL)";

                statement.execute(sqlStatement);


//INTERMEDIATE MANY TO MANY TABLE
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS pets_medicine" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "pet_id INTEGER NOT NULL, " +
                                "medicine_id INTEGER NOT NULL)";

                statement.execute(sqlStatement);


// CREATING A TABLE FOR ALLERGIES
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS allergies" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "food TEXT, " +
                                "medicine TEXT, " +
                                "other TEXT)";

                statement.execute(sqlStatement);


//INTERMEDIATE MANY TO MANY TABLE
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS pets_allergies" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "pet_id INTEGER NOT NULL, " +
                                "allergies_id INTEGER NOT NULL)";

                statement.execute(sqlStatement);


            }

        } catch (SQLException exception) {
            System.out.println("Database issues" + exception);
        }


    }

//    method for seeing all Pets

    public ArrayList<Pets> seeAllPets() {

        ArrayList<Pets> allPets = new ArrayList<Pets>();

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
            }


        } catch (SQLException exception) {
            System.out.println("Error getting Pet list: " + exception);
        }



        return allPets;
    }


    public void createPet(Pets myPet) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO pets (" +
                    "name, animalType, animalBreed, dateOfBirth, gender, weight, owner) " +
                    "VALUES (" +
                    "'" + myPet.getName() + "'," +
                    "'" + myPet.getAnimalType() + "'," +
                    "'" + myPet.getAnimalBreed() + "'," +
                    "'" + myPet.getDateOfBirth() + "'," +
                    "'" + myPet.getGender() + "'," +
                    "'" + myPet.getWeight() + "'," +
                    myPet.getOwner() +
                    ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error creating a Pet : " + exception);
        }

//    public ArrayList<Pets> seeVaccinationSchedule() {
//
//        ArrayList<Pets> petsVaccinations = new ArrayList<Pets>();
//
//        try {
//            Statement statement = conn.createStatement();
//            String sqlStatement;
//
//            sqlStatement = "SELECT * FROM pets";
//            ResultSet resultSet = statement.executeQuery(sqlStatement);
//
//            sqlStatement =
//                    "SELECT pets.name AS pet_Name, vaccines.name AS vaccine_Title, pets_vaccines.vaccination_date AS next_Vaccination  " +
//                            " FROM pets  " +
//                            " LEFT JOIN pets_vaccines  " +
//                            " ON pets_vaccines.pet_id = pets.id " +
//                            " LEFT JOIN vaccines " +
//                            " ON pets_vaccines.vaccine_id = vaccines.id  " +
//                            " ORDER BY pets_vaccines.vaccination_date";
//
//            resultSet = statement.executeQuery(sqlStatement);
//
//            while (resultSet.next()) {
//                String petsName = resultSet.getString("pet_Name");
//                String vaccineTitle = resultSet.getString("vaccine_Title");
//                String nextVaccination = resultSet.getString("next_Vaccination");
//
//                System.out.println("");
//            }
//        } catch (SQLException exception) {
//
//            System.out.println("Error getting vaccination list " + exception);
//
//        }
//    }
    }

}


