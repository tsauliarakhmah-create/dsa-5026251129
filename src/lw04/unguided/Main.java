import java.util.*; 

public class Main {
static void bubleSort(int[] a, int passes) {
    int N = a.length;
    for (int i = 0; i < passes; i++) {
        for (int j = 0; j <= N - 2 - i; j++) {
            if (a[j] < a[j + 1]) {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
        }
    }
}

static int steps; 

static int binarySearch(int[] a, int target) {
    int low = 0, high = a.length - 1;
    steps = 0; 
    while (low <= high) {
        int mid = (low + high) / 2;
        steps++;
        if (a[mid] == target){
            return mid;
        }else if (a[mid] > target) {
            low = mid + 1;  
        }else {
            high = mid - 1;  
        }                      
    }
    return -1;
}

public static void main(String[] args) {
   Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));

   int N = sc.nextInt();
   int [] parcels = new int[N];
    for (int i = 0; i < N; i++) {
         parcels[i] = sc.nextInt();
    }

    int M = sc.nextInt();
    int [] targets = new int[M];
    for (int i = 0; i < M; i++) {
        targets[i] = sc.nextInt();
    }

    sc.close();

    bubleSort(parcels, 2);

    int [] afterPasses = new int[N];
    for (int i = 0; i < N; i++) {
        afterPasses[i] = parcels[i];
    }

    bubleSort(parcels, N - 1);

    System.out.println("==== After 2 passes ====");
    for (int i = 0; i < N; i++) {
        System.out.print(afterPasses[i]);
        if (i < N - 1) {
            System.out.print(" ");
        }
    }
    System.out.println();

    System.out.println();
    System.out.println("==== Fully Sorted ====");
    for (int i = 0; i < N; i++) {
        System.out.print(parcels[i]);
        if (i < N - 1) {
            System.out.print(" ");
        }
    }
    System.out.println();

    System.out.println();
    System.out.println("==== Search Results ====");
    for (int i=0; i < M; i++){
        int idx = binarySearch(parcels, targets[i]);
        if (idx != -1) {
            System.out.println(targets[i] + ": FOUND at index " + idx + " (steps:" + steps + ")");
        } else {
            System.out.println(targets[i] + ": NOT FOUND (steps:" + steps + ")");
        }
    } 
}
}
