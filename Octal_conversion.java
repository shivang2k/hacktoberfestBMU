public class octal_conversion {
    public static void main(String args[])
  {
      int dec=100, q, i=1, j;
      int num[] = new int[20];
      q = dec;
      
      while(q != 0)
      {
          num[i] = q%8;
          q = q/8;
          i++;
      }
      System.out.print("Octal number is: ");
      for(j=i-1; j>0; j--)
      {
          System.out.print(num[j]);
      }
  }
}
