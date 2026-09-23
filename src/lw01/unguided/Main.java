import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
     public static void main(String[]args) {
       try (Scanner scanner = new Scanner (new File ("washes.txt"))) {
        int total = scanner.nextInt();
        WashService [] service = new WashService [total];
        for (int i = 0; i < total; i++){
            String label = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();

            if(label.equals("MOTORCYCLE")){
                service[i] = new MotorcycleWash(id, days);
            }else if (label.equals("CAR")){
                service[i] = new CarWash(id, days);
            }
        }

        }catch (FileNotFoundException e){
            System.out.println("File washes.txt not found" + e.getLocalizedMessage());
            return;
        }
        
        for (WashService washes : service){
            System.out.println(washes.summary());
        }
    
    }
}

