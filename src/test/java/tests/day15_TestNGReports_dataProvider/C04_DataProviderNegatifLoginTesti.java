package tests.day15_TestNGReports_dataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C04_DataProviderNegatifLoginTesti extends TestBaseRapor {


    @DataProvider
    public static Object[][] kullaniciListesi() {
        String[][] kullaniciIsimSifreleri = {{"sevda","12345"},{"sule","1985"},
                                              {"murat","1345"}};

        return kullaniciIsimSifreleri;
    }

    @Test(dataProvider = "kullaniciListesi")
    public void cokluNegatifLoginTesti(String kullaniciAdi,String password){
        extentTest=extentReports.createTest("Data Provider","coklu negatif login testi");

        //Qualitydemy anasayfay gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("kullanici qp ana sayfaya gider");
        // liste olarak verilen kullanici ada ve sifreleri ile
        // giris yapilamadini test edin

        QdPage qdPage = new QdPage();
        qdPage.ilkLoginLinki.click();
        // ilk login linkine tiklayin
        // kullanici adi ve sifresini yazip giris yapin
        qdPage.emailKutusu.sendKeys(kullaniciAdi);
        qdPage.passwordKutusu.sendKeys(password);
        qdPage.loginButonu.click();
        extentTest.info("verilen"+ kullaniciAdi + "ve sifeyi  yazip login button basar");

        // giris yapilamdini test edin
        Assert.assertTrue(qdPage.emailKutusu.isDisplayed());
       extentTest.pass("giris yapilamadigini test eder");
        // sayfayi kapatin

        Driver.closeDriver();
       extentTest.info("sayfayi kapatir");
    }
}
