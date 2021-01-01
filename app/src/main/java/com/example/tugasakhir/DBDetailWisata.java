package com.example.tugasakhir;

public class DBDetailWisata {
    //private variables
    int _id;
    int _image;
    int _id_detail_wisata;

    // Empty constructor
    public DBDetailWisata(){

    }
    // constructor
    public DBDetailWisata(int _id_detail_wisata, int _image, int _id){
        this._id_detail_wisata = _id_detail_wisata;
        this._image = _image;
        this._id = _id;
    }

    // constructor
    public DBDetailWisata(int _image, int _id){
        this._image = _image;
        this._id = _id;
    }
    // getting ID Detail Wisata
    public int getIDDetailWisata(){
        return this._id_detail_wisata;
    }

    // setting ID Detail Wisata
    public void setIDDetailWisata(int _id_detail_wisata){
        this._id_detail_wisata = _id_detail_wisata;
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
