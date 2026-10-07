
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//Problem 1
        List<String> playlist = new ArrayList<>();

        Scanner sc1 = new Scanner(Main.class.getResourceAsStream("playlist.txt")); 

        while (sc1.hasNextLine()) {
            String song = sc1.nextLine();
            String[] parts = song.split(" ", 2);
            String type = parts[0];

            if (type.equals("ADD")) {
                playlist.add(parts[1]);
            } else if (type.equals("INSERT")) {
                String[] insertParts = parts[1].split(" ", 2);
                int index = Integer.parseInt(insertParts[0]);
                playlist.add(index, insertParts[1]);
            }else if (type.equals("REMOVE")) {
                if (playlist.contains(parts[1])){
                    playlist.remove(parts[1]);
                }
            }
        }
        sc1.close();

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }
        System.out.println(); 

// problem 2
        Set<String> participants = new LinkedHashSet<>();
        int duplicates = 0;
        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));

        while (sc2.hasNextLine()) {
            String participant = sc2.nextLine();
            if (!participants.add(participant)) {
                duplicates++;
            }else {
                participants.add(participant);
            }
        }
        sc2.close();

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());
        int number = 1;
        for (String participant : participants) {
            System.out.println(number + ": " + participant);
            number++;
        }
        System.out.println("Duplicate registrations: " + duplicates);
        System.out.println();

// problem 3 
        Map<String, Integer> inventory = new   LinkedHashMap<>();
        int failedSales = 0;
        Scanner sc3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        while (sc3.hasNextLine()) {
            String item = sc3.nextLine();
            String[] parts = item.split(" ");
            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            
            if (type.equals("ADD")) {
                if(inventory.containsKey(product)){
                    inventory.put(product, inventory.get(product) + quantity);
                } else {
                    inventory.put(product, quantity);
                }
            } else if (type.equals("SELL")) {
                if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
                    inventory.put(product, inventory.get(product) - quantity);
                } else {
                    failedSales++;
                }
            }
        }
        sc3.close();

        System.out.println("===== Problem 3 =====");
        for (String product : inventory.keySet()) {
            System.out.println(product + ": " + inventory.get(product));
        }
        System.out.println("Failed sales: " + failedSales);

    }
    
}
