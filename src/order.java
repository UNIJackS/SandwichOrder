import java.util.Scanner;  // Import the Scanner class
import java.util.Vector;

public class order {
    

    private int id;
    private String name;

    public int[] selectedOptions;

    // Inialises the order object with defalt values
    public order(int id_input,int numOfOptions){
        id = id_input;
        selectedOptions = new int[numOfOptions];
    }

    // Prints the important info to the terminal
    public Vector<String> dump(){
        //System.out.println(id+name);
        //for(int i = 0; i < selectedOptions.length; i+=1){
        //    System.out.print(selectedOptions[i]);
        //}
        Vector<String> tempVector = new Vector<String>();

        tempVector.add(Integer.toString(id));
        tempVector.add(name);
        
        for(int options = 0; options < selectedOptions.length; options+=1){
            tempVector.add(Integer.toString(selectedOptions[options]));
        }
        
        return(tempVector);
    }

    // asks the user to enter a name for their order
    public void name(Scanner localUserInput){
        boolean inValidInput = true;
        while(inValidInput){
            System.out.println("Please eneter a name for the order");
            name = localUserInput.nextLine();
            String noSpaceName = name.replaceAll("\\s", "");
            switch (noSpaceName.toLowerCase()) {
                case "":
                    
                    break;
            
                default:
                    inValidInput = false;
                    break;
            }
        }
        
    }

    //
    public void selection(float[][] prices,String[][] names,Scanner localUserInput){
        boolean selecting = true;
        while(selecting){
            for(int option_type = 0; option_type < names.length; option_type +=1){
                boolean valid_input = false;
                while(valid_input == false){
                    System.out.println("please select a "+names[option_type][0]+" Your options are :");
                    for(int option_num = 1; option_num < names[option_type].length; option_num +=1){
                        System.out.print(" "+option_num + ")"+ names[option_type][option_num]);
                        
                        // This statment makes sure that there is "|" symbol to the right of the last option
                        if(option_num != names[option_type].length){
                            System.out.print(" |");
                        }
                    }
                        
                        
                    System.out.println("\n(Please enter the number to the left of the "+names[option_type][0]+")");
                    selectedOptions[option_type] = basic.intergerInput(localUserInput);

                    if(selectedOptions[option_type] != 0 && selectedOptions[option_type] < names[option_type].length){
                        valid_input = true; 
                    }
                    
                }
                
            }
            selecting = false;
        }

    }

    public boolean orderCheck(float[][] prices,String[][] names,Scanner localUserInput){
        while(true){
            System.out.println("The name for the order is :"+name);
            System.out.println("You selected "+names[0][selectedOptions[0]]+ " " +names[0][0] +" with " + names[1][selectedOptions[1]] + " and " + names[2][selectedOptions[2]]);
            System.out.println("Is this correct ?");
            return(basic.intergerConfirm(localUserInput));
        }
    }
}