package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillPracticeFormTest() {
        String firstName = "Anatoly";
        String lastName = "Slabodenyuk";
        String fullName = firstName + " " + lastName;
        String userEmail = "Slabodenyuk@test.com";
        String gender = "Male";
        String userNumber = "7123123121";
        String birthYear = "1997";
        String birthMonth = "July";
        String birthDay = "16";
        String birthDate = birthDay + " " + birthMonth + "," + birthYear;
        String subject1 = "English";
        String subject2 = "Physics";
        String subjects = subject1 + ", " + subject2;
        String hobby1 = "Sports";
        String hobby2 = "Reading";
        String hobbies = hobby1 + ", " + hobby2;
        String img = "Scala.jpg";
        String currentAddress = "Buckingham Palace";
        String state = "Haryana";
        String city = "Karnal";
        String stateAndCity = state + " " + city;
//
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubjects(subject1)
                .setSubjects(subject2)
                .setHobbies(hobby1)
                .setHobbies(hobby2)
                .setPicture(img)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit();
//
        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", fullName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", birthDate)
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", img)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", stateAndCity);
    }
}
