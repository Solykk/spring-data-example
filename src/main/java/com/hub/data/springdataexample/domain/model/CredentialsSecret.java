package com.hub.data.springdataexample.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class CredentialsSecret extends Credentials implements Serializable {

    @Column(name = "cr_secret", unique = true, nullable = false)
    private String secret;

    public CredentialsSecret() {
        super();
    }

    public CredentialsSecret(String code, String description, String secret) {
        super(code, description);
        this.secret = secret;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CredentialsSecret that = (CredentialsSecret) o;

        return secret != null ? secret.equals(that.secret) : that.secret == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (secret != null ? secret.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CredentialsSecret{" +
                "secret='" + secret + '\'' +
                '}';
    }
}
