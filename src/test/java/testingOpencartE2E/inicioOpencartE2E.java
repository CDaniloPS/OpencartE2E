package testingOpencartE2E;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

public class inicioOpencartE2E {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		ConfigurarDriver();
		//INGRESO A PLATAFORMA		
		driver.get(ruta());
		//Paso 1. AGREGAR 2 ITEMS AL CARRITO   ---------------------------------------
		additem1();
		additem2();
		//Paso 2. VISUALIZAR CARRITO   ------------------------------------------------
		driver.get(ruta2());
		//ACEPTAR CARRITO
		driver.get(ruta3());
		//Paso 3. COMPLETAR CHECKOUT  --------------------------------------------------
		checkoutinfoStep1();
		checkoutinfoStep2();
		checkoutinfoStep4();
		checkoutinfoStep5();
		//Paso 4. FINALIZAR COMPRA CONFIRMACION  Your order has been placed! -------------
		checkoutcomplete();
	}
	
	public static void ConfigurarDriver() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver= new ChromeDriver();
	}
	public static String ruta() throws InterruptedException {
		Thread.sleep(1000);
		rutas ruta = new rutas();
		String url;
		url = ruta.Ruta;
		return url;
	}
	public static String ruta2() throws InterruptedException {
		Thread.sleep(1000);
		rutas ruta = new rutas();
		String url;
		url = ruta.Rutacheckout;
		return url;
	}
	public static String ruta3() throws InterruptedException {
		Thread.sleep(1000);
		rutas ruta = new rutas();
		String url;
		url = ruta.Rutacheckoutcheck;
		return url;
	}
	public static void additem1() throws InterruptedException {
		Thread.sleep(1000);
		WebElement submit = driver.findElement(By.xpath("//div[2]/div/div/div[2]/div[1]/div/div[3]/button[1]"));
        submit.click();

	}
	public static void additem2() throws InterruptedException {
		Thread.sleep(1000);
		WebElement submit = driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div[2]/div/div[3]/button[1]"));
		submit.click();
	}
	public static void viewcart() throws InterruptedException {
		Thread.sleep(1000);
		WebElement viewcart = driver.findElement(By.id("shopping_cart_container"));
		viewcart.click();
	}
	public static void checkout() throws InterruptedException {
		Thread.sleep(1000);
		WebElement checkout = driver.findElement(By.xpath("//div[2]/div[2]/div/div[3]/div[2]/a"));	
	    checkout.click();
	}
	public static void checkoutinfoStep1() throws InterruptedException {
		Thread.sleep(1000);
		WebElement guestcheckout0 = driver.findElement(By.xpath("//div[2]/div/div/div/div[1]/div[2]/div/div/div[1]/div[2]/label"));			
		guestcheckout0.click();
		WebElement buttoncontinue = driver.findElement(By.id("button-account"));
		buttoncontinue.click();
	}
	public static void checkoutinfoStep2() throws InterruptedException {
		Thread.sleep(1000);
			Select selectcountry = new Select(driver.findElement(By.id("input-payment-country")));		
			Select selectstate = new Select(driver.findElement(By.id("input-payment-zone")));	
		WebElement fname = driver.findElement(By.id("input-payment-firstname"));	
		WebElement lname = driver.findElement(By.id("input-payment-lastname"));
		WebElement email = driver.findElement(By.id("input-payment-email"));	
		WebElement phone = driver.findElement(By.id("input-payment-telephone"));	
		WebElement address = driver.findElement(By.id("input-payment-address-1"));	
		WebElement city = driver.findElement(By.id("input-payment-city"));	
		WebElement zcode = driver.findElement(By.id("input-payment-postcode"));	
		
		informacionUsuario infouser = new informacionUsuario();
		fname.sendKeys(infouser.getFirstname());
		lname.sendKeys(infouser.getLastname());
		email.sendKeys(infouser.getEmail());
		phone.sendKeys(infouser.getPhone());
		address.sendKeys(infouser.getAddress());		
		city.sendKeys(infouser.getCity());
		zcode.sendKeys(infouser.getPostalcode());
		selectcountry.selectByValue(infouser.countryvalue);
		Thread.sleep(1000);
		selectstate.selectByValue(infouser.statevalue);
		
		WebElement submitStep2 = driver.findElement(By.id("button-guest"));
		Thread.sleep(1000);
		submitStep2.click();	
	}
public static void checkoutinfoStep4() throws InterruptedException {
	Thread.sleep(1000);
		WebElement submitStep4 = driver.findElement(By.id("button-shipping-method"));
		submitStep4.click();
	}
public static void checkoutinfoStep5() throws InterruptedException {
	Thread.sleep(1000);
	WebElement agree = driver.findElement(By.name("agree"));
	agree.click();
	Thread.sleep(1000);
	WebElement submitStep5 = driver.findElement(By.id("button-payment-method"));
	submitStep5.click();
}
	public static void checkoutcomplete() throws InterruptedException {
		Thread.sleep(1000);
		WebElement checkoutcomplete = driver.findElement(By.id("button-confirm"));
		checkoutcomplete.click();
		Thread.sleep(1000);
		WebElement confirm = driver.findElement(By.xpath("//div[2]/div/div/h1"));
		confirm.getText();
		if(confirm.getText().equals("Your order has been placed!")) {
			System.out.println("Confirmacion Correcta: Your order has been placed! ");	
		}else {
			System.out.println(confirm.getText());	
		}
		
	}
}
