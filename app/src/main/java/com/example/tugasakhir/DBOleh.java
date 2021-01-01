package com.example.tugasakhir;

public class DBOleh {
    //private variables
    int _id;
    String _name;
    int _image;
    String _desc;
    String _address;
    String _opening;

    // Empty constructor
    public DBOleh(){

    }
    // constructor
    public DBOleh(int id, String name, int _image, String _desc, String _address, String _opening){
        this._id = id;
        this._name = name;
        this._image = _image;
        this._desc = _desc;
        this._address = _address;
        this._opening = _opening;
    }

    // constructor
    public DBOleh(String name, int _image, String _desc, String _address, String _opening){
        this._name = name;
        this._image = _image;
        this._desc = _desc;
        this._address = _address;
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

    // getting desc
    public String getOpening(){
        return this._opening;
    }

    // setting desc
    public void setOpening(String opening){
        this._opening = opening;
    }
}
