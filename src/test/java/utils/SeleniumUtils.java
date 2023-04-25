package utils;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SeleniumUtils {

    public static List<String> getElementsText(List<WebElement> list) {

        List<String> texts = new ArrayList<>();
        for (WebElement element : list) {
            texts.add(element.getText());
        }
            return texts;
    }
}
