package hw6.exercise2and3;

import hw6.BaseStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ThenSteps extends BaseStep {

    @Then("\"User Table\" page should be opened")
    public void userTablePageShouldBeOpened(){
        assertTrue(browser.getUserTable().checkURL("https://jdi-testing.github.io/jdi-light/user-table.html"));
    }


    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertTrue(browser.getUserTable().checkDropdowns(count));
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertTrue(browser.getUserTable().checkUsernames(count));
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertTrue(browser.getUserTable().checkDescriptionTests(count));
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertTrue(browser.getUserTable().checkCheckboxes(count));
    }

    @Then("User table should contain following values:")
    public void userTableShouldContainFollowingValues(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        for (int i = 1; i < data.size(); ++i){
            List<String> list = data.get(i);
            String number = list.get(0);
            String user = list.get(1);
            String description = list.get(2);
            assertTrue(browser.getUserTable().checkRows(number, user, description));
        }
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(DataTable dataTable) {
        List<String> dataTableList = dataTable.asList();
        List<String> droplistValues = dataTableList.subList(1, dataTableList.size());
        assertTrue(browser.getUserTable().checkDropdownForUser(droplistValues, "Roman"));
    }

    @Then("{int} log row has {string} text in log section")
    public void logRowHasTextInLogSection(int number, String expected) {
        assertTrue(browser.getUserTable().checkLogsRow(number, expected));
    }
}
