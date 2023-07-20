package com.phonebook.restAssuredTests;

import com.phonebook.dto.ContactDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RAAddContactTests extends com.phonebook.restAssuredTests.TestBase {

    @Test
    public void addNewContactSuccessTest() {

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
                .assertThat().statusCode(200)
                .extract().path("message");

        System.out.println(message);

        //Contact was added! ID: 6d61a74e-b017-4940-8c58-e27bdbb77a4b
    }
}
