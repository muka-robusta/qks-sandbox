package com.onetwostory.service.cryptocurrency;

import com.onetwostory.model.cryptocurrency.Currency;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@RegisterRestClient(configKey = "crypto.config.api")
@Path("/ticker")
public interface CurrencyService {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    Collection<Currency> getCurrency(@QueryParam("id") String id);

}
