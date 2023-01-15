import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class FullUserDataTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1050";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void practiceFormTest () {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Anatoly");
        $("#lastName").setValue("Slabodenyuk");
        $("#userEmail").setValue("Slabodenyuk@test.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("7123123121");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1997");
        $("[aria-label=\"Choose Wednesday, July 16th, 1997\"]").click();
        $("#subjectsInput").setValue("eng").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFromClasspath("Scala.jpg");
        $("#currentAddress").setValue("MyAddress");
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-0").click();

        $("#submit").click();

        $(".modal-content").should(appear);

        $("#example-modal-sizes-title-lg").shouldHave(exactText("Thanks for submitting the form"));

        $(".modal-body").shouldHave(
                text("Anatoly" + " " + "Slabodenyuk"),
                (text("Slabodenyuk@test.com")),
                (text("Male")),
                (text("7123123121")),
                (text("16 July,1997")),
                (text("English")),
                (text("Sports, Reading")),
                (text("Scala.jpg")),
                (text("MyAddress")),
                (text("Haryana Karnal"))

        );
    }
}
