package com.onetwostory.model.cryptocurrency;

import lombok.Data;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

@Data
public class MultipartBody {
    @FormParam("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private InputStream file;

    @FormParam("name")
    @PartType(MediaType.TEXT_PLAIN)
    private String name;
}
