package com.example.tugasakhir;

public class DBHotel {
    //private variables
    int _id;
    String _name;
    int _image;
    String _address;
    String _price;
    String _opening;
    String _amenities;

    // Empty constructor
    public DBHotel(){

    }
    // constructor
    public DBHotel(int id, String name, int _image, String _address, String _price,  String _amenities){
        this._id = id;
        this._name = name;
        this._image = _image;
        this._address = _address;
        this._price = _price;
        this._amenities = _amenities;
    }

    // constructor
    public DBHotel(String name, int _image, String _address, String _price,  String _amenities){
        this._name = name;
        this._image = _image;
        this._address = _address;
        this._price = _price;
        this._amenities = _amenities;
    }

    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting image
    public int get_image(){
        return this._image;
    }

    // setting image
    public void set_image(int _image){
        this._image = _image;
    }

    // getting address
    public String getAddress(){
        return this._address;
    }

    // setting address
    public void setAddress(String address){
        this._address = address;
    }

    // getting price
    public String getPrice(){
        return this._price;
    }

    // setting price
    public void setPrice(String price){
        this._price = price;
    }

    // getting amenities
    public String getAmenities(){
        return this._amenities;
    }

    // setting amenities
    public void setAmenities(String amenities){ this._amenities = amenities;
    }
}
