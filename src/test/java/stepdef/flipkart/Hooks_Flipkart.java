package stepdef.flipkart;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverManager;


public class Hooks_Flipkart {
DriverManager driverManager=new DriverManager();
String url="https://www.flipkart.com/";
@Before
    public void setup(){
driverManager.launchEdge(url);
}

@After
    public void tearDown(){
    driverManager.tearDown();

}
}
