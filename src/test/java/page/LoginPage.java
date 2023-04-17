package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    private static SelenideElement loginField = $("span[data-test-id=login] input");
    private static SelenideElement passwordField = $("span[data-test-id=password] input");
    private static SelenideElement loginButton = $("[data-test-id=action-login]");

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(DataHelper.getAuthInfo().getLogin());
        passwordField.setValue(DataHelper.getAuthInfo().getPassword());
        loginButton.click();
        return page(VerificationPage.class);
    }

}
