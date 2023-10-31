import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    @DisplayName("Checking the creation of an object with two parameters")
    public void testUserConstructor() {
        final String LOGIN = "login";
        final String EMAIL = "email";

        User user = new User(LOGIN, EMAIL);

        String userLogin = user.getLogin();
        String userEmail = user.getEmail();

        assertEquals(LOGIN, userLogin);
        assertEquals(EMAIL, userEmail);
    }

    @Test
    @DisplayName("Checking the creation of an object without parameters")
    public void testUser() {
        final String LOGIN = null;
        final String EMAIL = null;

        User user = new User();

        String userLogin = user.getLogin();
        String userEmail = user.getEmail();

        assertEquals(LOGIN, userLogin);
        assertEquals(EMAIL, userEmail);
    }
    @Nested
    @DisplayName("Checks values")
    class checksValues{
        @Test
        @DisplayName("Check Email")
        public void testGetEMail() {
            boolean flag = false;
            final String LOGIN = "login";
            final String EMAIL = "mail.ru";

            User user = new User(LOGIN, EMAIL);

            String userEmail = user.getEmail();
            if ((userEmail.contains("@")) || (userEmail.contains("."))) {
                flag = true;
            }
            assertEquals(true, flag, "Email adress is not corrected");
        }
        @Test
        @DisplayName("Check login")
        public void testGetLogin(){
            boolean flag = false;
            final String LOGIN = "logins";
            final String EMAIL = "mail.ru";

            User user = new User(LOGIN, EMAIL);

            String userLogin = user.getLogin();
            if (userLogin.length() > 5){
                flag = true;
            }
            assertEquals(true, flag, "Login is not corrected");
        }
    }
}

