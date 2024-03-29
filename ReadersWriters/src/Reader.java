
public class Reader implements Runnable
{
   private ReadWrite lock;

   public Reader(ReadWrite lock)
   {
      this.lock = lock;
   }

   @Override
   public void run()
   {
      while (true)
      {
         beforeReading(1000, 2000);
         lock.acquireRead();
         reading(500, 1000);
         lock.releaseRead();
         afterReading(5000, 10000);
      }

   }

   private void reading(int minTime, int maxTime)
   {
      long time = (long) (Math.random() * (maxTime - minTime) + minTime);
      try
      {
         Thread.sleep(time);
      }
      catch (InterruptedException ie)
      {
         // TODO: handle exception
      }
   }

   private void afterReading(int minTime, int maxTime)
   {
      long time = (long) (Math.random() * (maxTime - minTime) + minTime);
      try
      {
         Thread.sleep(time);
      }
      catch (InterruptedException ie)
      {
         // TODO: handle exception
      }
   }

   // sleep a random time in the interval [minTime, maxTime]
   private void beforeReading(int minTime, int maxTime)
   {
      long time = (long) (Math.random() * (maxTime - minTime) + minTime);
      try
      {
         Thread.sleep(time);
      }
      catch (InterruptedException ie)
      {
         // TODO: handle exception
      }
   }
}
