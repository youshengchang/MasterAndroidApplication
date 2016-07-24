package com.infotech.masterandroidapplication.data;

import com.google.firebase.database.IgnoreExtraProperties;
import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by youshengchang on 7/12/16.
 */
@IgnoreExtraProperties
public class JobContact{
    public String name;
    public String description;
    public String country;
    public String email;

    public JobContact(String name, String description, String country, String email) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.email = email;
    }

    public JobContact() {
    }

    @Override
    public String toString() {
        return "JobContact{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    /*
    public String getName() {
        return getString("name");
    }

    public String getDescription() {
        return getString("description");
    }

    public String getCountry() {
        return getString("country");
    }

    public String getEmail() {
        return getString("email");
    }
*/
}
