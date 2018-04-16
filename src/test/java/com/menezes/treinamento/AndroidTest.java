package com.menezes.treinamento;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AndroidTest {
	
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
}
