package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeleniumUtils {

    public static List<String> getElementsText(List<WebElement> list) {

        List<String> texts = new ArrayList<>();
        for (WebElement element : list) {
            texts.add(element.getText());
        }
            return texts;
    }
    public static String getScreenshot (String name) {
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs (OutputType.FILE);
        String date = new SimpleDateFormat( "yyyyMMddhhmmss").format(new Date());
        String fileName = name + date + ".png";
        String target = System.getProperty("user.dir") + "/target/extentReports/" + fileName;
        File finalDestination = new File (target);
        try {
            FileUtils.copyFile (source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
            return fileName;

    }
}
