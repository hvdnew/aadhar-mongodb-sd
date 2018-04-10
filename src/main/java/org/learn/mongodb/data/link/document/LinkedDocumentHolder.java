package org.learn.mongodb.data.link.document;

import org.learn.mongodb.data.master.VerificationStatus;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class LinkedDocumentHolder {

    @DBRef
    private LinkedDocument document;
    private VerificationStatus status;

    public LinkedDocumentHolder(LinkedDocument document, VerificationStatus status) {
        this.document = document;
        this.status = status;
    }

    public LinkedDocument getDocument() {
        return document;
    }

    public void setDocument(LinkedDocument document) {
        this.document = document;
    }

    public VerificationStatus getStatus() {
        return status;
    }

    public void setStatus(VerificationStatus status) {
        this.status = status;
    }
}
