package testing;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import school.School;
import java.util.HashMap;
public class SingletonTesting
{

   School school1 = new School();
   School school2 = new School();

   @Test
   public void testSingleton()
   {

      boolean check = school1.getInstance().hashCode() == school2.getInstance()
            .hashCode();
      System.out.println(school1.getInstance().hashCode());
      System.out.println(school2.getInstance().hashCode());

      assertTrue(check);
   }

}
