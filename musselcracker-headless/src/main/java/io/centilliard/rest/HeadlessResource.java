package io.centilliard.rest;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.centilliard.dto.Content;
import io.centilliard.dto.ContentDto;
import io.centilliard.service.DataService;
import io.smallrye.mutiny.Uni;

@Path("/v1")
public class HeadlessResource {

    private Logger log = LoggerFactory.getLogger(HeadlessResource.class);

    @Inject DataService dataService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/about")
    public Response about() {

        JsonObject about = Json.createObjectBuilder().add("Musslecraker Headless CMS", "Version 1.0")
                .add("Stable", "false")
                .build();

        return Response.ok(about).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/content")
    public Response getContent() {

        String htmlString = """
                <html>
                  <header></header>
                  <body>
                  </body>
                </html>
                    """;

        /**
         * BiFunction<String, String, ContentDto> biFunction = (title, subTitle) -> new
         * ContentDto(title, subTitle);
         * ContentDto contentDto = biFunction.apply("arg0", "arg1");
         * contentDto.setHtml(htmlString);
         */

        Content content = (title, subTitle, createDate, modifyDate, publishDate, html) -> new ContentDto(title,
                subTitle, createDate, modifyDate, publishDate, html);

        ContentDto contentDto = content.getContentDto("Title", "Sub Title", LocalDate.now(), LocalDate.now(), LocalDate.now(), htmlString);

        return Response.ok(contentDto).build();
    }

    @POST
    @Path("/content")
    public Uni<Void> add(ContentDto contentDto) {
      
        log.info(contentDto.getHtml());
        return dataService.save(null);
    }

}