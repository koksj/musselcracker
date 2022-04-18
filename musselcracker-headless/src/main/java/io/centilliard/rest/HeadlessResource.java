/**
 * Authors:
 *     Stefan Kok 
 * 
 * Copyright (C) 2020 Sefan Kok. All Rights Reserved.
 * 
 * This file is part of Musselcracker.
 * 
 * Musselcracker is free software; you can redistribute it and/or modify it under the terms of the 
 * GNU General Public License as published by the Free Software Foundation; version 2.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 * 
 */

package io.centilliard.rest;

import java.time.LocalDate;
import java.util.UUID;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.centilliard.dto.ContentDto;
import io.centilliard.dto.Septuple;
import io.centilliard.entity.Content;
import io.centilliard.service.DataService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@Path("/v1")
public class HeadlessResource {

    private Logger log = LoggerFactory.getLogger(HeadlessResource.class);

    @Inject
    DataService dataService;

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
    public Multi<ContentDto> getContent() {

        return dataService.getAll().map(this::convertToDto);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/content/{id}")
    public Multi<ContentDto> getContentById(@PathParam("id") UUID id) {

        return dataService.getByID(id).map(this::convertToDto);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/content")
    public Uni<Void> delete(ContentDto contentDto) {

        return dataService.delete(convertToEntity(contentDto));
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/content")
    public Uni<Void> update(ContentDto contentDto) {

        return dataService.save(convertToEntity(contentDto));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/content")
    public Uni<Void> add(ContentDto contentDto) {

        log.info(contentDto.getHtml());

        return dataService.save(convertToEntity(contentDto));
    }

    private ContentDto convertToDto(Content contententity) {

        log.info("id: " + contententity.getId());

        Septuple<ContentDto, UUID, String, String, LocalDate, LocalDate, LocalDate, String> content = (
                uuid,
                title,
                subTitle,
                createDate,
                modifyDate,
                publishDate,
                html) -> new ContentDto(
                        uuid,
                        title,
                        subTitle,
                        createDate,
                        modifyDate,
                        publishDate,
                        html);

        ContentDto contentDto = content.get(
                contententity.getId(),
                contententity.getTitle(),
                contententity.getSubTitle(),
                contententity.getCreateDate(),
                contententity.getModifyDate(),
                contententity.getPublishDate(),
                contententity.getHtml());

        return contentDto;
    }

    private Content convertToEntity(ContentDto contentDto) {

        Content content = null;

        /**
         * Create UUID for new inserts
         */
        if (contentDto.getId() == null) {
            content = new Content(UUID.randomUUID(),
                    contentDto.getTitle(),
                    contentDto.getSubTitle(),
                    contentDto.getCreateDate(),
                    contentDto.getModifyDate(),
                    contentDto.getPublishDate(),
                    contentDto.getHtml());
        } else {
            content = new Content(contentDto.getId(),
                    contentDto.getTitle(),
                    contentDto.getSubTitle(),
                    contentDto.getCreateDate(),
                    contentDto.getModifyDate(),
                    contentDto.getPublishDate(),
                    contentDto.getHtml());
        }

        return content;
    }

}