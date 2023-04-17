package data;

import java.util.Random;

public class DataHelper {
    private DataHelper() {
    }

    public static class AuthInfo {
        private String login;
        private String password;


        public AuthInfo(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }
    public static class VerificationKod {
        private String kod;

        public VerificationKod(String kod) {
            this.kod = kod;
        }

        public String getKod() {
            return kod;
        }
    }

    public static VerificationKod getVerificationKod() {
        return new VerificationKod(DbInteraction.getVerificationKod());
    }

    public static class CardInfo {
        private String cardNumber;
        private String testId;

        public String getCardNumber() {
            return cardNumber;
        }

        public String getTestId() {
            return testId;
        }

        public CardInfo(String cardNumber, String testId) {
            this.cardNumber = cardNumber;
            this.testId = testId;
        }
    }

    public static CardInfo getFirstCard() {
        return new CardInfo("5559 0000 0000 0001", "92df3f1c-a033-48e6-8390-206f6b1f56c0");
    }

    public static CardInfo getSecondCard() {
        return new CardInfo("5559 0000 0000 0002", "0f3f5c2a-249e-4c3d-8287-09f7a039391d");
    }

    public static int generateValidAmount(int balance) {
        return new Random().nextInt(balance) + 1;
    }

    public static int generateInvalidAmount(int balance) {
        return Math.abs(balance) + new Random().nextInt(10000);
    }
}
