package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.ButtonsPage;
import com.demoqa.pages.elements.TextBoxPage;
import com.demoqa.utils.MyArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.awt.*;

public class ElementsTests extends TestBase {
    SidePanel sidePanel;
    ButtonsPage buttons;
    TextBoxPage textBox;

    @BeforeEach
    public void preconditions(){
        sidePanel = new SidePanel(driver);
        buttons = new ButtonsPage(driver);
        new HomePage(driver).getElements();
        textBox = new TextBoxPage(driver);
    }
    @Test
    public void doubleClickTest(){
        sidePanel.getButtons();
        buttons.doubleClick()
                .verifyDoubleClick("double click");
    }

    @Test
    public void rightClickTest(){
        sidePanel.getButtons();
        buttons.rightClick()
                .verifyRightClick("right click");
    }

    @Test
    public void copyPastTest(){
        sidePanel.getTextBox();
        textBox.copyPast("Britzer Garden 192, Berlin")
                .clickOnSubmitButton()
                .verifyAdress();
    }

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    public void textBoxWithParameterTest(String name, String email, String address){
        sidePanel.getTextBox();
        textBox.enterPersonalData(name, email, address)
                .clickOnSubmitButton()
                .verifyAdress();
    }

    @ParameterizedTest
    @CsvFileSource (resources = "/Data.csv.csv")
    public void textBoxWthCsvFileTest(String name, String email, String address){
        sidePanel.getTextBox();
        textBox.enterPersonalData(name, email, address)
                .clickOnSubmitButton()
                .verifyAdress();
    }
}
