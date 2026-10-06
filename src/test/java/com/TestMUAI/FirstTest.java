package com.TestMUAI;

import testng.annotations.Test;
import testng.asserts.Assert;

public class FirstTest {
    @BeforeClass
    public void beforeClass() {
        
    }
    @Test
    public void shouldAnswerWithTrue() {
        Assert.assertTrue(true);
    }
}
