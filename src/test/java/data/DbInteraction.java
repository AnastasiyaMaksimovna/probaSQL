package data;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.apache.commons.dbutils.DbUtils.*;

public class DbInteraction {
    private static QueryRunner runner = new QueryRunner();

    public static String getVerificationKod() {
        String countSQL = "select ac.code from auth_codes ac order by created desc limit 1";
        String verificationKod;

        try (var conn = getConn()) {
            verificationKod = runner.query(conn, countSQL, new ScalarHandler<>());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return verificationKod;
    }

    public static void deleteUsers() {
        String deleteSQL = "delete from app.card_transactions; delete from app.cards; delete from app.users; delete from app.auth_codes;";


        try (var conn = getConn()) {
            runner.execute(conn, "delete from app.auth_codes");
            runner.execute(conn, "delete from app.card_transactions");
            runner.execute(conn, "delete from app.cards");
            runner.execute(conn, "delete from app.users");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }
}
