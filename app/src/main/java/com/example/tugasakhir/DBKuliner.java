package com.example.tugasakhir;

public class DBKuliner {
    //private variables
    int _id;
    String _name;
    int _image;
    String _address;
    String _price;
    String _opening;

    // Empty constructor
    public DBKuliner(){

    }
    // constructor
    public DBKuliner(int id, String name, int _image, String _address, String _price, String _opening){
        this._id = id;
        this._name = name;
        this._image = _image;
        this._address = _address;
        this._price = _price;
        this._opening = _opening;
    }

    // constructor
    public DBKuliner(String name, int _image, String _address, String _price, String _opening){
        this._name = name;
        this._image = _image;
        this._address = _address;
        this._price = _price;
        this._opening = _opening;
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

    // getting opening
    public String getOpening(){
        return this._opening;
    }

    // setting opening
    public void setOpening(String opening){ this._opening = opening;
    }
}
