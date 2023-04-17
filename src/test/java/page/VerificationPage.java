package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private static SelenideElement codeField = $("span[data-test-id=code] input");
    private static SelenideElement verifyButton = $("[data-test-id=action-verify]");

    public VerificationPage() {
        codeField.shouldBe(visible);
    }

    public DashboardPage validVerify(DataHelper.VerificationKod verificationKod) {
        codeField.setValue(verificationKod.getKod());
        verifyButton.click();
        return new DashboardPage();
    }
}
