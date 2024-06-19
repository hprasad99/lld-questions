package SPW.entity;

public class User {
    private String id;
    private String name;
    private String emailId;
    private String phone;

    public User(String id, String name, String emailId, String phone) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
