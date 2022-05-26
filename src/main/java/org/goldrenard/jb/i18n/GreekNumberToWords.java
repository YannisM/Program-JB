/*
 * This file is part of Program JB.
 *
 * Program JB is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * Program JB is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Program JB. If not, see <http://www.gnu.org/licenses/>.
 */
package org.goldrenard.jb.i18n;

import java.text.DecimalFormat;

/**
 * This Program will display the given number in greek words from 0 to 999999999
 **/
public class GreekNumberToWords {
	
	static int gender=3; // neutrum
	
	   private static int genderInt(String gender) {
	    	int g=3;
	    	if(gender!=null && !gender.isEmpty()) {
	    		if(gender.compareToIgnoreCase("masculine")==0)
	        		g=1;
	        	else if(gender.compareToIgnoreCase("feminine")==0)
	        		g=2;	
	    	}
	    	return g;
	    }

    private static final String[] arxikoi = {
            "",
            " ένα",
            " δύο",
            " τρία",
            " τέσσερα",
            " πέντε",
            " έξι",
            " επτά",  // "εφτά"
            " οκτώ",  // "οχτώ"
            " εννέα", // "ενvιά"
            " δέκα",
            " έντεκα",
            " δώδεκα",
    };
    
    private static final String[] arxikoiTakt = {
            "",
            " πρώτο",
            " δεύτερο",
            " τρίτο",
            " τέταρτο",
            " πέμπτο",
            " έκτο",
            " έβδομο", 
            " όγδοο",  
            " ένατο", 
            " δέκατο",
            " έντεκατο",
            " δώδεκατο",
    };

    private static final String[] dekades = {
            "",
            " δέκα",
            " είκοσι",
            " τριάντα",
            " σαράντα",
            " πενήντα",
            " εξήντα",
            " εβδομήντα",
            " ογδόντα",
            " ενενήντα"
    };
    
    private static final String[] dekadesTakt = {
            "",
            " δέκατο",
            " εικοστό",
            " τριακοστό",
            " τεσσαρακοστό",
            " πεντηκοστό",
            " εξηκοστό",
            " εβδομηκοστό",
            " ογδοηκοστό",
            " ενενηκοστό"
    };

    private static final String[] ekatontades = {
            "",
            " εκατό",
            " διακόσια",
            " τριακόσια", // " τρακόσια",
            " τετρακόσια",
            " πεντακόσια",
            " εξακόσια",
            " επτακόσια", // " εφτακόσια"
            " οκτακόσια", // " οχτακόσια"
            " εννιακόσια",
            " χίλια"
    };
    
    private static final String[] ekatontadesTakt = {
            "",
            " εκατoστό",
            " διακοσιοστό",
            " τριακοσιοστό", 
            " τετρακοσιοστό",
            " πεντακοσιοστό",
            " εξακοσιοστό",
            " επτακοσιοστό", // " εφτακόσια"
            " οκτακοσιοστό", // " οχτακόσια"
            " εννιακοσιοστό",
            " χίλιοστό"
    };

    private GreekNumberToWords() {
    }

    
    private static String arxikoi(int i) {
    	return arxikoi[i];
    };
    
    private static String arxikoi(int i, String gender) {
    	return arxikoi( i, genderInt(gender));
    }
    
    private static String genderizeTaktikal(String taktikal, int gender) {
    	String ret=taktikal;
    	if( taktikal==null ||taktikal.isEmpty())
    		return ret;
    	if(gender==1)
    		ret=taktikal+"ς";
    	else if(gender==2) {
    		if(GreekUtils.isAccentedGreek(taktikal.charAt(taktikal.length()-1)))
    			ret=ret.substring(0,ret.length()-1)+"ή";
    		else
    			ret=ret.substring(0,ret.length()-1)+"η";
    	}
		return ret;
    }
    
    private static String arxikoi(int i, int gender) {
    	String ret=arxikoi[i];
    	if(i==1) {
    		if(gender==1) ret=" ένας";
    		else if(gender==2) ret=" μία";
    	}
    	else if(i==3) {
    		if(gender<3)
    			ret=" τρείς";
    	}
    	else if(i==4) {
    		if(gender<3)
    			ret=" τέσσερις";
    	}
		return ret;
    }
    
