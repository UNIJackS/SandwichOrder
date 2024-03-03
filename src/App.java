import java.util.Scanner;  // Import the Scanner class
import java.util.Vector;

public class App {
    //-----------------------------------Main loop-----------------------------------
    public static void main(String[] args) throws Exception {

        //--------------------------Changeable Varables--------------------------------
        float[][] optionPrices = {{1,0.8f,1.2f,1.4f},
                            {2.69f,3.0f,4.0f,3.3f},
                            {1.69f,1.0f,2.0f,2.5f}};

        String[][] optionNames = {{"Bread","Wholemeal","White","Cheesy White","Gluten Free"},
                            {"Meat","Chicken","beef","salami","vegan slice"},
                            {"Garnish","Onion","tomato","lettuce","Cheese"}};

        
        
        //--------------------------Global varables & objects--------------------------
        boolean ordering = false;
        int orderNum = 0;

        Scanner userInput = new Scanner(System.in);
        Vector<order> orderList = new Vector<order>();

        while(ordering == false){
            orderList.add(new order(orderNum,optionNames.length));

            orderList.get(orderNum).name(userInput);
            
            boolean orderNotCorrect = true; 
            while(orderNotCorrect){
                orderList.get(orderNum).selection(optionPrices,optionNames,userInput);

                orderNotCorrect = orderList.get(orderNum).orderCheck(optionPrices,optionNames,userInput);
            }
            orderNum +=1;
            
            System.out.println("would you like to place another order ?");
            ordering = basic.intergerConfirm(userInput);
        }
        userInput.close();


        for(int orders = 0; orders < orderList.size(); orders+=1){
            Vector<String> temp = orderList.get(orders).dump();

            for(int items = 0; items < temp.size(); items+=1){
                System.out.println(temp.get(items));
            }

        }

    }
}