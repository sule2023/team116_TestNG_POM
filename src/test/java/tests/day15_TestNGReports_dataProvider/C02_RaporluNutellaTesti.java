package tests.day15_TestNGReports_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluNutellaTesti extends TestBaseRapor {


    @Test
    public void raporluTest(){
       extentTest = extentReports.createTest("Raporlu Nutella Arama","Kullanici amazonda Nutella arayabilmeli");
        // amazona gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("kullanici  amazon ana sayfaya gider");

        // nutella icin arama yapin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        extentTest.info("kullanici nutella icin arama yapar ");
        // sonuclarin nutella icerdigini test edin
        String expectedIcerik = "Nutella";
        String actuelSonucyazisi = amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actuelSonucyazisi.contains(expectedIcerik));

        extentTest.pass("sonuclarin nutella icerdigini test eder");

        // sayfayi kapatin
        Driver.closeDriver();

    }
}
