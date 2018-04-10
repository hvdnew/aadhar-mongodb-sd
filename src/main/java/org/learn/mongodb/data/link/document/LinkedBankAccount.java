package org.learn.mongodb.data.link.document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "linked-document")
public class LinkedBankAccount extends AbstractLinkedDocument {

    @Id
    private ObjectId id;

    private String bankAccountNumber;
    private String bankType;

    private String aadhaarNumber;


    private String firstName;
    private String lastName;
    private String ifscCode;
    private Date accountOpeningDate;
    private Date linkedDate;

    public LinkedBankAccount(String bankAccountNumber, String bankType, String aadhaarNumber, String firstName, String lastName, String ifscCode, Date accountOpeningDate) {
        this.bankAccountNumber = bankAccountNumber;
        this.bankType = bankType;
        this.aadhaarNumber = aadhaarNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ifscCode = ifscCode;
        this.accountOpeningDate = accountOpeningDate;
        this.linkedDate = new Date();
    }

    @Override
    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    @Override
    public LinkedDocumentType getLinkedDocumentType() {
        return LinkedDocumentType.BANK;
    }

    @Override
    public String getLinkedDocumentNumber() {
        return bankAccountNumber;
    }

    @Override
    public Date getLinkedDate() {
        return linkedDate;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
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

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public Date getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public void setAccountOpeningDate(Date accountOpeningDate) {
        this.accountOpeningDate = accountOpeningDate;
    }

    @Override
    public void setLinkedDate(Date linkedDate) {
        this.linkedDate = linkedDate;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
