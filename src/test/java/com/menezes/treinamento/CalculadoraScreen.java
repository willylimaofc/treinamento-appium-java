package com.menezes.treinamento;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CalculadoraScreen {
	
	public CalculadoraScreen(AppiumDriver<MobileElement> appiumDriver) {
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	@AndroidFindBy(id="android_field_first_number")
	private MobileElement inputPrimeiroNumero;
	
	@AndroidFindBy(id="android_field_second_number")
	private MobileElement inputSegundoNumero;
	
	@AndroidFindBy(id="android_button_sum")
	private MobileElement buttonSum;
	
	@AndroidFindBy(id="android_result_text")
	private MobileElement resultado;
	
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
}
