package com.example.tugasakhir;

public class DBTemib {
    //private variables
    int _id;
    String _name;
    int _image;
    String _desc;
    String _address;

    // Empty constructor
    public DBTemib(){

    }
    // constructor
    public DBTemib(int id, String name, int _image, String _desc, String _address){
        this._id = id;
        this._name = name;
        this._image = _image;
        this._desc = _desc;
        this._address = _address;
    }

    // constructor
    public DBTemib(String name, int _image, String _desc, String _address){
        this._name = name;
        this._image = _image;
        this._desc = _desc;
        this._address = _address;
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

    // getting desc
    public String getDesc(){
        return this._desc;
    }

    // setting desc
    public void setDesc(String desc){
        this._desc = desc;
    }

    // getting address
    public String getAddress(){
        return this._address;
    }

    // setting address
    public void setAddress(String address){
        this._address = address;
    }
}
