package test.com.andrew;


import com.andrew.entity.Message;
import com.andrew.validator.Validator;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Testing {

    private static final Logger LOG = Logger.getLogger(Testing.class);

    @Ignore
    @Test
    public void testMethod() {
        fail("It's a test fail! Don't worry!");
    }

    @Test
    public void testValidator() {
        assertTrue(Validator.validateRegistrationData("Andrew_1", "AAaa11", "AAaa11", "Andrei", "Novitskiy",
                "298501316", "starwars@tut.by"));
    }

    @Test
    public void testBuilder() {
        int testId = 2;
        Message testMessage = new Message.MessageBuilder().messageId(testId).build();
        assertEquals(testMessage.getMessageId(), testId);
    }

}


