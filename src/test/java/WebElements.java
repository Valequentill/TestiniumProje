import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WebElements {

    public static WebDriver driver;
    public WebElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement searchProduct(){
        return driver.findElement(By.name("searchKey"));
    }

    public WebElement showMore(){
        return driver.findElement(By.cssSelector("button[class='button -secondary -sm relative']"));

    }

    public WebElement productWithDiscount(){
        return driver.findElement(By.xpath("(//span[@class='product__price -label -old -size'])[1]"));

    }

    public WebElement selectDiscountedProduct(){
        return driver.findElement(By.xpath("(//label[@class='radio-box__label'])[1]"));

    }

    public WebElement goToCard(){
        return driver.findElement(By.cssSelector("button[class='header__basketTrigger js-basket-trigger -desktop']"));

    }

    public WebElement sepeteGitArtık(){
        return driver.findElement(By.xpath("//a[text()='Sepete Git']"));
    }

    public WebElement oldPrice(){
        return driver.findElement(By.cssSelector("span[class='cartItem__price -old -labelPrice']"));

    }

    public WebElement discountedPrice(){
        return driver.findElement(By.cssSelector("span[class='cartItem__price -sale']"));

    }

    public WebElement continueButton(){
        return driver.findElement(By.cssSelector("button[class='continueButton n-button large block text-center -primary']"));

    }

    public WebElement writeEmail(){
        return driver.findElement(By.xpath("//input[@class='input js-trim']"));

    }

    public WebElement writePassword(){
        return driver.findElement(By.xpath("//input[@class='input']"));

    }

    public WebElement loginButton(){
        return driver.findElement(By.cssSelector("button[class='n-button large block text-center -primary ']"));

    }

    public WebElement networkButton(){
        return driver.findElement(By.cssSelector("svg[class='headerCheckout__logo__img']"));

    }

    public WebElement bagLogo(){
        return driver.findElement(By.cssSelector("button[class='header__basketTrigger js-basket-trigger -desktop']"));

    }

    public WebElement removeProduct(){
        return driver.findElement(By.cssSelector("svg[class='header__basketProductRemove']"));

    }

    public WebElement removeFromCard(){
        return driver.findElement(By.cssSelector("button[class='btn -black o-removeCartModal__button']"));

    }

    public WebElement bagEmpty(){
        return driver.findElement(By.xpath("//span[text()='Sepetiniz Henüz Boş']"));

    }
}
