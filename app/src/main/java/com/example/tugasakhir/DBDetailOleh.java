package com.example.tugasakhir;

public class DBDetailOleh {
    //private variables
    int _id;
    int _image;
    int _id_detail_oleh;

    // Empty constructor
    public DBDetailOleh(){

    }
    // constructor
    public DBDetailOleh(int _id_detail_oleh, int _image, int _id){
        this._id_detail_oleh = _id_detail_oleh;
        this._image = _image;
        this._id = _id;
    }

    // constructor
    public DBDetailOleh(int _image, int _id){
        this._image = _image;
        this._id = _id;
    }
    // getting ID Detail Wisata
    public int getIDDetailOleh(){
        return this._id_detail_oleh;
    }

    // setting ID Detail Wisata
    public void setIDDetailOleh(int _id_detail_oleh){
        this._id_detail_oleh = _id_detail_oleh;
    }

    // getting image
    public int get_image(){
        return this._image;
    }

    // setting image
    public void set_image(int _image){
        this._image = _image;
    }

    // getting ID
    public int getID(){
        return this._id;
    }

    // setting ID
    public void setID(int _id){
        this._id = _id;
    }
}
