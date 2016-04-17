package org.msw.rawdeleter;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Martin Swiech on 17.4.2016.
 */
public class MainTest {

    @Test
    public void testGetNameAndExtension() throws Exception {
        final String[] result1 = Main.getNameAndExtensionForOrig("name.orig", ".ORIG");
        Assert.assertNotNull(result1);
        Assert.assertEquals("name", result1[0]);
        Assert.assertEquals(".orig", result1[1]);

        final String[] result2 = Main.getNameAndExtensionForOrig("namee", ".ORIG");
        Assert.assertNull(result2);

        final String[] result3 = Main.getNameAndExtensionForOrig("nameee", ".ORIG");
        Assert.assertNull(result3);
    }
}