    private static String ekatontades(int i) {
    	return ekatontades[i];
    };
    
    private static String ekatontades(int i, String gender) {
    	return ekatontades( i, genderInt(gender));
    }
    
    private static String ekatontades(int i, int gender) {
    	String ret=ekatontades[i];
    	if(i<1)
    		return ret;
    	if(gender==1)
    		ret=ret.substring(0,ret.length()-1)+"οι";
    	else if(gender==2)
    		ret=ret.substring(0,ret.length()-1)+"ες";
		return ret;
    }
    
    private static String convertTaktikalLessThanOneThousand(int number) {
    	return convertTaktikalLessThanOneThousand(number, gender);
    }
    
    public static String convertTaktikalLessThanOneThousand(int number, int gender) {
        String soFar;

        if (number % 100 < 13) {
            soFar = genderizeTaktikal(arxikoiTakt[number % 100], gender);
            number /= 100;
        } 
        else {
            soFar = genderizeTaktikal(arxikoiTakt[number % 10], gender);
            number /= 10;
           
           	soFar = genderizeTaktikal(dekadesTakt[number % 10], gender) + soFar;
            number /= 10;
        }
        if (number == 0) {
            return soFar;
        }	
        return genderizeTaktikal(ekatontadesTakt[number % 10], gender) + soFar ;
    }
    
    private static String convertLessThanOneThousand(int number) {
    	return convertLessThanOneThousand(number, gender);
    }
    
    private static String convertLessThanOneThousand(int number, int gender) {
        String soFar;

        if (number % 100 < 13) {
            soFar = arxikoi(number % 100, gender);
            soFar= number % 100 == 3 ? GreekUtils.removeAccents(soFar):soFar;
            number /= 100;
        } 
        else {
            soFar = arxikoi(number % 10, gender);
            number /= 10;
            if(soFar.isEmpty())
            	soFar = dekades[number % 10];
            else
            	soFar = GreekUtils.removeAccents(dekades[number % 10]) + soFar.trim();
            number /= 10;
        }
        if (number == 0) {
            return soFar;
        }else if (number == 1) {
        	if(soFar==null || soFar.isEmpty() )
        		 return  ekatontades(number,3);
        	return  ekatontades(number,3) +"ν " + soFar;
        }	
        return ekatontades(number,gender) + " " +soFar;
    }
    
    public static String convert(long number) {
    	return convert(number, gender);
    }
    
    public static String convert(long number, String gender) {
    	return convert(number, genderInt(gender));
    }

    public static String convert(long number, int gender) {
        // 0 to 999 999 999 999
        if (number == 0) {
            return "μηδέν";
        }

        String snumber;

        // pad with "0"
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        // XXXnnnnnnnnn
        int billions = Integer.parseInt(snumber.substring(0, 3));
        // nnnXXXnnnnnn
        int millions = Integer.parseInt(snumber.substring(3, 6));
        // nnnnnnXXXnnn
        int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
        // nnnnnnnnnXXX
        int thousands = Integer.parseInt(snumber.substring(9, 12));

        String tradBillions;
        switch (billions) {
            case 0:
                tradBillions = "";
                break;
            case 1:
                tradBillions = convertLessThanOneThousand(billions, 3)
                        + " δισεκατομμύριο ";
                break;
            default:
                tradBillions = convertLessThanOneThousand(billions, 3)
                        + " δισεκατομμύρια ";
        }
        String result = tradBillions;

        String tradMillions;
        switch (millions) {
            case 0:
                tradMillions = "";
                break;
            case 1:
                tradMillions = convertLessThanOneThousand(millions, 3)
                        + " εκατομμύριο ";
                break;
            default:
                tradMillions = convertLessThanOneThousand(millions, 3)
                        + " εκατομμύρια ";
        }
        result = result + tradMillions;

        String tradHundredThousands;
        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1:
                tradHundredThousands =" "+ekatontades(10, gender)+" ";
                break;
            default:
                tradHundredThousands = convertLessThanOneThousand(hundredThousands, 2)
                        + " χιλιάδες ";
        }
        result = result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands, gender);
        result = result + tradThousand;

        // remove extra spaces!
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }
}
