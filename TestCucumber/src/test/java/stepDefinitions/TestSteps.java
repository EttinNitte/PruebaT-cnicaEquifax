package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestSteps {

	static WebDriver driver;
	static int stepCounter=0;
	
	@Before
	public void before() {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
	}
	
	@After
	public void after() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(driver !=null)
			driver.quit();
	}	
	
	@Given("navego a la URL {string}")
	public void navego_a_la_URL(String string) throws InterruptedException {
		driver.get(string);
		esperarSegundos(driver,5);
	}

	@When("el usuario selecciona el boton de perfil de usuario para iniciar sesion")
	public void el_usuario_selecciona_el_boton_de_perfil_de_usuario_para_iniciar_sesion() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menuUserSVGPath\"]")).click();
		esperarSegundos(driver,3);
	}

	@When("Ingresa el usuario {string}")
	public void ingresa_el_usuario(String string) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-view[1]/div/input")).sendKeys(string);
		esperarSegundos(driver,1);
	}
	
	@When("la password {string}")
	public void la_password(String string) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-view[2]/div/input")).sendKeys(string);
		esperarSegundos(driver,1);
		driver.findElement(By.xpath("//*[@id=\"sign_in_btnundefined\"]")).click();
		esperarSegundos(driver,3);
	}
	
	@Then("el sistema logea correctamente al usuario {string}")
	public void el_sistema_logea_correctamente_al_usuario(String string) {
		String expected = string;
		String actual = driver.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span")).getText();
		if (expected.equalsIgnoreCase(actual)) {	
			assertEquals( actual,expected);
		}else {
			AssertJUnit.fail("El usuario no pudo iniciar sesion");
		}
	}


	@Then("el sistema logea correctamente al usuario")
	public void el_sistema_logea_correctamente_al_usuario() {
		
	}

	@Then("el sistema  no logea al usuario")
	public void el_sistema_no_logea_al_usuario() throws InterruptedException {
		String expected = "Incorrect user name or password.";
		String actual = driver.findElement(By.xpath("//*[@id=\"signInResultMessage\"]")).getText();
		if (expected.equalsIgnoreCase(actual)) {	
			assertEquals( actual,expected);
		}else {
			AssertJUnit.fail("El usuario pudo iniciar sesion");
		}
	}
	
	
	public void esperarSegundos(WebDriver driver, int segundos) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.MINUTES);
		Thread.sleep(segundos*1000);
	}
	
	@When("se selecciona el icono de busqueda")
	public void se_selecciona_el_icono_de_busqueda() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menuSearch\"]")).click();
		esperarSegundos(driver,1);
	}

	@When("se ingresa {string}")
	public void se_ingresa(String string) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"autoComplete\"]")).sendKeys(string);
		esperarSegundos(driver,1);
	}

	@When("se presiona el boton buscar")
	public void se_presiona_el_boton_buscar() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"autoComplete\"]")).sendKeys(Keys.ENTER);
		esperarSegundos(driver,5);
	}

	@Then("el sistema muestra los productos relacionados a {string}")
	public void el_sistema_muestra_los_productos_relacionados_a(String string) {
		String expected = string;
		String actual = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/div/div[2]/ul/li[1]/p[1]/a")).getText();
		System.out.println(actual);
		if (actual.equalsIgnoreCase(expected)) {	
			
		}else {
			AssertJUnit.fail("No se pudo encontrar producto");
		}
	}
	@Then("el sistema no encuentra resultados para {string}")
	public void el_sistema_no_encuentra_resultados_para(String string) {
		String expected = string;
		String actual = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span")).getText();
		if (actual.contains(expected)) {	
			
		}else {
			AssertJUnit.fail("El producto buscado si devuelve resultados");
		}
	}

}
