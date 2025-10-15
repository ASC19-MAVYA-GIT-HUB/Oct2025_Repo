package pac1;

import org.testng.annotations.Test;

public class TC0010_Priority {
  @Test(priority=3)
  public void yahootest1() {
	  System.out.println("This is test1");
  }
  
  @Test(priority=4)
  public void aaaa() {
	  System.out.println("This is test2");
  }
  @Test(priority=1)
  public void zohotest() {
	  System.out.println("This is test3");
  }
  @Test(priority=2)
  public void amazontest() {
	  System.out.println("This is test4");
  }
  
}
