package org.learn.mongodb.data.master;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "person-address")
public class Address {

    @Id
    private ObjectId id;

    private String firstLine;
    private String secondLine;
    private String thirdLine;

    private String city;
    private String state;

    private String pinCode;

    public Address(String firstLine, String secondLine, String thirdLine, String city, String state, String pinCode) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.thirdLine = thirdLine;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    public String getThirdLine() {
        return thirdLine;
    }

    public void setThirdLine(String thirdLine) {
        this.thirdLine = thirdLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
