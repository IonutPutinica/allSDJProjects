import java.util.Scanner;

public class ex404
{
   public static void main(String args[])
   {
      String str;
      int totalNumberOfCharacters = 0;
      Scanner input = new Scanner(System.in);
      for (int i = 0; i < 6; i++)
      {
         System.out.print("Input the string=");
         str = input.nextLine();
         totalNumberOfCharacters += str.length();
      }
      System.out.println("The total number of characters is="+totalNumberOfCharacters);
   }
}
