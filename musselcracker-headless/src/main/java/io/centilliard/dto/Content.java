package io.centilliard.dto;

import java.time.LocalDate;

@FunctionalInterface
public interface Content {

    ContentDto getContentDto(String title, String subTitle, LocalDate createDate, LocalDate modifyDate, LocalDate publishDate,
    String html);

    default Content of() {


        return null;
    }


    
}
