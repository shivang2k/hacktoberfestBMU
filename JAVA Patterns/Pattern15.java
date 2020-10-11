import java.util.Scanner;

public class Pattern15 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sp = n/2;
        int st = 1;
        int k = 1;
        for(int i = 0;i<n;i++){
            for(int j=0;j<sp;j++){
                System.out.print("\t");
            }
            int num = k;
            for(int j=0;j<st;j++){
                System.out.print(num+"\t");
                if(j>=st/2){
                    num--;
                } else {
                    num++;
                }
            }
            System.out.println();
            if(i<n/2){
                sp--;
                st = st+2;
                k++;
            } else {
                sp++;
                st = st-2;
                k--;
            }
        }
    }
}