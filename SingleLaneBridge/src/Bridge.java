
public class Bridge implements Lane
{
   public int numberOfBlueCars;
   public int numberOfRedCars;
   public boolean lightState;

   public Bridge()
   {
      this.numberOfBlueCars = 0;
      this.numberOfRedCars = 0;
      this.lightState = false;
   }

   @Override
   public synchronized void enterFromTheLeft()
   {
      numberOfRedCars++;
   }

   @Override
   public synchronized void exitToTheRight()
   {
      while (numberOfRedCars > 0 && lightState == true)
      {
         try
         {
            System.out.println(Thread.currentThread().getName()
                  + "WAIT (Red Cars passing= " + +numberOfRedCars
                  + ", blue cars waiting= " + numberOfBlueCars + ")");
            wait();
         }
         catch (InterruptedException ie)
         {

         }
      }
      numberOfRedCars--;
   }

   @Override
   public synchronized void enterFromTheRight()
   {
      numberOfBlueCars++;

   }

   @Override
   public synchronized void exitToTheLeft()
   {
      while (numberOfBlueCars > 0 && lightState == false)
      {
         try
         {
            System.out.println(Thread.currentThread().getName()
                  + "WAIT (Blue Cars passing= " + +numberOfBlueCars
                  + ", red cars waiting= " + numberOfRedCars + ")");
            wait();
         }
         catch (InterruptedException ie)
         {

         }
      }
      numberOfBlueCars--;

   }

}
