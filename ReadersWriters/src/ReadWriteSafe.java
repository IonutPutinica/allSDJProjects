
public class ReadWriteSafe implements ReadWrite
{
   private int readers;
   private int writers;

   public ReadWriteSafe()
   {
      readers = 0;
      writers = 0;
   }

   @Override
   public synchronized void acquireRead()
   {
      while (writers > 0)
      {
         try
         {
            System.out
                  .println(Thread.currentThread().getName() + "WAIT (readers= "
                        + readers + ", writers= " + writers + ")");
            wait();
         }
         catch (InterruptedException ie)
         {
            // TODO: handle exception
         }
      }
      System.out.println(Thread.currentThread().getName()
            + " READING (readers= " + readers + "writers= " + writers + ")");
      readers++;
   }

   @Override
   public synchronized void releaseRead()
   {
      readers--;
      if (readers == 0)
         notify(); // notify one waiting writer
      System.out.println(
            Thread.currentThread().getName() + "FINISHED READING (readers= "
                  + readers + "writers= " + writers + ")");
   }

   @Override
   public synchronized void acquireWrite()
   {
      while (readers > 0 || writers > 0)
      {
         try
         {
            wait();
         }
         catch (InterruptedException ie)
         {
            // TODO: handle exception
         }
      }

      System.out.println(Thread.currentThread().getName()
            + " WRITING (readers= " + readers + "writers= " + writers + ")");
      writers++;
   }

   @Override
   public synchronized void releaseWrite()
   {
      writers--;
      notifyAll(); // notify all waiting readers
      System.out.println(
            Thread.currentThread().getName() + "FINISHED WRITING (readers= "
                  + readers + "writers= " + writers + ")");

   }

}
