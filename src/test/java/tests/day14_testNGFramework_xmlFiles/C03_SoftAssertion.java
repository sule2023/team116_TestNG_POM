package tests.day14_testNGFramework_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_SoftAssertion {
    @Test
    public void nutellatest(){

// amazona gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // softAssertion kullanmak icin bir obnje olustr
        SoftAssert softAssert = new SoftAssert();
        // istediginiz tum testleri  soft assert objesini  kullanrak yapin
// title'in best icermedigini test edin
String unExpectedIcerik = "best";
String actualTitel = Driver.getDriver().getTitle();
softAssert.assertFalse(actualTitel.contains(unExpectedIcerik));

// url'in "https://www.amazon.com/" oldugunu test edin
String expectedUrl = "https://www.amazon.com/";
String actualUrl = Driver.getDriver().getCurrentUrl();
softAssert.assertEquals(actualUrl,expectedUrl);

//Nutella aratin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

// arama sonuclarinin Nutella icerdigini test edin
 String expectedUrunIcerik = "Nutella";
 String actualSonucYazisi = amazonPage.sonucYaziElementi.getText();
 softAssert.assertTrue(actualSonucYazisi.contains(expectedUrunIcerik),"Nutella icermiyor");

 // tum testleri bittiginde  softassert raporlasin

        softAssert.assertAll();
        /*softAssert.assertAll(); tum testleri  raporlar  failed olan herhangibi
         bir assertion varsa AssertionnEror  verir ve calismayi  durdurr
        ancak tum hatakari  assertall satirinda verir.
        hatalarin yerini  bulmamiz ve duzeltmemiz icin softassert ile yapilan assertoinlarda mutlaka
        aciklama yazilmalidir .
        bu sebeple mesaj kismina aciklama yazarsak faild olunca ne nerde hata yaptigimizi daha rahat gorebiliriz
       */
        Driver.closeDriver();
    }
}
