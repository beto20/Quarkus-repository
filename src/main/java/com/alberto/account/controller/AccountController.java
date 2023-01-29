package com.alberto.account.controller;

import com.alberto.account.facade.AccountFacade;
import com.alberto.account.model.dto.AccountRequestDto;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Tag(name = "Account")
@Path("api/v1/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class AccountController {

    @Inject
    AccountFacade accountFacade;

    @POST
    public Response registerNewAccount(AccountRequestDto requestDto) {
        accountFacade.registerNewAccount(requestDto);
        return Response.accepted().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAccountInformation(@PathParam("id") Long accountId, AccountRequestDto requestDto) {
        accountFacade.updateAccountInformation(accountId, requestDto);
        return Response.accepted().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAccount(@PathParam("id") Long accountId) {
        accountFacade.deleteAccount(accountId);
        return Response.ok().build();
    }
}
