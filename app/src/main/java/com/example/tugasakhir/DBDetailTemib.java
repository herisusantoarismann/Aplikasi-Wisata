package com.example.tugasakhir;

public class DBDetailTemib {
    //private variables
    int _id;
    int _image;
    int _id_detail_temib;

    // Empty constructor
    public DBDetailTemib(){

    }
    // constructor
    public DBDetailTemib(int _id_detail_temib, int _image, int _id){
        this._id_detail_temib = _id_detail_temib;
        this._image = _image;
        this._id = _id;
    }

    // constructor
    public DBDetailTemib(int _image, int _id){
        this._image = _image;
        this._id = _id;
    }
    // getting ID Detail Wisata
    public int getIDDetailTemib(){ return this._id_detail_temib; }

    // setting ID Detail Wisata
    public void setIDDetailTemib(int _id_detail_temib){
        this._id_detail_temib = _id_detail_temib;
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
