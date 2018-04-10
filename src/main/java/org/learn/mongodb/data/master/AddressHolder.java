package org.learn.mongodb.data.master;

public class AddressHolder {

    //@DBRef
    private Address address;
    private VerificationStatus status;

    public AddressHolder(Address address, VerificationStatus status) {
        this.address = address;
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public VerificationStatus getStatus() {
        return status;
    }

    public void setStatus(VerificationStatus status) {
        this.status = status;
    }
}
