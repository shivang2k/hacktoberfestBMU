import java.util.Scanner;

public class Pattern18 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sp = 0;
        int st = n;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<sp;j++){
                System.out.print("\t");
            }
            for(int j = 0;j<st;j++){
                if(i<n/2){
                    if(j>0&&j<st-1&&i!=0){
                        System.out.print("\t");
                    } else {
                        System.out.print("*\t");
                    }
                } else {
                    System.out.print("*\t");
                }
            }

            System.out.println();

            if(i>=n/2){
                sp--;
                st+=2;
            } else {
                sp++;
                st-=2;
            }
        }
    }
}