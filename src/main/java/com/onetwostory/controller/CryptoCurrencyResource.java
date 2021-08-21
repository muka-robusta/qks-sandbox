package com.onetwostory.controller;

import com.onetwostory.model.cryptocurrency.Currency;
import com.onetwostory.model.cryptocurrency.MultipartBody;
import com.onetwostory.service.cryptocurrency.CurrencyService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.concurrent.CompletionStage;

@Path("/crypto")
public class CryptoCurrencyResource {

    private static final String TEST_INFO = "Hello world";
    private static final String TEST_INFO_FILENAME = "test.txt";

    @Inject
    @RestClient
    CurrencyService currencyService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CompletionStage<Collection<Currency>> getCrypto(@QueryParam("id") String id) {
        return currencyService.getCurrency(id);
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String echoFile(String body) {
        return body;
    }

    @Path("/test")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String echoFile() {
        final MultipartBody multipartBody = new MultipartBody();
        multipartBody.setFile(new ByteArrayInputStream(TEST_INFO.getBytes(StandardCharsets.UTF_8)));
        multipartBody.setName(TEST_INFO_FILENAME);
        return currencyService.sendFile(multipartBody);
    }
}
