import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CRUD{
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/oldersperabot";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    Connection connection;

    public void runData(){
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            // Establish a connection to the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void stopData(){
        try{
            connection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void createData(String barang, int jumlah, String tanggal) {
        String query = "INSERT INTO history (Barang, Jumlah, Tanggal) Values(?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,barang);
            preparedStatement.setInt(2,jumlah);
            preparedStatement.setString(3, tanggal);

            preparedStatement.executeUpdate();

            System.out.println("Succesfully");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void removeAllData() {
        String query = "DELETE FROM history";
    
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            int rowsAffected = preparedStatement.executeUpdate();
    
            if (rowsAffected > 0) {
                System.out.println("Successfully removed all data from the history table.");
            } else {
                System.out.println("No data found in the history table.");
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateData(String newBarang, int newJumlah, String newTanggal, String barang, int jumlah, String tanggal) {
        String query = "UPDATE history SET Barang = ?, Jumlah = ?, Tanggal = ? WHERE Barang = ? AND Jumlah = ? AND Tanggal = ?";
    
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, barang);
            preparedStatement.setInt(2, jumlah);
            preparedStatement.setString(3, tanggal);
            preparedStatement.setString(4, newBarang);
            preparedStatement.setInt(5, newJumlah);
            preparedStatement.setString(6, newTanggal);
    
            int rowsAffected = preparedStatement.executeUpdate();
    
            if (rowsAffected > 0) {
                System.out.println("Successfully updated data with Barang: ");
            } else {
                System.out.println("No data found with Barang: " );
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        String query = "SELECT * FROM history";
    
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()) {
    
            while (resultSet.next()) {
                String retrievedBarang = resultSet.getString("Barang");
                int retrievedJumlah = resultSet.getInt("Jumlah");
                String retrievedTanggal = resultSet.getString("Tanggal");
    
                System.out.println(" Barang: " + retrievedBarang
                        + ", Jumlah: " + retrievedJumlah + ", Tanggal: " + retrievedTanggal);
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}