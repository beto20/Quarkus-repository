package com.alberto.app.account.controller;

import com.alberto.app.account.facade.AccountFacade;
import com.alberto.app.account.model.dto.AccountRequestDto;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AccountControllerTest {

    @Inject
    AccountFacade accountFacade;

    @Inject
    AccountController AccountController;

    @BeforeEach
    void setup() {
        accountFacade = Mockito.mock(AccountFacade.class);
        AccountController = Mockito.mock(AccountController.class);
    }

    public void testRegisterNewAccount() {

        var accountRequestDto = Mockito.mock(AccountRequestDto.class);

        given()
                .when()
                .contentType("application/json")
                .body(accountRequestDto)
                .post("/api/v1/accounts")
                .then()
                .statusCode(200);
    }

}