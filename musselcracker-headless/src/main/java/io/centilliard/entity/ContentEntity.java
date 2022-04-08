package io.centilliard.entity;

import java.time.LocalDate;

import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import com.datastax.oss.driver.api.mapper.annotations.PropertyStrategy;

/**
 * Entity classes are normally required to have a default no-arg constructor,
 * unless they are annotated with @PropertyStrategy(mutable = false), which is
 * the case here.
 */

@Entity
@PropertyStrategy(mutable = false)
public class ContentEntity {

    @PartitionKey
    private String title;
    private String subTitle;
    private LocalDate createDate;
    private LocalDate modifyDate;
    private LocalDate publishDate;
    private String html;

    public ContentEntity() {

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
