package models.DTOs;

public class SecretCodeDTO {
    private int secretCode;

    public SecretCodeDTO() {
    }

    public SecretCodeDTO(int secretCode) {
        this.secretCode = secretCode;
    }

    public int getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(int secretCode) {
        this.secretCode = secretCode;
    }
}
