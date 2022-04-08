package io.centilliard.dto;

import java.time.LocalDate;

public class ContentDto {

    private String title;
    private String subTitle;
    private LocalDate createDate;
    private LocalDate modifyDate;
    private LocalDate publishDate;
    private String html;
    
    public ContentDto() {

    }

    public ContentDto(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public ContentDto(String title, String subTitle, LocalDate createDate, LocalDate modifyDate, LocalDate publishDate,
            String html) {
        this.title = title;
        this.subTitle = subTitle;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.publishDate = publishDate;
        this.html = html;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDate modifyDate) {
        this.modifyDate = modifyDate;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

}
