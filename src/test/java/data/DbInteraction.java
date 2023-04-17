package data;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbInteraction {

    public static String getVerificationKod() {
        String countSQL = "select ac.code from auth_codes ac order by created desc limit 1";
        QueryRunner runner = new QueryRunner();
        String verificationKod;
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");

        ) {
            verificationKod = runner.query(conn, countSQL, new ScalarHandler<>());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return verificationKod;
    }
}
