import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Set<String> registered = new LinkedHashSet<>();
        Set<String> chekins = new LinkedHashSet<>();

        int rejected = 0;

        Scanner sc1 = new Scanner(Main.class.getResourceAsStream("registration.txt"));
        while (sc1.hasNextLine()){
            registered.add(sc1.next());
        }
        System.out.println("===== Event Check-In Results =====");

        Scanner sc2 = new Scanner (Main.class.getResourceAsStream("chekins.txt"));
        
        while (sc2.hasNextLine()){
            String id = sc2.nextLine();
            if (!registered.contains(id)){
                System.out.println(id + ": Rejected (not registered)");
                rejected++;
            }else if (chekins.contains(id)){
                System.out.println(id + ": Rejected (already checked in)");
                rejected++;
            }else {
                chekins.add(id);
                System.out.println(id + ": Checked in");
            }
        }

        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + registered.size());
        System.out.println("Successful check-ins: " + chekins.size());
        System.out.println("Absent students: " + (registered.size() - chekins.size()));
        System.out.println("Rejected attempts: " + rejected);
    }
}
