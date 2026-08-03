package model;

public class User {
    private int id;
    private String name;
    private String email;
    private int cellNumber;

    public User(int id, String name, String email, int cellNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cellNumber = cellNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }
}
