import java.util.Scanner;

public class Pattern12 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int f = 0;
        int s = 1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<=i;j++){
                System.out.print(f);
                System.out.print("\t");
                int temp = f;
                f = s;
                s = temp+s;
            }
            System.out.println();
        }
    }
}