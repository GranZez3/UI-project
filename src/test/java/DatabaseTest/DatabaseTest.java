package DatabaseTest;

import Database.DatabaseConnection;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseTest {

    @Test
    public void userExistsTest() throws Exception{
        Connection connection = DatabaseConnection.getConnection();

        String sql = "SELECT * FROM users WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, 1);

        ResultSet rs = statement.executeQuery();

        Assert.assertTrue(rs.next());

        connection.close();
    }
}
