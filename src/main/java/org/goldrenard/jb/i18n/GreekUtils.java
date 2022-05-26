package org.goldrenard.jb.i18n;

public class GreekUtils {

	
	 /**
     * Returns if a character is one of Greek characters.
     *
     * @param c the character to be tested
     * @return true if Greek, false otherwise
     */
    public static String removeAccents(final String str) {
    	if(str==null || str.isEmpty())
    		return str;
    	String ret="";			
    	for(int i=0; i<str.length(); i++) {
    		ret+=removeGreekAccent(str.charAt(i));
    	}	
        return ret;
    }
    
    
    
	
    /**
     * Returns if a character is one of Greek characters.
     *
     * @param c the character to be tested
     * @return true if Greek, false otherwise
     */
    public static boolean isCharGreek(final char c) {
        return (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.GREEK)
                || (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.GREEK_EXTENDED)
                 ;
    }
    
    /**
     * Returns if a character is one of upper case Greek characters.
     *
     * @param c the character to be tested
     * @return true if Upper Case Greek, false otherwise
     */
    public static boolean isUpperCaseCharGreek(final char c) {
    	if( (char) 902 <= c && c <= (char) 939 )
    		return true;
    	else
    		return false;
    }
    
    /**
     * Returns if a character is one of lower case Greek characters.
     *
     * @param c the character to be tested
     * @return true if Lower Case Greek, false otherwise
     */
    public static boolean isLowerCaseCharGreek(final char c) {
    	if( (char) 940 <= c && c <= (char) 974 )
    		return true;
    	else
    		return false;
    }
    
    /**
     * Removes the accent of a greek character and return the un-accented character.
     *
     * @param c the character to be tested
     * @return true if CJK, false otherwise
     */
    public static char removeGreekAccent(final char c) {
    	switch( c ) {
    		case (char)902: // Ά to Α
    			return (char)913;
    		case (char)904: // Έ to Ε
    			return (char)917;
    		case (char)905: // Ή to Η
    			return (char)919;
    		case (char)906: // Ί to Ι
    			return (char)921;
    		case (char)938: // Ϊ to Ι
    			return (char)921;
    		case (char)908: // Ό to Ο
    			return (char)927;
    		case (char)910: // Ύ to Υ
    			return (char)933;
    		case (char)939: // Ϋ to Υ
    			return (char)933;
    		case (char)911: // Ώ to Ω
    			return (char)937;
    		case (char)912: // ΐ to ι
    			return (char)953;
    		case (char)943: // ί to ι
    			return (char)953;
    		case (char)970: // ϊ to ι
    			return (char)953;
    		case (char)940: // ά to α
    			return (char)945;
    		case (char)941: // έ to ε
    			return (char)949;
    		case (char)942: // ή to η
    			return (char)951;
    		case (char)972: // ό to ο
    			return (char)959;
    		case (char)944: // ΰ to υ
    			return (char)965;
    		case (char)971: // ϋ to υ
    			return (char)965;
    		case (char)973: // ύ to υ
    			return (char)965;
    		case (char)974: // ώ to ω
    			return (char)969;
    		default:
    			return c;
    	}
    }
    
    /**
     * Removes the accent of a greek character and return the un-accented character.
     *
     * @param c the character to be tested
     * @return true if CJK, false otherwise
     */
    public static boolean isAccentedGreek(final char c) {
    	switch( c ) {
    		case (char)902: // Ά 
    		case (char)904: // Έ 
    		case (char)905: // Ή 	
    		case (char)906: // Ί 
    		case (char)938: // Ϊ 
    		case (char)908: // Ό 
    		case (char)910: // Ύ 
    		case (char)939: // Ϋ 
    		case (char)911: // Ώ 
    		case (char)912: // ΐ 
    		case (char)943: // ί 
    		case (char)970: // ϊ 
    		case (char)940: // ά 
    		case (char)941: // έ 
    		case (char)942: // ή 
    		case (char)972: // ό 
    		case (char)944: // ΰ 
    		case (char)971: // ϋ 
    		case (char)973: // ύ 
    		case (char)974: // ώ 
    			return true;
    		default:
    			return false;
    	}
    }
    
    /**
     * Returns if the upper case accented character if one of Greek characters.
     *
     * @param c the greek lower case accented character
     * @return the corresponding upper case greek character if a lower case char else the char itself unchanged
     */
    public static char toUpperCaseGreek(final char c) {
    	switch ( c ) {
    		case (char)940: // ά to Ά
    			return (char)902;
    		case (char)941: // έ to Έ 
    			return (char)904;
    		case (char)942: // ή to Ή
    			return (char)905;
    		case (char)943: // ί to Ί
    			return (char)906;
    		case (char)970: // ϊ to Ϊ
    			return (char)938;
    		case (char)972: // ό to Ό
    			return (char)908;
    		case (char)973: // ύ to Ύ
    			return (char)910;
    		case (char)971: // ϋ to Ϋ
    			return (char)939;
    		case (char)974: // ώ to Ώ
    			return (char)911;
    		default:
    			if( (char) 945 <= c && c <= (char) 969 )
    				return (char)((int) c - 32);
    			return c;
    	}
    }
    
    /**
     * Returns the lower case accented character if one of Greek characters.
     *
     * @param c the greek upper case accented character
     * @return the corresponding lower case greek character if an upper case char else the char itself unchanged
     */
    public static char toLowerCaseGreek(final char c) {
    	switch ( c ) {
    		case (char)902: // Ά to ά
    			return (char)940;
    		case (char)904: // Έ to έ  
    			return (char)941;
    		case (char)905: // Ή to ή 
    			return (char)942;
    		case (char)906: // Ί to ί
    			return (char)943;
    		case (char)938: // Ϊ to ϊ 
    			return (char)970;
    		case (char)908: // Ό to ό
    			return (char)972;
    		case (char)910: // Ύ to ύ
    			return (char)973;
    		case (char)939: // Ϋ to ϋ
    			return (char)971;
    		case (char)911: // Ώ to ώ
    			return (char)974;
    		default:
    			if( (char) 913 <= c && c <= (char) 937 )
    				return (char)((int) c + 32);
    			return c;
    	}
    }
}
