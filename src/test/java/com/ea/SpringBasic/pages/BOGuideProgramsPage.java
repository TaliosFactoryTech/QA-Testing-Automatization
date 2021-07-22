package com.ea.SpringBasic.pages;

import com.ea.SpringBasic.models.GuideDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BOGuideProgramsPage {


    @Autowired
    WebDriver driver;

    @Value("${BOGuidesTable}")
    private String table;

    @Value("${BOGuideProgramsTextToChange}")
    private String selectGuideProgramText;

    @Value("${BOGuideProgramsFirstLastName}")
    private String firstLastName;

    @Value("${BOGuideProgramsGuideCode}")
    private String code;

    public String getGuideCode(GuideDetails guideDetails) {

        WebElement row = getRow(guideDetails);

        return row.findElement(By.xpath(code)).getText();
    }

    private WebElement getRow(GuideDetails guideDetails) {

        WebElement baseTable = driver.findElement(By.xpath(table));
        List<WebElement> rows = baseTable.findElements(By.tagName("tr"));

        for (int i = 1; i < rows.size() ; i++) {
            if(rows.get(i-1).findElement(By.xpath("th")).getText().contains(guideDetails.getGuide().getFirstName() +" "+ guideDetails.getGuide().getLastName())){
                return rows.get(i);
            }
        }
        return null;
    }

}
