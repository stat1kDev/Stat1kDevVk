
package com.example.stat1kdevvk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attachment {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("doc")
    @Expose
    private Doc doc;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

}
