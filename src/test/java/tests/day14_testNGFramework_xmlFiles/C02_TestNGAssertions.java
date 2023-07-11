package tests.day14_testNGFramework_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_TestNGAssertions {
    @Test(groups = "regression1")
    public  void  nutellaTesti(){
        // amazona gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
// title'in best icermedigini test edin
String unExpectedIcerik = "best";
String actualTitel = Driver.getDriver().getTitle();
        Assert.assertFalse(actualTitel.contains(unExpectedIcerik),"Title istenmeyen icerik var");

// url'in "https://www.amazon.com/" oldugunu test edin
String expectedUrl = "https://www.amazon.com/";
String actuelUrl = Driver.getDriver().getCurrentUrl();
Assert.assertEquals(actuelUrl,expectedUrl,"Url belenmeyen Url");


//Nutella aratin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

// arama sonuclarinin Nutella icerdigini test edin
        String expectedIcerik = "Nutella";
        String actuelSonucYazisi = amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actuelSonucYazisi.contains(expectedIcerik),"Arama sonucu Nutella icermiyor");
        Driver.closeDriver();
    }
}
