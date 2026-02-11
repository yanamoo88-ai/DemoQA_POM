package com.demoqa.pages.elements;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UploadPage extends BasePage {

    Robot robot;

    public UploadPage(WebDriver driver) {
        super(driver);

        try {
            robot = new Robot();
        } catch(AWTException e) {
            throw new RuntimeException(e);
        }
    }

    @FindBy(id = "uploadFile")
    WebElement uploadFile;

    public UploadPage performKeyEvent() {
        scrollWithJS(0, 100, 500);
        clickWithRectangle(uploadFile);
        //press SHIFT key
        pause(1000);
        robot.keyPress(KeyEvent.VK_SHIFT);
        pause(1000);
        //press d(upper case as SHIFT key is passed)
        robot.keyPress(KeyEvent.VK_D);
        //release SHIFT KEY
        robot.keyRelease(KeyEvent.VK_SHIFT);
        pause(1000);
        // press 1, ., t, x, t
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_T);
        pause(1000);
        //press
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public UploadPage verifyFilePath(String path) {
        Assertions.assertTrue(isContainsText(path,uploadedFilePath));
        return this;
    }



    public UploadPage performMouseEvent() {
        scrollWithJS(0, 100, 1000);
        clickWithRectangle(uploadFile);
        pause(3000);
        //find coordinates of file D1.txt
//        Point location = MouseInfo.getPointerInfo().getLocation();
//        int x = (int) location.getX();
//        int y = (int) location.getY();
//        System.out.println(x + " *** " +y);
        pause(2000);
        //-712 *** 473
        robot.mouseMove(1100,250);
        pause(2000);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        pause(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }
}
