package org.learn.mongodb.data.link.document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "linked-document")
public class LinkedPANCard extends AbstractLinkedDocument {

    @Id
    private ObjectId id;

    private String panNo;

    private String aadhaarNumber;


    private String firstName;
    private String lastName;
    private Date dob;
    private Date linkedDate;

    public LinkedPANCard(String panNo, String aadhaarNumber, String firstName, String lastName, Date dob) {
        this.panNo = panNo;
        this.aadhaarNumber = aadhaarNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.linkedDate = new Date();
    }

    @Override
    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    @Override
    public LinkedDocumentType getLinkedDocumentType() {
        return LinkedDocumentType.PAN_CARD;
    }

    @Override
    public String getLinkedDocumentNumber() {
        return panNo;
    }

    @Override
    public Date getLinkedDate() {
        return linkedDate;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public void setLinkedDate(Date linkedDate) {
        this.linkedDate = linkedDate;
    }

}
