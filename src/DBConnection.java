import java.sql.*;

public class DBConnection {

    private Connection conn;

    public DBConnection() {

        try {
            String dbUrl = "jdbc:sqlite:petKeep.db";
            conn = DriverManager.getConnection(dbUrl);

            if( conn != null) {
                DatabaseMetaData databaseMetadata = conn.getMetaData();
                System.out.println("Connected to " + databaseMetadata.getDatabaseProductName() + " " + databaseMetadata.getDatabaseProductVersion());


                // CREATING A TABLE FOR PETS
                Statement statement = conn.createStatement();
                String sqlStatement =
                        "CREATE TABLE IF NOT EXISTS pets" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "name TEXT NOT NULL, " +
                                "animal_type TEXT NOT NULL, " +
                                "date_of_birth DATE NOT NULL, " +
                                "gender TEXT NOT NULL, " +
                                "owner TEXT NOT NULL)";

                statement.execute(sqlStatement);

                //INTERMEDIATE MANY TO MANY TABLE
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS pets_vaccines" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "pet_id INTEGER NOT NULL, " +
                                "vaccine_id INTEGER NOT NULL, " +
                                "vaccination_date DATE NOT NULL)";


                statement.execute(sqlStatement);

                //VACCINES
                sqlStatement =
                        "CREATE TABLE IF NOT EXISTS vaccines" +
                                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "name TEXT NOT NULL, " +
                                "vaccination_regularity INTEGER NOT NULL)";


                statement.execute(sqlStatement);


            }

        } catch (SQLException exception) {
            System.out.println("Database issues" + exception);
        }








    }




}
