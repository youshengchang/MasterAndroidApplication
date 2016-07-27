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
    public String imageLocation;
    public String location;

    public JobOffer() {
        // A default constructor is required.
    }

    public JobOffer(String title, String description, String type, String salary, String company, String imageLocation, String location) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.salary = salary;
        this.company = company;
        this.imageLocation = imageLocation;
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
                ", imageLocation='" + imageLocation + '\'' +
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

    public String getImageLocation() {
        return imageLocation;
    }

    public String getLocation() {
        return location;
    }
    /*
    public String getTitle() {
        return getString("title");
    }

    public void setTitle(String title) {
        put("title", title);
    }

    public String getDescription() {
        return getString("description");
    }

    public void setDescription(String description) {
        put("description", description);
    }

    public String getType() {
        return getString("type");
    }

    public void setType(String type) {
        put("type", type);
    }

    public String getSalary() {
        return getString("salary");
    }

    public void setSalary(String salary) {
        put("salary", salary);
    }

    public String getCompany() {
        return getString("company");
    }

    public void setCompany(String company) {
        put("company", company);
    }

    public String getImageLink() {
        return getString("imageLink");
    }

    public void setImageLink(String imageLink) {
        put("imageLink", imageLink);
    }

    public String getLocation() {
        return getString("location");
    }

    public void setLocation(String company) {
        put("company", company);
    }
    */

}
