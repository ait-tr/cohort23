package com.phonebook.restAssuredTests;

import com.phonebook.dto.ContactDto;
import com.phonebook.dto.GetAllContactsDto;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RAGetAllContactsTests extends com.phonebook.restAssuredTests.TestBase {

    @Test
    public void getAllContactsSuccessTest() {

        GetAllContactsDto contactsDto = given()
                .header("Authorization", TOKEN)
                .when()
                .get("contacts")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(GetAllContactsDto.class);

        List<ContactDto> list = contactsDto.getContacts();

        for (ContactDto contact: list) {
            System.out.println(contact.getId());
            System.out.println(contact.getLastName());
            System.out.println("Size of list: " + list.size());
        }
    }
}
