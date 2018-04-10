package org.learn.mongodb.data.master;

import org.learn.mongodb.data.link.document.LinkedDocument;

public class VerificationStatus {

    private boolean verified;
    private LinkedDocument.LinkedDocumentType verifiedBy;


    public VerificationStatus(boolean verified, LinkedDocument.LinkedDocumentType verifiedBy) {
        this.verified = verified;
        this.verifiedBy = verifiedBy;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public LinkedDocument.LinkedDocumentType getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(LinkedDocument.LinkedDocumentType verifiedBy) {
        this.verifiedBy = verifiedBy;
    }
}
