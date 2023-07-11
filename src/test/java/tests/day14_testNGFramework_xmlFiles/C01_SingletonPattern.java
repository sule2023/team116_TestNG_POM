package tests.day14_testNGFramework_xmlFiles;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SingletonPattern {
    @Test
    public void test01(){
       // Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
       // Driver.driver.get(ConfigReader.getProperty("amazonUrl"));
        // burdaki  driver objesi obje olusturmak icindi, deger atanmasi  icin deger driver clasindan bunun
        //privite yapinca baskalari bu hatayi yapamz
        /*
        singletonPatten : biir class
         */

    //Driver driver = new Driver();
     //driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));


    }


}
