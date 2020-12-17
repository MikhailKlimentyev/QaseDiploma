package factories;

import lombok.extern.log4j.Log4j2;
import models.User;

import static models.Constants.QASE_EMAIL_PROPERTY;
import static models.Constants.QASE_PASSWORD_PROPERTY;
import static utils.PropertyReader.getProperty;

@Log4j2
public class UserFactory {

    public static User getValidUser() {
        return getUser(getProperty(QASE_EMAIL_PROPERTY, QASE_EMAIL_PROPERTY),
                getProperty(QASE_PASSWORD_PROPERTY, QASE_PASSWORD_PROPERTY));
    }

    public static User getUser(String email, String password) {
        User user = User.builder()
                .email(email)
                .password(password)
                .build();
        log.debug(String.format("Getting user %s", user.toString()));
        return user;
    }
}
