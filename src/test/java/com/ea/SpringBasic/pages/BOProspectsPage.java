package com.ea.SpringBasic.pages;

import com.ea.SpringBasic.models.ProspectDetails;
import com.ea.SpringBasic.Utilities.RequestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BOProspectsPage {

    @Autowired
    WebDriver driver;

    @Value("${BOProspectsSelectProspectToChange}")
    private String selectProspectText;

    @Value("${BOProspectName}")
    private String prospectName;

    @Value("${BOProspectPhoneNumber}")
    private String prospectPhoneNumber;

    @Value("${BOProspectMajor}")
    private String prospectMajor;

    @Value("${BOProspectStatements}")
    private String prospectStatements;

    @Value("${BOProspectsTable}")
    private String table;


    public boolean validateNavigation() {
        return driver.findElement(By.xpath(selectProspectText)).isDisplayed();
    }

    public void validateProspect(ProspectDetails prospectDetails) {

        String id = RequestHelper.getProspectId(prospectDetails.getProspect());

        WebElement row = getRow(id);

        Assert.assertEquals(row.findElement(By.xpath(prospectName)).getText(), prospectDetails.getProspect().getName());
        Assert.assertEquals(row.findElement(By.xpath(prospectPhoneNumber)).getText() , "+"+prospectDetails.getProspect().getPhoneNumber());
        Assert.assertEquals(row.findElement(By.xpath(prospectMajor)).getText() , prospectDetails.getProspect().getMajor());
        Assert.assertEquals(row.findElement(By.xpath(prospectStatements)).getText() , prospectDetails.getProspect().getStatements());
    }

    private WebElement getRow(String idProspect) {


        WebElement baseTable = driver.findElement(By.xpath(table));
        List<WebElement> rows = baseTable.findElements(By.tagName("tr"));

        for (int i = 1; i < rows.size() ; i++) {
            if(rows.get(i-1).findElement(By.xpath("th")).getText().equals(idProspect)){
                return rows.get(i);
            }
        }
        return null;
    }

}
