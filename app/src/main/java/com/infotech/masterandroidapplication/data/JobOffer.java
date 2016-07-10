package com.infotech.masterandroidapplication.data;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by youshengchang on 7/9/16.
 */
@ParseClassName("JobOffer")
public class JobOffer extends ParseObject{
    public JobOffer() {
        // A default constructor is required.
    }

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


}
