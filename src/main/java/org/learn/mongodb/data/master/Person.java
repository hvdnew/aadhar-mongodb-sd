package org.learn.mongodb.data.master;

import org.bson.types.ObjectId;
import org.learn.mongodb.data.link.document.LinkedDocumentHolder;
import org.learn.mongodb.data.link.txn.LinkedTransactionHolder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "person")
public class Person {

    @Id
    private ObjectId id;

    @Indexed
    private String aadhaarNumber;

    @Indexed
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date dob;

    private String email;

    private Phone mobile;

    private LinkedDocumentHolder panCard;
    private LinkedDocumentHolder drivingLicense;
    private LinkedDocumentHolder bankAccount;

    private LinkedTransactionHolder txnHolder;

    private AddressHolder address;

    // Biometric - MAPR.COM


    public Person() {
    }

    /**
     * <p> constructor with mandatory data. </p>
     */
    public Person(String aadhaarNumber, String firstName, String lastName, Gender gender, Date dob) {
        this.aadhaarNumber = aadhaarNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        // skipped biometric
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Phone getMobile() {
        return mobile;
    }

    public void setMobile(Phone mobile) {
        this.mobile = mobile;
    }

    public LinkedDocumentHolder getPanCard() {
        return panCard;
    }

    public void setPanCard(LinkedDocumentHolder panCard) {
        this.panCard = panCard;
    }

    public LinkedDocumentHolder getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(LinkedDocumentHolder drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public LinkedDocumentHolder getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(LinkedDocumentHolder bankAccount) {
        this.bankAccount = bankAccount;
    }

    public AddressHolder getAddress() {
        return address;
    }

    public void setAddress(AddressHolder address) {
        this.address = address;
    }

    public LinkedTransactionHolder getTxnHolder() {
        return txnHolder;
    }

    public void setTxnHolder(LinkedTransactionHolder txnHolder) {
        this.txnHolder = txnHolder;
    }

    public enum Gender {
        MALE, FEMALE, OTHERS;
    }

    public enum PhoneType {
        HOME, WORK, MOBILE;
    }

    public static class Phone {
        PhoneType type;
        String number;

        public Phone(PhoneType type, String number) {
            this.type = type;
            this.number = number;
        }

        public PhoneType getType() {
            return type;
        }

        public void setType(PhoneType type) {
            this.type = type;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }
}

