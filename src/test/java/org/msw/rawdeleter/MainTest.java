package org.msw.rawdeleter;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Martin Swiech on 17.4.2016.
 */
public class MainTest {

    @Test
    public void testGetNameAndExtension() throws Exception {
        final String[] result1 = Main.getNameAndExtension("name.orig", ".ORIG");
        Assert.assertNotNull(result1);
        Assert.assertEquals("name", result1[0]);
        Assert.assertEquals(".orig", result1[1]);

        final String[] result2 = Main.getNameAndExtension("namee", ".ORIG");
        Assert.assertNull(result2);

        final String[] result3 = Main.getNameAndExtension("nameee", ".ORIG");
        Assert.assertNull(result3);
    }
}