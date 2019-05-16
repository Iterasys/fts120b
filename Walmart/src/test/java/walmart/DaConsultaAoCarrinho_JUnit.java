package walmart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

@RunWith(Parameterized.class)
public class DaConsultaAoCarrinho_JUnit {
	String baseUrl;
	WebDriver driver;
	String pastaPrint = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());
	static String caminhoFirefox;
	static String caminhoIE;
	static FirefoxOptions ffOptions;
		
	
	// Métodos de Apoio
	// Método de Print de Tela
	public void Print(String nomePrint) throws IOException {
		File foto =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(foto,
		new File("C:\\Users\\Gabriel Correia\\eclipse-workspace\\Walmart\\target\\evidencias\\" + pastaPrint + "\\" + nomePrint + ".png"));
	}
	
	// Método de Leitura de Dados
    // Atributos de Massa de Teste
	private String id;
	private String termo;
	private String resultado;
	private String browser;
	
	// Construtor
	
	public DaConsultaAoCarrinho_JUnit(String id, String termo, String resultado, String browser) {
		this.id = id;
		this.termo = termo;
		this.resultado = resultado;
		this.browser = browser;
	}
	
	@Parameters
	public static Collection <String[]> LerArquivo() throws IOException {
		return LerCSV("C:\\Users\\Gabriel Correia\\eclipse-workspace\\Walmart\\db\\massa.csv");
	}
	
    // Não Mexa
	private static Collection<String[]> LerCSV(String nomeMassa) throws IOException {
		List<String[]> dados = new ArrayList<String[]>();
		String linha;
		BufferedReader arquivo = new BufferedReader(new FileReader(nomeMassa));
		while((linha = arquivo.readLine()) != null) {
			String campos[] = linha.split(";");
			dados.add(campos);
		}
		arquivo.close();
				
		return dados;
	}
	
	@BeforeClass
	public static void AntesDeTudo() {
		// Apontar para os drivers
		// Chrome
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Gabriel Correia\\eclipse-workspace\\Walmart\\drivers\\chrome\\74\\chromedriver.exe");
		
		// Firefox
		ffOptions = new FirefoxOptions();
		ffOptions.setLegacy(true);
		caminhoFirefox = "C:\\Users\\Gabriel Correia\\eclipse-workspace\\Walmart\\drivers\\firefox\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", caminhoFirefox);
		
		// Internet Explorer
		System.setProperty("webdriver.ie.driver", 
				"C:\\Users\\Gabriel Correia\\eclipse-workspace\\Walmart\\drivers\\ie\\32\\IEDriverServer.exe");
		
		
	
	}

	@Before
	public void Iniciar() {
		baseUrl = "https://www.walmart.com.br";
		
		switch(browser) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver(ffOptions);
				break;
			case "ie":
				driver = new InternetExplorerDriver();
				break;
		}
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}


	@After
	public void Finalizar() {
		driver.quit();
	}
	
	@Test
	public void que_acesso_o_site_Walmart() throws Throwable {
		driver.get(baseUrl);
		System.out.println("Passo 1 - Abriu o site");
		Print("TC0021 - Caminho Feliz - id " + id + " - Passo 1 - Home Walmart");
		driver.findElement(By.id("suggestion-search")).clear();
		// Usando o parametro termo a partir do arquivo feature
		// driver.findElement(By.id("suggestion-search")).sendKeys(Keys.chord(Termo));
		// Usando uma função de leitura de arquivo CSV
		driver.findElement(By.id("suggestion-search")).sendKeys(Keys.chord(termo));
		System.out.println("Passo 2 - Digitou o termo de busca");
		Print("TC0021 - Caminho Feliz - id " + id + " - Passo 2 - Consulta Produto");
		driver.findElement(By.id("suggestion-search")).sendKeys(Keys.ENTER);
		// Usando o parametro Resultado a partir do arquivo feature
		// String resultadoEsperado = "Resultados de busca para \"" + Resultado + "\"";
		// Usando uma função de leitura de arquivo CSV
		String resultadoEsperado = "Resultados de busca para \"" + resultado + "\"";
		
		String resultadoObtido = driver.findElement(By.cssSelector("h1.search-title")).getText();
		// Comparar se os 2 textos são iguais
		assertEquals(resultadoEsperado,resultadoObtido);
		// Verificar se o texto da página contém o resultado
		assertTrue(resultadoObtido.contains(resultado));
		System.out.println("Passo 3 - Validou o titulo da lista de produtos");
		Print("TC0021 - Caminho Feliz - id " + id + " - Passo 3 - Valida Titulo da Lista");
	}
	
		
}
