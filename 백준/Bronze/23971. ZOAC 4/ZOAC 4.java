import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.close();
        
        
        int rowCount = (H / (N + 1)) + (H % (N + 1) > 0 ? 1 : 0);
        int colCount = (W / (M + 1)) + (W % (M + 1) > 0 ? 1 : 0);
        

        System.out.println(rowCount * colCount);
        
    }
}
