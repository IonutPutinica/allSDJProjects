import java.util.Scanner;

public class ex312
{
   public static void main(String args[])
   {
      Scanner input = new Scanner(System.in);
      int grade;
      System.out.print("Input the grade you wish to convert=");
      grade = input.nextInt();
      switch (grade)
      {
         default:
            break;
         case -3:
            System.out.println("-3=-F");
            break;
         case 0:
            System.out.println("0=Fx");
            break;
         case 2:
            System.out.println("2=E");
            break;
         case 4:
            System.out.println("4=D");
            break;
         case 7:
            System.out.println("7=C");
            break;
         case 10:
            System.out.println("10=B");
            break;
         case 12:
            System.out.println("12=A");
      }
   }
}
