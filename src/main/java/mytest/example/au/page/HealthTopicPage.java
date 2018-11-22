package mytest.example.au.page;

import mytest.example.au.base.Communication;
import mytest.example.au.base.ExtendedPage;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by pc on 11/22/18.
 */
public class HealthTopicPage extends ExtendedPage {

    private ArrayList<String> topicList;
    private String checkBoxXpath = "/html/body/div[8]/div/div[1]/div/div[2]/div[2]/div[2]/label/input";
    private String filterXpath = "/html/body/div[8]/div/div[1]/div/div[2]/div[2]/div[1]/div/input";
    private String submitButtonXpath = "/html/body/div[8]/div/div[1]/div/div[2]/div[2]/div[3]/div/a";


    public ArrayList<String> getTopicList() {
        return topicList;
    }

    public void setTopicList(ArrayList<String> topicList) {
        this.topicList = topicList;
    }

    public String getCheckBoxXpath() {
        return checkBoxXpath;
    }

    public void setCheckBoxXpath(String checkBoxXpath) {
        this.checkBoxXpath = checkBoxXpath;
    }

    public String getFilterXpath() {
        return filterXpath;
    }

    public void setFilterXpath(String filterXpath) {
        this.filterXpath = filterXpath;
    }

    public String getSubmitButtonXpath() {
        return submitButtonXpath;
    }

    public void setSubmitButtonXpath(String submitButtonXpath) {
        this.submitButtonXpath = submitButtonXpath;
    }

    @Override
    public boolean init() {
        Iterator<String> iterator = getTopicList().iterator();
        while (iterator.hasNext()){
            setTextBoxWithXpath(getFilterXpath(),iterator.next());
            selectWithXpath(getCheckBoxXpath());
        }
        Communication.getDriver().findElement(By.className("btn")).findElement(By.xpath("/html/body/div[8]/div/div[1]/div/div[2]/div[2]/div[4]/div/a")).click();
        return true;
    }
}
