package com.TestMUAI;

import testng.annotations.Test;
import testng.asserts.Assert;

public class BaseClassTest {
    @BeforeClass
    public void beforeClass() {
        
    }
    @Test
    public void shouldAnswerWithTrue() {
        Assert.assertTrue(true);
    }
}
