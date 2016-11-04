package ua.ch.mgtest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = Uri.COLLECTION_NAME)
public class Uri implements Serializable{

    public static final String COLLECTION_NAME = "uri";

    @Id
    private String id;

    private String uri;

    public Uri() {
    }

    public Uri(String uri) {
        this.uri = uri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
