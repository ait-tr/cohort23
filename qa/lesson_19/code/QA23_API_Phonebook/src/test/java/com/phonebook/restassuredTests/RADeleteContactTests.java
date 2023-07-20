package com.phonebook.restAssuredTests;

import com.phonebook.dto.ContactDto;
import com.phonebook.dto.ErrorDto;
import com.phonebook.dto.MessageDto;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class RADeleteContactTests extends com.phonebook.restAssuredTests.TestBase {

    String id;

    @BeforeMethod
    public void preCondition() {
        ContactDto contactDto = ContactDto.builder()
                .name("Oliver")
                .lastName("Kan")
                .email("kan@gmail.com")
                .phone("1234567890")
                .address("Berlin")
                .description("goalkeeper")
                .build();

        String message = given()
                .contentType(ContentType.JSON)
                .header("Authorization", TOKEN)
                .body(contactDto)
                .when()
                .post("contacts")
                .then()
                .extract().path("message");

        String[] all = message.split(": ");
        id = all[1];
    }

    @Test
    public void deleteContactByIdSuccessTest() {

        given()
                .header("Authorization", TOKEN)
                .when()
                .delete("contacts/" + id)
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("message",equalTo("Contact was deleted!"));

    }

    @Test
    public void deleteContactByIdWithWrongToken401Test() {

        given()
                .header("Authorization", "kfa;okdhfwaoif")
                .when()
                .delete("contacts/" + id)
                .then()
                .assertThat().statusCode(401)
                .assertThat().body("message",containsString("JWT strings must contain exactly 2 period characters"));
    }

    @Test
    public void deleteContactByIdWithWrongId400Test() {

        given()
                .header("Authorization", TOKEN)
                .when()
                .delete("contacts/29382837")
                .then()
                .assertThat().statusCode(400)
                .assertThat().body("message",containsString("not found in your contacts!"));
    }
}
