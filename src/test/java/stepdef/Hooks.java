package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverManager;


public class Hooks {
DriverManager driverManager=new DriverManager();
String url="https://www.brighthorizons.com/";
@Before
    public void setup(){
driverManager.launchChrome(url);
}

@After
    public void tearDown(){
    driverManager.tearDown();

}
}
