package tech.buildrun.urleasy.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

@Document(collection = "url")
public class UrlEntity {

    @Id
    private String id;

    private String fullurl;

    @Indexed(expireAfterSeconds = 0)
    private LocalDateTime expiresAt;


    public UrlEntity(String id, String FullUrl, LocalDateTime expiresAt) {
        this.id = id;
        this.fullurl = FullUrl;
        this.expiresAt = expiresAt;
    }


    public UrlEntity() { }


    public UrlEntity(String id) {
        this.id = id;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullUrl() {
        return fullurl;
    }

    public void setFullUrl(String FullUrl) {
        this.fullurl = FullUrl;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
