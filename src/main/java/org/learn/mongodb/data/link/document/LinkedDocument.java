package org.learn.mongodb.data.link.document;

import java.util.Date;

public interface LinkedDocument {

    String getAadhaarNumber();

    LinkedDocumentType getLinkedDocumentType();

    String getLinkedDocumentNumber();

    Date getLinkedDate();

    void setLinkedDate(Date date);

    public enum LinkedDocumentType {
        PAN_CARD, DL, BANK;
    }
}

