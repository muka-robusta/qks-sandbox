package com.onetwostory.service.cryptocurrency;

import com.onetwostory.model.cryptocurrency.Currency;
import com.onetwostory.model.cryptocurrency.MultipartBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.concurrent.CompletionStage;

@RegisterRestClient(configKey = "crypto.config.api")
@Path("/ticker")
public interface CurrencyService {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    CompletionStage<Collection<Currency>> getCurrency(@QueryParam("id") String id);

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    String sendFile(@MultipartForm MultipartBody body);

}
