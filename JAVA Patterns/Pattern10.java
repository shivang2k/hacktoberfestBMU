import java.util.Scanner;

public class Pattern10 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int os = n/2;
        int is = -1; 
        for(int i = 0;i<n;i++){
            for(int j =0;j<os;j++){
                System.out.print("\t");
            }
            System.out.print("*\t");

            if(is>0){
                for(int j=0;j<is;j++){
                    System.out.print("\t");
                }
                System.out.print("*");
            }
            System.out.println();
            if(i<n/2){
                os = os-1;
                is = is+2;
            } else {
                os = os+1;
                is = is-2;
            }
        }        
    }
}