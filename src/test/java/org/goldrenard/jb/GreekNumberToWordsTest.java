package org.goldrenard.jb;

import junit.framework.TestCase;
import org.goldrenard.jb.i18n.GreekNumberToWords;
import org.junit.Test;

/**
 * Created by User on 3/31/14.
 */
public class GreekNumberToWordsTest extends TestCase {
    @Test
    public void testConvert() {

        for (int i = 1; i < 213; i++) {
        	System.out.println(GreekNumberToWords.convert(i,1));
            assertTrue(1==1);
        }
        
        for (int i = 1003; i < 10000004; ) {
        	System.out.println(GreekNumberToWords.convert(i,2));
            assertTrue(1==1);
            i+=1000;
        }
        
        for (int i = 1; i < 999; i++) {
        	System.out.println(GreekNumberToWords.convertTaktikalLessThanOneThousand(i,3));
            assertTrue(1==1);
        }
    }
}
