package hw4.ex1;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class Exercise1 extends TestImplementation {

    @Test
    public void TableWithPagesTesting (){
        //Open test site by URL
        openSite(firstURL);
        assertTrue(checkURL(firstURL));

        //Assert Browser title
        assertTrue(checkTitle(firstTitle));

        //Perform login
        login(login, password);
        assertTrue(isLoggined());

        //Assert User name in the left-top side of screen that user is loggined
        assertTrue(checkUsername());

        //Open through the header menu Service -> Table with pages
        openTableWithPages();
        assertTrue(checkURL("https://jdi-testing.github.io/jdi-light/table-pages.html"));

        //Check that default value for “Show entries” dropdown is 5
        assertEquals(showEntriesValue(), "5");

        //Select new value for the entries in the dropdown list
        selectNewShowEntriesValue(newValueForShowEntries);
        assertEquals(showEntriesValue(), newValueForShowEntries);

        //Assert that in the table displayed corrected amount of entries
        assertTrue(isTableDisplayedCorrect());

        //Type in “Search” text field
        typeToSearch();

        //Assert the table contains only records with Search field value
        assertTrue(checkTableAfterSearch());
    }
}
