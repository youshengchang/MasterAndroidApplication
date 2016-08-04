package com.infotech.masterandroidapplication.data;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

/**
 * Created by youshengchang on 7/9/16.
 */
@IgnoreExtraProperties
public class JobOffer implements Serializable{

    public String title;
    public String description;
    public String type;
    public String salary;
    public String company;
    public String imageLink;
    public String location;

    public JobOffer() {
        // A default constructor is required.
    }

    public JobOffer(String title, String description, String type, String salary, String company, String imageLink, String location) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.salary = salary;
        this.company = company;
        this.imageLink = imageLink;
        this.location = location;
    }

    @Override
    public String toString() {
        return "JobOffer{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", salary='" + salary + '\'' +
                ", company='" + company + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getSalary() {
        return salary;
    }

    public String getCompany() {
        return company;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getLocation() {
        return location;
    }

}
