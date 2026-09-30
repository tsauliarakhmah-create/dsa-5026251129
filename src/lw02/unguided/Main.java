
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> foods = new LinkedList<>();
        LinkedList<String[]> drinks = new LinkedList<>();
        LinkedList<String[]> successfullyOrder = new LinkedList<>();

        foods.add(new String[]{"Bakso", "5"});
        foods.add(new String[]{"Sate", "1"});
        foods.add(new String[]{"Soto", "2"});

        drinks.add(new String[]{"Es Teh", "4"});
        drinks.add(new String[]{"Es Jeruk", "2"});

        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        Scanner sc = new Scanner (Main.class.getResourceAsStream("orders.txt"));

        while (sc.hasNextLine()){
            String[] order = new String[4];
            order[0] = sc.next();
            order[1] = sc.next();
            order[2] = sc.next();
            order[3] = sc.next();
            orders.add(order);
        }

        sc.close();

        queue.addAll(orders);

        while (!queue.isEmpty()){

            String[] order = queue.poll();

            String name  = order[0];
            String food = order[1];
            String drink = order[2];
            int tableNumber = Integer.parseInt(order[3]);

            String[] stockFood = null;

            for (String[] data : foods){
                if (data [0].equals(food)){
                    stockFood = data;
                    break;
                }
            }

            if (stockFood == null){
                stockFood = new String[]{food, "0"};
            }

            String[] stockDrink = null;

            for (String[] data : drinks){
                if (data [0].equals(drink)){
                    stockDrink = data;
                    break;
                }
            }

            if (stockDrink == null){
                stockDrink = new String[]{drink, "0"};
            }

           System.out.println("=== Successfully Processed Orders === \r\n")
           System.out.println(=== Remaining Food Stock === );
           system.out.println(=== Remaining Drink Stock ===);
           system.out.println(=== Failed Orders ===);
); 
           

        }
    }
}
