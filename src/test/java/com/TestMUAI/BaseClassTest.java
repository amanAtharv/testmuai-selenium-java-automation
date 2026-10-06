package com.TestMUAI;

import org.testng.Assert;
import org.testng.annotations.*;

public class BaseClassTest {
    @BeforeClass
    public void beforeClass() {
        
    }
    @Test
    public void shouldAnswerWithTrue() {
        Assert.assertTrue(true);
    }
}
