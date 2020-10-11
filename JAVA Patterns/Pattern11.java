import java.util.Scanner;

public class Pattern11 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int num = 1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<=i;j++){
                System.out.print(num);
                System.out.print("\t");
                num++;
            }
            System.out.println();
        }
    }
}