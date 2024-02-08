package profiledb;

import java.util.Date;

public class Invoices {
    private int id;
    private String username;
    private String title;
    private Date paymentDate;
    private String expenseDescription;
    private double price;
    private String categoryTitle;
    private String profileUsername;
    private int profileId; // Foreign key reference to user's profile
    private int categoryId; // Foreign key reference to category

    // Get methods

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }


    public Date getPaymentDate() {
        return paymentDate;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public double getPrice() {
        return price;
    }

    public int getProfileId() {
        return profileId;
    }
    public int getCategoryId() {
        return categoryId;
    }
    public String getCategoryTitle() {
        return categoryTitle;
    }
    public String getProfileUsername() {
        return profileUsername;
    }

    // Set methods
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public void setProfileUsername(String profileUsername) {
        this.profileUsername = profileUsername;
    }
}


