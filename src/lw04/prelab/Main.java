package lw04.prelab;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int N = sc.nextInt();
        int[] branches = new int[N];
        for (int i = 0; i < N; i++) {
            branches[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = sc.nextInt();
        }
        sc.close();

        for (int i=1; i<=3; i++) {
            int key = branches[i];
            int j = i - 1;

            while (j >= 0 && branches[j] < key) {
                branches[j + 1] = branches[j];
                j--;
            }

            branches[j + 1] = key;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(branches[i]);
            if (i < N -1) System.out.print(" ");
        }

        System.out.println();

        for (int t=0; t < M; t++) {
            int idx = -1;
            for (int i = 0; i < N; i++) {
                if (branches[i] == targets[t]) {
                    idx = i;
                    break;
                }
            }

            if (idx == -1) {
                System.out.println(targets[t] + ": NOT FOUND");
            } else {
                System.out.println(targets[t] + ": FOUND at index " + idx);
            }

        }
    }

    
}

static void insertionSort(int[] a, int passes) {
    for (int i = 1; i <= passes; i++) {
        int key = a[i];
        int j = i - 1;
        while (j >= 0 && a[j] < key) {
            a[j + 1] = a[j];
            j--;
        }
        a[j + 1] = key;
    }
}

static int linearSearch(int[] a, int target) {
    for (int i = 0; i < a.length; i++) {
        if (a[i] == target) return i;
    }
    return -1;
}
static void bubbleSort(int[] a, int passes) {
        int n = a.length;
        for (int i = 0; i < passes; i++) {
            for (int j = 0; j <= n - 2 - i; j++) {
                if (a[j] < a[j + 1]) {          
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    static void selectionSort(int[] a, int passes) {
        int n = a.length;
        for (int i = 0; i < passes; i++) {
            int idx = i;                        
            for (int j = i + 1; j < n; j++) {
                if (a[j] > a[idx]) idx = j;      
            }
            int temp = a[i];                     
            a[i] = a[idx];
            a[idx] = temp;
        }
    }


    static void insertionSort(int[] a, int passes) {
        for (int i = 1; i <= passes; i++) {      
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] < key) {       
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    static int linearSearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) return i;
        }
        return -1;
    }

    static int binarySearch(int[] a, int target) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == target) return mid;
            else if (a[mid] < target) high = mid - 1;  
            else low = mid + 1;                        
        return -1;
    }
