import java.util.Scanner;

public class Pattern6 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = n/2 + 1;
        int sp = 1;
        int st = (n+1)/2;
        for(int i=0;i<n;i++){
            for(int j=0;j<st;j++){
                System.out.print("*\t");
            }
            for(int j=0;j<sp;j++){
                System.out.print("\t");
            }
            for(int j=0;j<st;j++){
                System.out.print("*\t");
            }
            if(i<k-1){
                st = st-1;
                sp = sp+2;
            } else {
                st = st+1;
                sp = sp-2;
            }
            System.out.println();
        }
    }   
}