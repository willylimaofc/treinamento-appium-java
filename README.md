## Treinamento Appium Java

Treinamento de configuração e realização do primeiro teste de UI utilizando java e appium.

## Componentes necessários para executar nossos testes

- *Java (used version 8)*
- *Appium*
- *Node*
- *Android Emulator*
- *Maven*

## Configuration

1. Adicionando o java-client no arquivo pom
```Xml
<dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>4.1.2</version>
</dependency>
``` 
2. Procurando elemento com annotations
```Java
    @AndroidFindBy(id="android_field_first_number")
	private MobileElement inputPrimeiroNumero;
``` 
3. Criando métodos para nossa screen
```Java
public void preencheNumeros(String primeiroNumero,String segundoNumero) {
    inputPrimeiroNumero.sendKeys(primeiroNumero);
    inputSegundoNumero.sendKeys(segundoNumero);
}
	
public void clicarNoBotaoSomar() {
    buttonSum.click();
}
	
public boolean isResult(String resultadoCorreto) {
    return resultado.getText().trim().equals(resultadoCorreto);
}
```
4. Criar construtor para inicializar os elementos
```Java
public CalculadoraScreen(AppiumDriver<MobileElement> appiumDriver) {
    PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
}
```
5. Criar métodos da classe de teste
```Java
@BeforeClass
public static void tearUp() throws MalformedURLException {
    //Aqui vamos configurar o nosso capabilities
}
	
@Test
public void deveSomarDoisNumeros() {
    //Aqui vamos realizar o fluxo dos nossos testes
}
	
@AfterClass
public static void tearDown() {
    //Aqui vamos finalizar o driver
}
```  

6. Configuração do nosso teste
```Java
private static CalculadoraScreen screen;
private static AppiumDriver<MobileElement> appiumDriver;
	
@BeforeClass
public static void tearUp() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("app",new File("apps/calculadora-simples-android.apk"));
    capabilities.setCapability("platformName","Android" );
    capabilities.setCapability("deviceName","Android Emulator API 22");
    appiumDriver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub") , capabilities);
    screen = new CalculadoraScreen(appiumDriver);
}
	
@Test
public void deveSomarDoisNumeros() {
    screen.preencheNumeros("10", "10");
    screen.clicarNoBotaoSomar();
    assertTrue("Erro ao validar o resultado da soma", screen.isResult("20"));
}
	
@AfterClass
public static void tearDown() {
    appiumDriver.quit();
}
```
7. Executando os testes
```
$ mvn clean test
```

## Docs and Libs

- Appium: http://appium.io/downloads.html

