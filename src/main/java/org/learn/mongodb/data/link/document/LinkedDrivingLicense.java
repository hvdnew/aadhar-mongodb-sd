package org.learn.mongodb.data.link.document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "linked-document")
public class LinkedDrivingLicense extends AbstractLinkedDocument {

    @Id
    private ObjectId id;

    private String dlNumber;
    private String dlType;

    private String aadhaarNumber;


    private String firstName;
    private String lastName;
    private Date issuedDate;
    private Date linkedDate;

    public LinkedDrivingLicense(String dlNumber, String dlType, String aadhaarNumber, String firstName, String lastName, Date issuedDate) {
        this.dlNumber = dlNumber;
        this.dlType = dlType;
        this.aadhaarNumber = aadhaarNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.issuedDate = issuedDate;
        this.linkedDate = new Date();
    }

    @Override
    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    @Override
    public LinkedDocumentType getLinkedDocumentType() {
        return LinkedDocumentType.DL;
    }

    @Override
    public String getLinkedDocumentNumber() {
        return dlNumber;
    }

    @Override
    public Date getLinkedDate() {
        return linkedDate;
    }

    public String getDlNumber() {
        return dlNumber;
    }

    public void setDlNumber(String dlNumber) {
        this.dlNumber = dlNumber;
    }

    public String getDlType() {
        return dlType;
    }

    public void setDlType(String dlType) {
        this.dlType = dlType;
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

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    @Override
    public void setLinkedDate(Date linkedDate) {
        this.linkedDate = linkedDate;
    }
}
