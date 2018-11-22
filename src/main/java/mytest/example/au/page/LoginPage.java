package mytest.example.au.page;

import mytest.example.au.base.ExtendedPage;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by pc on 11/22/18.
 */
public class LoginPage extends ExtendedPage {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String submitId = "submit-id-submit";


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getSubmitId() {
        return submitId;
    }

    public void setSubmitId(String submitId) {
        this.submitId = submitId;
    }

    @Override
    public boolean init() {
        setTextBoxWithId("id_first_name",getFirstName());
        setTextBoxWithId("id_last_name",getLastName());
        setTextBoxWithId("id_password1",getPassword());
        setTextBoxWithId("id_password2",getPassword());
        setTextBoxWithId("id_email",getEmailAddress());
        selectWithId("id_agree");
        selectWithId(getSubmitId());
        return true;
    }
}
