package com.tw.util;

import org.junit.Assert;
import org.junit.Test;

public class NumberUtilsTest {

    @Test
    public void removeTrailZeros() {

        Assert.assertEquals("23", NumberUtils.removeTrailZeros(23.0D));
        Assert.assertEquals("23.01", NumberUtils.removeTrailZeros(23.01D));
        Assert.assertEquals("23.1", NumberUtils.removeTrailZeros(23.10D));
    }
}
