package mytest.example.au.test;

import mytest.example.au.base.Communication;
import mytest.example.au.page.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class WebSiteTest {
    @Test
    public static void main(String[] args) {
        Communication communication = new Communication();
        if(communication.navigatedToWebSite("https://test.healthshare.com.au/accounts/signup/member/","id_first_name")){
            LoginPage loginPage = new LoginPage();
            loginPage.setFirstName("roya");
            loginPage.setLastName("shah");
            loginPage.setEmailAddress("roya@mail.com");
            loginPage.setPassword("password");
            if(loginPage.init()) {
                Assert.assertTrue("Check Title", communication.getDriver().getTitle().startsWith("General Member Signup - Step 2 of 2 | Healthshare"));
            }
            HealthTopicPage healthTopicPage = new HealthTopicPage();
            healthTopicPage.setTopicList(new ArrayList<String>(){{
                add("Addiction");
                add("Food Allergies");
                add("Carers");
            }});
            if(healthTopicPage.init()) {
                Assert.assertTrue("Check Title", communication.getDriver().getTitle().startsWith("General Member Signup Completed | Healthshare"));
            }
        }
        communication.getDriver().close();
    }
}
