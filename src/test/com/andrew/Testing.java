package test.com.andrew;


import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.fail;

public class Testing {
    private static final Logger log = Logger.getLogger(Testing.class);


    @Ignore
    @Test
    public void testMethod() {
        log.info("info");
        fail("It's a test fail! Don't worry!");
    }




}
