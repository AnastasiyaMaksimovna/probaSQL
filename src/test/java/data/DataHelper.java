package data;


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


}
