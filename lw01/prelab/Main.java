import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) {
        List<PrintJob> printJobs = new ArrayList<>();

        try (Scanner sc = new Scanner (new File ("jobs.txt"))){
            while (sc.hasNext()) {
                String type = sc.next();
                String id = sc.next();
                int pages = sc.nextInt();

                if(type.equals("MONO")){
                    printJobs.add(new MonoPrint(id, pages));
                }else if (type.equals("COLOUR")){
                    printJobs.add(new ColourPrint(id, pages));
                }
            }

        }catch (FileNotFoundException e){
            System.out.println("File jobs.txt not found");
            return;
        }
        
        for (PrintJob job : printJobs){
            System.out.println(job.summary());
        }
    }
}