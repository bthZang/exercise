package com.example.excercise.Content;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "content")
public class Content {

    private String author;
    @Id
    private String name ;

    private String substence;
    private Date createday;
    private Date editday;
    private boolean status; //(1: private, 0: public)

    @Override
    public String toString() {
        return "Content{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", substence='" + substence + '\'' +
                ", createday=" + createday +
                ", editday=" + editday +
                ", status=" + status +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubstence() {
        return substence;
    }

    public void setSubstence(String substence) {
        this.substence = substence;
    }

    public Date getCreateday() {
        return createday;
    }

    public void setCreateday(Date createday) {
        this.createday = createday;
    }

    public Date getEditday() {
        return editday;
    }

    public void setEditday(Date editday) {
        this.editday = editday;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



    public Content(String author, String name, String substence, Date createday, Date editday, boolean status) {
        this.author = author;
        this.name = name;
        this.substence = substence;
        this.createday = createday;
        this.editday = editday;
        this.status = status;
    }
}
