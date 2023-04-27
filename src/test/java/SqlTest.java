import data.DataHelper;
import data.DbInteraction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class SqlTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeEach
    void setup() {
        loginPage = open("http://localhost:9999", LoginPage.class);
    }

    @Test
    public void testUser() {
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationKod = DataHelper.getVerificationKod();
        dashboardPage = verificationPage.validVerify(verificationKod);

    }

    @AfterAll
    public static void clean() {
        DbInteraction.deleteUsers();
    }
}
