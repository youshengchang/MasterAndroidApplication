package com.infotech.masterandroidapplication.data;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by youshengchang on 7/9/16.
 */
@IgnoreExtraProperties
public class JobOffer{

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
