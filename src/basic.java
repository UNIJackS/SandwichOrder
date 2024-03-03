import java.util.Scanner;

public class basic {
    
    /*This function checks if a string is an interger
     * 
     * @param str_number_to_check  the string number to checked
     * @return                     true or false if the string is an int
    */
    static int intergerInput(Scanner localUserInput){
        while(true){
            try{
                int input = Integer.valueOf(localUserInput.nextLine());
                
                return input;
            }
            catch(NumberFormatException nfe){
                System.out.println("Please enter a whole number:");
            }
        }
    }

    /*This function checks if a string is equal to another string 
     * <p>
     * The function strips spaces and capitals from the str_to_check
     * So the str_to_check_aganst must be all lower case and have no spaces
     * 
     * @param str_to_check_aganst  the string to be checked aganst
     * @param str_to_check         the string to be checked
     * @return                     true or false if the strings match
    */
    static boolean strChecker(String refranceString, String stringToCheck){
        //Removes all spaces from the string
        String noSpacesStringToCheck = stringToCheck.replaceAll("\\s", "");
        
        if(refranceString == noSpacesStringToCheck.toLowerCase()){
            return true;
        }else{
            return false;
        }
    }

    static boolean intergerConfirm(Scanner localUserInput){
        System.out.println("0)Yes | 1)No");
        
        while(true){
            int input = intergerInput(localUserInput);
            if( input == 0){
                return false;
            }else if(input == 1){
                return true;
            }else{
                System.out.println("please enter only 0 or 1");
            }
        }
    }
}