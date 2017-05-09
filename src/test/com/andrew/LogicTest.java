package test.com.andrew;

import com.andrew.entity.Message;
import com.andrew.entity.User;
import com.andrew.util.MessagePreparator;
import com.andrew.validator.Validator;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class LogicTest {

    private User user;

    @Before
    public void initialize() {
        user = new User.UserBuilder().login("Test_21").password("AAaa11").name("Mock").surname("Mock")
                .telephone("375291234567").email("test@mock.by").build();
    }

    @Ignore
    @Test
    public void testMethod() {
        fail("It's a test fail! Don't worry!");
    }

    @Test
    public void testValidator() {
        assertTrue(Validator.validateRegistrationData(user.getLogin(), user.getPassword(), "AAaa11", user.getName(),
                user.getSurname(), user.getTelephone(), user.getEmail()));
    }

    @Test
    public void testMessageBuilder() {
        int testId = 2;
        Message testMessage = new Message.MessageBuilder().messageId(testId).build();
        assertEquals(testMessage.getMessageId(), testId);
    }

    @Test
    public void testMessagePreparator() {
        String testMessage = "Hello, Mock.\nYour applicant status for the vacancy Team Lead has been changed on 'Recruited'.";
        assertEquals(MessagePreparator.prepareStatusChangedMessage(user.getName(), "Team Lead", "Recruited"),
                testMessage);
    }

}


