package controllers;

public class Purchases {
    int id;
    String medicineName;
    String dealerName;
    String batchNumber;
    String quantity;
    String purchaseDate;
    String purchaseRate;
    String sellingRate;
    String expiryDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseRate() {
        return purchaseRate;
    }

    public void setPurchaseRate(String purchaseRate) {
        this.purchaseRate = purchaseRate;
    }

    public String getSellingRate() {
        return sellingRate;
    }

    public void setSellingRate(String sellingRate) {
        this.sellingRate = sellingRate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Purchases(int id, String medicineName, String dealerName, String batchNumber, String quantity, String purchaseDate, String purchaseRate, String sellingRate, String expiryDate) {
        this.id = id;
        this.medicineName = medicineName;
        this.dealerName = dealerName;
        this.batchNumber = batchNumber;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.purchaseRate = purchaseRate;
        this.sellingRate = sellingRate;
        this.expiryDate = expiryDate;
    }
}
