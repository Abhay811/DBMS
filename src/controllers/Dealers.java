package controllers;

public class Dealers  {
    int id;
    String dealerName;
    String dealerContact;
    String dealerAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDealerContact() {
        return dealerContact;
    }

    public void setDealerContact(String dealerContact) {
        this.dealerContact = dealerContact;
    }

    public String getDealerAddress() {
        return dealerAddress;
    }

    public void setDealerAddress(String dealerAddress) {
        this.dealerAddress = dealerAddress;
    }

    public Dealers(int id, String dealerName, String dealerContact, String dealerAddress) {
        this.id = id;
        this.dealerName = dealerName;
        this.dealerContact = dealerContact;
        this.dealerAddress = dealerAddress;
    }
}
