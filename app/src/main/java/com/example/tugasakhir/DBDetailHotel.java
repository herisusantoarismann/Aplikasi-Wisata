package com.example.tugasakhir;

public class DBDetailHotel {
    //private variables
    int _id;
    int _image;
    int _id_detail_hotel;

    // Empty constructor
    public DBDetailHotel(){

    }
    // constructor
    public DBDetailHotel(int _id_detail_hotel, int _image, int _id){
        this._id_detail_hotel = _id_detail_hotel;
        this._image = _image;
        this._id = _id;
    }

    // constructor
    public DBDetailHotel(int _image, int _id){
        this._image = _image;
        this._id = _id;
    }
    // getting ID Detail Wisata
    public int getIDDetailHotel(){
        return this._id_detail_hotel;
    }

    // setting ID Detail Wisata
    public void setIDDetailHotel(int _id_detail_kuliner){
        this._id_detail_hotel = _id_detail_kuliner;
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
