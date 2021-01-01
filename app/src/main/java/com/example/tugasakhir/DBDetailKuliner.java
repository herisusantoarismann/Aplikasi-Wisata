package com.example.tugasakhir;

public class DBDetailKuliner {
    //private variables
    int _id;
    int _image;
    int _id_detail_kuliner;

    // Empty constructor
    public DBDetailKuliner(){

    }
    // constructor
    public DBDetailKuliner(int _id_detail_kuliner, int _image, int _id){
        this._id_detail_kuliner = _id_detail_kuliner;
        this._image = _image;
        this._id = _id;
    }

    // constructor
    public DBDetailKuliner(int _image, int _id){
        this._image = _image;
        this._id = _id;
    }
    // getting ID Detail Wisata
    public int getIDDetailKuliner(){
        return this._id_detail_kuliner;
    }

    // setting ID Detail Wisata
    public void setIDDetailKuliner(int _id_detail_kuliner){
        this._id_detail_kuliner = _id_detail_kuliner;
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
