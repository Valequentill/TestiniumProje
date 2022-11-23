import Utilities.Log4j;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.apache.log4j.Logger;

import static java.lang.Integer.parseInt;


public class Testing {
    public static WebDriver driver;
    public static String url;
    private static Logger log  = Logger.getLogger(Log4j.class.getName());
    public static WebElements webElements;





    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        url = "https://www.network.com.tr/";
        webElements = new WebElements(driver);
        driver.manage().window().maximize();


    }

    @Test
    public void tests() throws InterruptedException{
        Actions deneme = new Actions(driver);
        driver.get(url);
        Assertions.assertEquals("https://www.network.com.tr/", url);
        log.info("url kontrolü yapıldı.");

        WebElement searchProduct = webElements.searchProduct();
        searchProduct.sendKeys("ceket");
        searchProduct.sendKeys(Keys.ENTER);

        WebElement showMore = webElements.showMore();
        Actions kemal = new Actions(driver);
        kemal.moveToElement(showMore);
        kemal.perform();
        showMore.click();

        Thread.sleep(3000);
        String newUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.network.com.tr/search?searchKey=ceket&page=2",newUrl);
        log.info("2. sayfaya geçildiğinin kontrolü yapıldı.");

        WebElement productWithDiscount = webElements.productWithDiscount();
        Actions kemal1 = new Actions(driver);
        kemal1.moveToElement(productWithDiscount);
        kemal1.perform();


        WebElement selectDiscountedProduct = webElements.selectDiscountedProduct();
        selectDiscountedProduct.click();
        Thread.sleep(3000);

        WebElement goToCard = webElements.goToCard();
        goToCard.click();

        WebElement sepeteGitButonu = webElements.sepeteGitArtık();
        sepeteGitButonu.click();

        Thread.sleep(3000);
        String oldPrice = webElements.oldPrice().getText();
        String discountedPrice = webElements.discountedPrice().getText();
        oldPrice = oldPrice.replaceAll(" TL","");
        oldPrice = oldPrice.replaceAll("\\.","");
        oldPrice = oldPrice.replaceAll("\\,","");
        discountedPrice = discountedPrice.replaceAll(" TL","");
        discountedPrice = discountedPrice.replaceAll("\\.","");
        discountedPrice = discountedPrice.replaceAll("\\,","");
        int eskiFiyat = parseInt(oldPrice);
        int yeniFiyat = parseInt(discountedPrice);
        Assertions.assertTrue(eskiFiyat>yeniFiyat);
        log.info("Eski ve yeni fiyat kontrolü yapıldı.");

        WebElement continueButton = webElements.continueButton();
        continueButton.click();
        log.info("Devam et butonuna tıklandı.");

        Thread.sleep(3000);
        WebElement email = webElements.writeEmail();
        email.sendKeys("kemalkarakaya111@gmail.com");
        log.info("Email girildi.");

        WebElement password = webElements.writePassword();
        password.sendKeys("şifrem123.");
        log.info("Şifre girildi.");

        WebElement loginButton = webElements.loginButton();
        Assertions.assertTrue(loginButton.isDisplayed());
        log.info("Giriş yap butonu kontrol edildi.");

        Thread.sleep(3000);
        WebElement networkButton = webElements.networkButton();
        networkButton.click();
        log.info("Ana sayfaya dönüldü.");

        Thread.sleep(3000);
        WebElement bagLogo = webElements.bagLogo();
        bagLogo.click();

        Thread.sleep(3000);
        WebElement removeProduct = webElements.removeProduct();
        removeProduct.click();
        log.info("Ürün sepetten çıkartıldı.");

        Thread.sleep(3000);
        WebElement removeFromCard = webElements.removeFromCard();
        removeFromCard.click();
        log.info("Sepet boşaltıldı.");

        Thread.sleep(3000);
        WebElement bagLogo1 = webElements.bagLogo();
        bagLogo1.click();

        Thread.sleep(3000);
        WebElement bagEmpty = webElements.bagEmpty();
        Assertions.assertTrue(bagEmpty.isDisplayed());
        log.info("Sepetin boş olduğu kontrol edildi.");




    }

    @After
    public void afterTest(){
        driver.quit();
    }


}
