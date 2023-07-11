package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

   public AmazonPage(){
        // baska package classlarin bu constructori  kullnmasi  icin
        //access motifier ini public yaparak kullnilir
       // bu  package clasindan locatar kullancak tum classlar
       // amazonpackge clasindan obje olustrmali
       // obje icinde bu constructor caliscgi icin bu clasdaki  web driverimizi tanimlama
       // isini bu  constructor icinde tek satirlik kod yapip her clastan kullaniriz

       PageFactory.initElements(Driver.getDriver(),this);
       // bu clasta bu drver bunu kullanilack . bu kisim cok onmli

    }
    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;
    @FindBy(xpath = "//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")public WebElement sonucYaziElementi;

}
