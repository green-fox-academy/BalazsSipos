package models.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Alias {
    @Id
    @GeneratedValue
    private Long id;
    private String url;
    private String alias;
    private int hitCount;
    private int secretCode;

    public Alias() {
    }

    public Alias(String url, String alias, int hitCount, int secretCode) {
        this.url = url;
        this.alias = alias;
        this.hitCount = hitCount;
        this.secretCode = secretCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public int getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(int secretCode) {
        this.secretCode = secretCode;
    }
}
