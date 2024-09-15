package com.example.jobportal.controller.review;


import com.example.jobportal.controller.company.CompanyEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
//@Table(name="Review")
public class ReviewEntity {


    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            private int id;
            private String title;
            private String author;
            private String content;
            private String date;
            private String type;

            private long rating;


            @ManyToOne
            CompanyEntity company;

    public ReviewEntity(){}

    public ReviewEntity(int id, String title, String author, String content, String date, String type,CompanyEntity company,long rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.date = date;
        this.type = type;
        this.company = company;
        this.rating = rating;
    }



    public int getId() {
        return id;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }
}
