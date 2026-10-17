package com.campus.model;

public class Item {
    private int itemId;
    private String itemName;
    private String category;
    private String description;
    private String location;
    private String status;
    private int userId;

    public Item(int itemId, String itemName, String category, String description, String location, String status, int userId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.description = description;
        this.location = location;
        this.status = status;
        this.userId = userId;
    }

    public int getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public String getStatus() { return status; }
    public int getUserId() { return userId; }
}