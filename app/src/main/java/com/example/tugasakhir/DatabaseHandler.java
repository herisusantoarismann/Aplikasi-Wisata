package com.example.tugasakhir;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Wisata";

    // Table name
    private static final String TABLE_WISATA = "wisata";
    private static final String TABLE_KULINER = "kuliner";
    private static final String TABLE_HOTEL = "hotel";
    private static final String TABLE_TEMIB = "temib";
    private static final String TABLE_OLEH = "oleh";
    private static final String TABLE_DETAIL_WISATA = "detailwisata";
    private static final String TABLE_DETAIL_KULINER = "detailkuliner";
    private static final String TABLE_DETAIL_HOTEL = "detailhotel";
    private static final String TABLE_DETAIL_TEMIB = "detailtemib";
    private static final String TABLE_DETAIL_OLEH = "detailoleh";

    // Table Columns names
    private static final String KEY_ID_WISATA = "id";
    private static final String KEY_NAME_WISATA = "name";
    private static final String KEY_IMAGE_WISATA = "image";
    private static final String KEY_DESC_WISATA = "description";
    private static final String KEY_ADDRESS_WISATA = "address";
    private static final String KEY_TICKET_WISATA = "ticket_price";
    private static final String KEY_ID_KULINER = "id";
    private static final String KEY_NAME_KULINER = "name";
    private static final String KEY_IMAGE_KULINER = "image";
    private static final String KEY_ADDRESS_KULINER = "address";
    private static final String KEY_PRICE_KULINER = "price";
    private static final String KEY_OPENING_KULINER = "openning";
    private static final String KEY_ID_HOTEL = "id";
    private static final String KEY_NAME_HOTEL = "name";
    private static final String KEY_IMAGE_HOTEL= "image";
    private static final String KEY_ADDRESS_HOTEL = "address";
    private static final String KEY_PRICE_HOTEL = "price";
    private static final String KEY_AMENITIES_HOTEL = "amenities";
    private static final String KEY_ID_TEMIB = "id";
    private static final String KEY_NAME_TEMIB = "name";
    private static final String KEY_IMAGE_TEMIB = "image";
    private static final String KEY_DESC_TEMIB = "description";
    private static final String KEY_ADDRESS_TEMIB = "address";
    private static final String KEY_ID_OLEH = "id";
    private static final String KEY_NAME_OLEH = "name";
    private static final String KEY_IMAGE_OLEH = "image";
    private static final String KEY_DESC_OLEH = "description";
    private static final String KEY_ADDRESS_OLEH = "address";
    private static final String KEY_OPENING_OLEH = "opening";
    private static final String KEY_ID_DETAIL_WISATA = "id_wisata_detail";
    private static final String KEY_IMAGE_DETAIL_WISATA = "image";
    private static final String KEY_ID_DETAIL_KULINER = "id_kuliner_detail";
    private static final String KEY_IMAGE_DETAIL_KULINER = "image";
    private static final String KEY_ID_DETAIL_HOTEL = "id_hotel_detail";
    private static final String KEY_IMAGE_DETAIL_HOTEL = "image";
    private static final String KEY_ID_DETAIL_TEMIB = "id_temib_detail";
    private static final String KEY_IMAGE_DETAIL_TEMIB = "image";
    private static final String KEY_ID_DETAIL_OLEH = "id_oleh_detail";
    private static final String KEY_IMAGE_DETAIL_OLEH = "image";

    // Data Wisata
    private static final String[] dataNameWisata = {"Taman Sari", "Malioboro", "Keraton Yogyakarta", "Gembira Loka Zoo"};
    private static final int[] dataImageWisata = {R.drawable.img_taman_sari, R.drawable.img_malioboro, R.drawable.img_keraton, R.drawable.img_gembira_loka};
    private static final String[] dataDescriptionWisata = {"Taman Sari adalah situs bekas taman atau kebun istana Keraton Ngayogyakarta Hadiningrat, yang dapat dibandingkan dengan Kebun Raya Bogor sebagai kebun Istana Bogor. Kebun ini dibangun pada zaman Sultan Hamengku Buwono I pada tahun 1758-1765/9", "Malioboro adalah adalah nama salah satu kawasan jalan dari tiga jalan di Kota Yogyakarta yang membentang dari Tugu Yogyakarta hingga ke perempatan Kantor Pos Yogyakarta. Secara keseluruhan terdiri dari Jalan Margo Utomo, Jalan Malioboro, dan Jalan Margo Mulyo. Jalan ini merupakan poros Garis Imajiner Kraton Yogyakarta.", "Keraton Yogyakarta adalah  istana resmi Kesultanan Ngayogyakarta Hadiningrat yang kini berlokasi di Kota Yogyakarta, Daerah Istimewa Yogyakarta, Indonesia. Walaupun kesultanan tersebut secara resmi telah menjadi bagian Republik Indonesia pada tahun 1950, kompleks bangunan keraton ini masih berfungsi.", "Gembira Loka adalah kebun binatang yang berada di Yogyakarta. Berisi berbagai macam spesies dari belahan dunia, seperti orangutan, gajah asia, simpanse, harimau, dan lain sebagainya. Kebun Binatang Gembira Loka menjadi daya tarik tersendiri bagi para wisatawan Yogyakarta."};
    private static final String[] dataAddressWisata = {"Patehan, Kecamatan Kraton, Kota Yogyakarta", "Jalan Malioboro", "Jl. Rotowijayan Blok No. 1, Panembahan, Kecamatan Kraton, Kota Yogyakarta", "Jl. Kebun Raya No.2, Rejowinangun, Kec. Kotagede, Kota Yogyakarta"};
    private static final String[] dataTiketWisata = {"Rp. 5.000 - Rp. 15.000", "Gratis", "Rp. 5.000 - Rp. 15.000", "Rp. 60.000 - Rp. 75.000"};

    // Data Kuliner
    private static final String[] dataNameKuliner = {"Mie Ayam Bu Tumini", "Gudeg Mbah Lindu Sosrowijayan", "Saoto Bathok Mbah Katro", "Sate Klatak Pak Bari"};
    private static final int[] dataImageKuliner = {R.drawable.img_kuliner_butumini, R.drawable.img_kuliner_mbahlindu, R.drawable.img_kuliner_mbahkatro, R.drawable.img_kuliner_pakbari};
    private static final String[] dataAddressKuliner = {"Jl. Imogiri Tim. No.187, Giwangan, Kec. Umbulharjo, Kota Yogyakarta", "Jl. Sosrowijayan No.30, Sosromenduran, Gedong Tengen, Kota Yogyakarta", "Sambisari, Purwomartani, Kec. Kalasan, Kabupaten Sleman", "Pasar Wonokromo, Jalan Imogiri Timur No.5, Wonokromo, Pleret, Wonokromo II, Wonokromo, Kec. Pleret, Bantul"};
    private static final String[] dataPriceKuliner = {"Rp. 12.000 - Rp.22.000", "Rp. 15.000 - Rp. 25.000", "Rp. 5000", "Rp. 20.000"};
    private static final String[] dataOpeningKuliner = {"Senin - Sabtu, Jam 10.00 WIB - 17.00 WIB", "Setiap hari, Jam 05.00 WIB - 10.00 WIB", "Setiap hari, 06.00 WIB - 15.30 WIB", "Setiap hari, 18.00 WIB - 01.00 WIB"};

    // Data Hotel
    private static final String[] dataNameHotel = {"YATS Colony", "Adhistana Hotel", "Greenhost Boutique Hotel", "Pawon Cokelat Guest House"};
    private static final int[] dataImageHotel = {R.drawable.img_hotel_yatscolony, R.drawable.img_hotel_adhistana, R.drawable.img_hotel_greenhostboutique, R.drawable.img_hotel_pawoncokelat};
    private static final String[] dataAddressHotel = {"Jl. Patangpuluhan No.23, Patangpuluhan, Wirobrajan, Kota Yogyakarta", "Jl. Prawirotaman 2 No.613, Brontokusuman, Kec. Mergangsan, Kota Yogyakarta", "Jl. Prawirotaman 2 No.629, Brontokusuman, Kec. Mergangsan, Kota Yogyakarta", "Jl. Ps. Kembang Gg. 1 No.102, Sosromenduran, Gedong Tengen, Kota Yogyakarta"};
    private static final String[] dataPriceHotel = {"Mulai dari Rp. 600.000", "Mulai dari Rp. 310.000", "Mulai dari Rp. 440.000", "Mulai dari Rp. 319.000"};
    private static final String[] dataAmenitiesHotel = {"Kolam Renang, Sarapan (Gratis), Wi-Fi (Gratis), Tempat Parkir (Gratis)", "Kolam Renang, Sarapan, Wi-Fi (Gratis), Tempat Parkir (Gratis), AC", "Kolam Renang, Sarapan, Wi-Fi (Gratis), Tempat Parkir (Gratis), Spa", "Sarapan (Gratis), Wi-Fi (Gratis), AC"};

    // Data Tempat Ibadah
    private static final String[] dataNameTemib = {"Masjid Syuhada Kotabaru", "Masjid Gedhe Kauman", "Kelenteng Fuk Ling Miau", "Masjid Jogokariyan"};
    private static final int[] dataImageTemib = {R.drawable.img_temib_masjidsyuhadakotabaru, R.drawable.img_temib_masjidgedhekauman, R.drawable.img_temib_kelentengfuklingmiau, R.drawable.img_temib_masjidjogokariyan};
    private static final String[] dataDescriptionTemib = {"Masjid Syuhada adalah sebuah bangunan masjid bersejarah di daerah Kotabaru, Yogyakarta. Bangunan masjid tersebut bernama Syuhada yang dalam Bahasa Indonesia diterjemahkan sebagai pejuang. Masjid tersebut memang menjadi salah satu masjid yang menyimpan nilai sejarah, terutama berkaitan dengan perjuangan kemerdekaan Indonesia.", "Masjid Gedhe Kauman adalah masjid raya Kesultanan Yogyakarta, atau Masjid Besar Yogyakarta, yang terletak di sebelah barat kompleks Alun-alun Utara Kraton Yogyakarta. Masjid Gedhe Kauman dibangun oleh Sri Sultan Hamengku Buwono I bersama Kyai Faqih Ibrahim Diponingrat (penghulu kraton pertama) dan Kyai Wiryokusumo sebagai arsiteknya. Masjid ini dibangun pada hari Ahad Wage, 29 Mei 1773 M atau 6 Rabiulakhir 1187 H.", "Kelenteng Fuk Ling Miau merupakan tempat peribadatan umat agama Kong Hu Cu dan agama Buddha yang berlokasi di DI Yogyakarta. Kelenteng ini berada di bawah naungan Majelis Buddhayana Indonesia dengan nama Vihara Buddha Prabha.", " Masjid Jokokariyan adalah salah satu masjid bersejarah yang berada di Kampung Jogokariyan atau tepatnya di Jalan Jogokariyan, Mantrijeron, Yogyakarta. Lokasi masjid ini juga berdekatan dengan Pondok Pesantren Krapyak[1] yang sama-sama memiliki nilai sejarah panjang, terutama jika dikaitkan dengan keberadaan Keraton Ngayogyakarta Hadiningrat."};
    private static final String[] dataAddressTemib = {"Jl. I Dewa Nyoman Oka No.13, Kotabaru, Kec. Gondokusuman, Kota Yogyakarta", "Alun-Alun Keraton, Jl. Kauman, Ngupasan, Kec. Gondomanan, Kota Yogyakarta", "Jl. Brigjen Katamso No.3, Prawirodirjan, Kec. Gondomanan, Kota Yogyakarta", "Jl. Jogokaryan No.36, Mantrijeron, Kec. Mantrijeron, Kota Yogyakarta"};

    // Data Oleh - Oleh
    private static final String[] dataNameOleh = {"Pasar Beringharjo", "Pasar Senthir", "Pasar Klitikan Pakuncen", "Kasongan"};
    private static final int[] dataImageOleh = {R.drawable.img_oleh_pasarberingharjo, R.drawable.img_oleh_pasarsenthir, R.drawable.img_oleh_pasarklitikanpakuncen, R.drawable.img_oleh_kasongan};
    private static final String[] dataDescriptionOleh = {"Pasar Beringharjo adalah pasar tertua dengan nilai historis dan filosofis yang tidak dapat dipisahkan dengan Kraton Yogyakarta. Beringharjo memiliki makna harafiah hutan pohon beringin yang diharapkan memberikan kesejahteraan bagi warga Yogyakarta. Pasar Beringharjo terletak di Jalan Jenderal Ahmad Yani nomor 16, Yogyakarta.", "Pasar Senthir merupakan pasar loak atau pasar barang bekas. Pasar ini sudah ada sejak puluhan tahun, dahulu para pedagang hanya mengandalkan senthir sebagai penerangan, maka dari itu dinamakan Pasar Senthir. Jika ingin berburu barang-barang kuno yang unik atau barang bekas, Anda dapat langsung menuju Pasar Senthir, jangan lupa untuk menawar dan meneliti barang yang akan dibeli.", "Pasar Klithikan ini pada awalnya merupakan pasar hewan. Dan pada saat ini pasar hewan dipindah ke Ambarketawang Gamping. Dengan berbagai macam pertimbangan pertumbuhan perkotaan,dilihat pasar hewan ini tidak layak berada di tengah kota maka pemerintah kota Yogyakarta terdorong untuk melakukan relokasi pasar tradisional tersebut.", "Kawasan Kasongan sangat terkenal dengan produksi kerajinan gerabah dan keramik. Bisa banget jadi tempat berbelanja yang pas buat mempercantik rumahmu. Kamu bisa menemukan pot, guci, patung, hiasan dinding, furnitur, dan peralatan dapur."};
    private static final String[] dataAddressOleh = {"Jl. Margo Mulyo No.16, Ngupasan, Kec. Gondomanan, Kota Yogyakarta", "Jl. Pabringan No.Selatan, Ngupasan, Kec. Gondomanan, Kota Yogyakarta", "Jl. HOS Cokroaminoto No.34, Pakuncen, Wirobrajan, Kota Yogyakarta", "Jl. Kasongan, Nyemengan, Bangunjiwo, Kecamatan Kasihan, Kab. Bantul"};
    private static final String[] dataOpeningOleh = {"Setiap Hari, 08.30 WIB - 21.00 WIB", "Setiap Hari, 17.30 WIB - 23.00 WIB", "Setiap Hari, 17.30 WIB - 23.00 WIB", "Setiap Hari, 08.00 WIB - 17.00 WIB"};

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String wisata = "CREATE TABLE " + TABLE_WISATA + "("
                + KEY_ID_WISATA + " INTEGER PRIMARY KEY," + KEY_NAME_WISATA + " TEXT,"
                + KEY_IMAGE_WISATA + " BLOB" + ", " + KEY_DESC_WISATA + " TEXT, " + KEY_ADDRESS_WISATA + " TEXT," + KEY_TICKET_WISATA + " TEXT)";
        db.execSQL(wisata);
        String kuliner = "CREATE TABLE " + TABLE_KULINER + "("
                + KEY_ID_KULINER + " INTEGER PRIMARY KEY," + KEY_NAME_KULINER + " TEXT,"
                + KEY_IMAGE_KULINER + " BLOB" + ", " + KEY_ADDRESS_KULINER + " TEXT, " + KEY_PRICE_KULINER + " TEXT," + KEY_OPENING_KULINER + " TEXT)";
        db.execSQL(kuliner);
        String hotel = "CREATE TABLE " + TABLE_HOTEL + "("
                + KEY_ID_HOTEL + " INTEGER PRIMARY KEY," + KEY_NAME_HOTEL + " TEXT,"
                + KEY_IMAGE_HOTEL + " BLOB" + ", " + KEY_ADDRESS_HOTEL + " TEXT, " + KEY_PRICE_HOTEL + " TEXT," + KEY_AMENITIES_HOTEL + " TEXT)";
        db.execSQL(hotel);
        String temib = "CREATE TABLE " + TABLE_TEMIB + "("
                + KEY_ID_TEMIB + " INTEGER PRIMARY KEY," + KEY_NAME_TEMIB + " TEXT,"
                + KEY_IMAGE_TEMIB + " BLOB" + ", " + KEY_DESC_TEMIB + " TEXT, " + KEY_ADDRESS_TEMIB + " TEXT)";
        db.execSQL(temib);
        String oleh = "CREATE TABLE " + TABLE_OLEH + "("
                + KEY_ID_OLEH + " INTEGER PRIMARY KEY," + KEY_NAME_OLEH + " TEXT,"
                + KEY_IMAGE_OLEH + " BLOB" + ", " + KEY_DESC_OLEH + " TEXT, " + KEY_ADDRESS_OLEH + " TEXT," + KEY_OPENING_OLEH + " TEXT)";
        db.execSQL(oleh);
        String wisatadetail = "CREATE TABLE detailwisata (id_wisata_detail INTEGER PRIMARY KEY, image BLOB, id INTEGER, FOREIGN KEY(id) REFERENCES wisata(id));";
        db.execSQL(wisatadetail);
        String kulinerdetail = "CREATE TABLE " + TABLE_DETAIL_KULINER + "(" + KEY_ID_DETAIL_KULINER + " INTEGER PRIMARY KEY, " + KEY_IMAGE_DETAIL_KULINER + " BLOB, " + KEY_ID_KULINER + " INTEGER, FOREIGN KEY(" + KEY_ID_KULINER + ") REFERENCES " + TABLE_KULINER + "(" + KEY_ID_KULINER + "));";
        db.execSQL(kulinerdetail);
        String hoteldetail = "CREATE TABLE " + TABLE_DETAIL_HOTEL + "(" + KEY_ID_DETAIL_HOTEL + " INTEGER PRIMARY KEY, " + KEY_IMAGE_DETAIL_HOTEL + " BLOB, " + KEY_ID_HOTEL + " INTEGER, FOREIGN KEY(" + KEY_ID_HOTEL + ") REFERENCES " + TABLE_HOTEL + "(" + KEY_ID_HOTEL + "));";
        db.execSQL(hoteldetail);
        String temibdetail = "CREATE TABLE " + TABLE_DETAIL_TEMIB + "(" + KEY_ID_DETAIL_TEMIB + " INTEGER PRIMARY KEY, " + KEY_IMAGE_DETAIL_TEMIB + " BLOB, " + KEY_ID_TEMIB + " INTEGER, FOREIGN KEY(" + KEY_ID_TEMIB + ") REFERENCES " + TABLE_TEMIB + "(" + KEY_ID_TEMIB + "));";
        db.execSQL(temibdetail);
        String olehdetail = "CREATE TABLE " + TABLE_DETAIL_OLEH + "(" + KEY_ID_DETAIL_OLEH + " INTEGER PRIMARY KEY, " + KEY_IMAGE_DETAIL_OLEH + " BLOB, " + KEY_ID_OLEH + " INTEGER, FOREIGN KEY(" + KEY_ID_OLEH + ") REFERENCES " + TABLE_OLEH + "(" + KEY_ID_OLEH + "));";
        db.execSQL(olehdetail);

        String insertWisata;
        for (int i = 0; i < dataNameWisata.length; i++) {
            String nameWisata = dataNameWisata[i];
            String descWisata = dataDescriptionWisata[i];
            String addressWisata = dataAddressWisata[i];
            String ticketWisata = dataTiketWisata[i];

            insertWisata = "INSERT INTO " + TABLE_WISATA + " (" + KEY_NAME_WISATA + ", " + KEY_IMAGE_WISATA + ", " + KEY_DESC_WISATA + ", " + KEY_ADDRESS_WISATA + ", " + KEY_TICKET_WISATA + ") VALUES ('" + nameWisata + "', " + dataImageWisata[i] + ", '" + descWisata + "', '" + addressWisata + "', '" + ticketWisata + "');";
            db.execSQL(insertWisata);
        }

        String insertKuliner;
        for (int i = 0; i < dataNameKuliner.length; i++) {
            String nameKuliner = dataNameKuliner[i];
            String addressKuliner = dataAddressKuliner[i];
            String priceKuliner = dataPriceKuliner[i];
            String openingkuliner = dataOpeningKuliner[i];

            insertKuliner = "INSERT INTO " + TABLE_KULINER + " (" + KEY_NAME_KULINER + ", " + KEY_IMAGE_KULINER + ", " + KEY_ADDRESS_KULINER + ", " + KEY_PRICE_KULINER + ", " + KEY_OPENING_KULINER + ") VALUES ('" + nameKuliner + "', " + dataImageKuliner[i] + ", '" + addressKuliner + "', '" + priceKuliner + "', '" + openingkuliner + "');";
            db.execSQL(insertKuliner);
        }

        String insertHotel;
        for (int i = 0; i < dataNameHotel.length; i++) {
            String nameHotel = dataNameHotel[i];
            String addressHotel = dataAddressHotel[i];
            String priceHotel = dataPriceHotel[i];
            String amenitiesHotel = dataAmenitiesHotel[i];

            insertHotel = "INSERT INTO " + TABLE_HOTEL + " (" + KEY_NAME_HOTEL + ", " + KEY_IMAGE_HOTEL + ", " + KEY_ADDRESS_HOTEL + ", " + KEY_PRICE_HOTEL + ", " + KEY_AMENITIES_HOTEL + ") VALUES ('" + nameHotel + "', " + dataImageHotel[i] + ", '" + addressHotel + "', '" + priceHotel + "', '" + amenitiesHotel + "');";
            db.execSQL(insertHotel);
        }

        String insertTemib;
        for (int i = 0; i < dataNameTemib.length; i++) {
            String nameTemib = dataNameTemib[i];
            String descTemib = dataDescriptionTemib[i];
            String addressTemib = dataAddressTemib[i];

            insertTemib = "INSERT INTO " + TABLE_TEMIB + " (" + KEY_NAME_TEMIB + ", " + KEY_IMAGE_TEMIB + ", " + KEY_DESC_TEMIB + ", " + KEY_ADDRESS_TEMIB + ") VALUES ('" + nameTemib + "', " + dataImageTemib[i] + ", '" + descTemib + "', '" + addressTemib + "');";
            db.execSQL(insertTemib);
        }

        String insertOleh;
        for (int i = 0; i < dataNameOleh.length; i++) {
            String nameOleh = dataNameOleh[i];
            String descOleh = dataDescriptionOleh[i];
            String addressOleh = dataAddressOleh[i];
            String openingOleh = dataOpeningOleh[i];

            insertOleh = "INSERT INTO " + TABLE_OLEH + " (" + KEY_NAME_OLEH + ", " + KEY_IMAGE_OLEH + ", " + KEY_DESC_OLEH + ", " + KEY_ADDRESS_OLEH + ", " + KEY_OPENING_OLEH + ") VALUES ('" + nameOleh + "', " + dataImageOleh[i] + ", '" + descOleh + "', '" + addressOleh + "', '" + openingOleh + "');";
            db.execSQL(insertOleh);
        }

        int[] datadetailWisata = dataImageWisata;
        String insertdetailWisata;
        for (int i = 0; i < datadetailWisata.length; i++) {
            for (int j = 0; j < 5; j++) {
                insertdetailWisata = "INSERT INTO " + TABLE_DETAIL_WISATA + " (" + KEY_IMAGE_DETAIL_WISATA + ", " + KEY_ID_WISATA + ") VALUES (" + (datadetailWisata[i] + (j + 1)) + ", " + (i+1) + ");";
                db.execSQL(insertdetailWisata);
            }
        }

        int[] datadetailKuliner = dataImageKuliner;
        String insertdetailKuliner;
        for (int i = 0; i < datadetailKuliner.length; i++) {
            for (int j = 0; j < 5; j++) {
                insertdetailKuliner = "INSERT INTO " + TABLE_DETAIL_KULINER + " (" + KEY_IMAGE_DETAIL_KULINER + ", " + KEY_ID_KULINER + ") VALUES (" + (datadetailKuliner[i] + (j + 1)) + ", " + (i+1) + ");";
                db.execSQL(insertdetailKuliner);
            }
        }

        int[] datadetailHotel = dataImageHotel;
        String insertdetailHotel;
        for (int i = 0; i < datadetailKuliner.length; i++) {
            for (int j = 0; j < 5; j++) {
                insertdetailHotel = "INSERT INTO " + TABLE_DETAIL_HOTEL + " (" + KEY_IMAGE_DETAIL_HOTEL + ", " + KEY_ID_HOTEL + ") VALUES (" + (datadetailHotel[i] + (j + 1)) + ", " + (i+1) + ");";
                db.execSQL(insertdetailHotel);
            }
        }

        int[] datadetailTemib = dataImageTemib;
        String insertdetailTemib;
        for (int i = 0; i < datadetailTemib.length; i++) {
            for (int j = 0; j < 5; j++) {
                insertdetailTemib = "INSERT INTO " + TABLE_DETAIL_TEMIB + " (" + KEY_IMAGE_DETAIL_TEMIB + ", " + KEY_ID_TEMIB + ") VALUES (" + (datadetailTemib[i] + (j + 1)) + ", " + (i+1) + ");";
                db.execSQL(insertdetailTemib);
            }
        }

        int[] datadetailOleh = dataImageOleh;
        String insertdetailOleh;
        for (int i = 0; i < datadetailOleh.length; i++) {
            for (int j = 0; j < 5; j++) {
                insertdetailOleh = "INSERT INTO " + TABLE_DETAIL_OLEH + " (" + KEY_IMAGE_DETAIL_OLEH + ", " + KEY_ID_OLEH + ") VALUES (" + (datadetailOleh[i] + (j + 1)) + ", " + (i+1) + ");";
                db.execSQL(insertdetailOleh);
            }
        }
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WISATA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KULINER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DETAIL_WISATA);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    void addWisata(DBWisata wisata) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_WISATA, wisata.getName());
        values.put(KEY_IMAGE_WISATA, wisata.get_image());
        values.put(KEY_DESC_WISATA, wisata.getDesc());
        values.put(KEY_ADDRESS_WISATA, wisata.getAddress());
        values.put(KEY_TICKET_WISATA, wisata.getTicket());

        db.insert(TABLE_WISATA, null, values);
        db.close();
    }

    DBWisata getWisata(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_WISATA, new String[]{KEY_ID_WISATA,
                        KEY_NAME_WISATA, KEY_IMAGE_WISATA, KEY_DESC_WISATA, KEY_ADDRESS_WISATA, KEY_TICKET_WISATA}, KEY_ID_WISATA + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DBWisata wisata = new DBWisata(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
        return wisata;
    }

    public List<DBWisata> getAllWisata() {
        List<DBWisata> wisataList = new ArrayList<DBWisata>();
        String selectQuery = "SELECT  * FROM " + TABLE_WISATA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBWisata wisata = new DBWisata();
                wisata.setID(Integer.parseInt(cursor.getString(0)));
                wisata.setName(cursor.getString(1));
                wisata.set_image(cursor.getInt(2));
                wisata.setDesc(cursor.getString(3));
                wisata.setAddress(cursor.getString(4));
                wisata.setTicket(cursor.getString(5));

                wisataList.add(wisata);
            } while (cursor.moveToNext());
        }

        return wisataList;
    }

    public int updateWisata(DBWisata wisata) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_WISATA, wisata.getName());
        values.put(KEY_IMAGE_WISATA, wisata.get_image());
        values.put(KEY_DESC_WISATA, wisata.getDesc());
        values.put(KEY_ADDRESS_WISATA, wisata.getAddress());
        values.put(KEY_TICKET_WISATA, wisata.getTicket());

        return db.update(TABLE_WISATA, values, KEY_ID_WISATA + " = ?",
                new String[]{String.valueOf(wisata.getID())});
    }

    public void deleteWisata(DBWisata wisata) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_WISATA, KEY_ID_WISATA + " = ?",
                new String[]{String.valueOf(wisata.getID())});
        db.close();
    }


    public int getWisataCount() {
        String countQuery = "SELECT  * FROM " + TABLE_WISATA;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }

    void addKuliner(DBKuliner kuliner) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_KULINER, kuliner.getName());
        values.put(KEY_IMAGE_KULINER, kuliner.get_image());

        // Inserting Row
        db.insert(TABLE_KULINER, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    DBKuliner getKuliner(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_KULINER, new String[]{KEY_ID_KULINER,
                        KEY_NAME_KULINER, KEY_IMAGE_KULINER, KEY_ADDRESS_KULINER, KEY_PRICE_KULINER, KEY_OPENING_KULINER}, KEY_ID_KULINER + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DBKuliner kuliner = new DBKuliner(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
        // return contact
        return kuliner;
    }

    public List<DBKuliner> getAllKuliner() {
        List<DBKuliner> kulinerList = new ArrayList<DBKuliner>();
        String selectQuery = "SELECT  * FROM " + TABLE_KULINER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBKuliner kuliner = new DBKuliner();
                kuliner.setID(Integer.parseInt(cursor.getString(0)));
                kuliner.setName(cursor.getString(1));
                kuliner.set_image(cursor.getInt(2));
                kuliner.setAddress(cursor.getString(3));
                kuliner.setPrice(cursor.getString(4));
                kuliner.setOpening(cursor.getString(5));

                kulinerList.add(kuliner);
            } while (cursor.moveToNext());
        }

        return kulinerList;
    }

    // Updating single contact
    public int updateKuliner(DBKuliner kuliner) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_KULINER, kuliner.getName());
        values.put(KEY_IMAGE_KULINER, kuliner.get_image());

        // updating row
        return db.update(TABLE_KULINER, values, KEY_ID_KULINER + " = ?",
                new String[]{String.valueOf(kuliner.getID())});
    }

//    // Deleting single contact
//    public void deleteKuliner(Contact contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_KULINER, KEY_ID_KULINER + " = ?",
//                new String[]{String.valueOf(contact.getID())});
//        db.close();
//    }


    // Getting contacts Count
    public int getKulinerCount() {
        String countQuery = "SELECT  * FROM " + TABLE_KULINER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    void addHotel(DBHotel hotel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_HOTEL, hotel.getName());
        values.put(KEY_IMAGE_HOTEL, hotel.get_image());
        values.put(KEY_ADDRESS_HOTEL, hotel.getAddress());
        values.put(KEY_PRICE_HOTEL, hotel.getPrice());
        values.put(KEY_AMENITIES_HOTEL, hotel.getAmenities());

        db.insert(TABLE_HOTEL, null, values);
        db.close();
    }

    DBHotel getHotel(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_HOTEL, new String[]{KEY_ID_HOTEL,
                        KEY_NAME_HOTEL, KEY_IMAGE_HOTEL, KEY_ADDRESS_HOTEL, KEY_PRICE_HOTEL, KEY_AMENITIES_HOTEL}, KEY_ID_HOTEL + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DBHotel wisata = new DBHotel(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
        return wisata;
    }

    public List<DBHotel> getAllHotel() {
        List<DBHotel> hotelList = new ArrayList<DBHotel>();
        String selectQuery = "SELECT  * FROM " + TABLE_HOTEL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBHotel hotel = new DBHotel();
                hotel.setID(Integer.parseInt(cursor.getString(0)));
                hotel.setName(cursor.getString(1));
                hotel.set_image(cursor.getInt(2));
                hotel.setAddress(cursor.getString(3));
                hotel.setPrice(cursor.getString(4));
                hotel.setAmenities(cursor.getString(5));

                hotelList.add(hotel);
            } while (cursor.moveToNext());
        }

        return hotelList;
    }

    public int updateHotel(DBHotel hotel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_HOTEL, hotel.getName());
        values.put(KEY_IMAGE_HOTEL, hotel.get_image());
        values.put(KEY_ADDRESS_WISATA, hotel.getAddress());
        values.put(KEY_PRICE_HOTEL, hotel.getPrice());
        values.put(KEY_AMENITIES_HOTEL, hotel.getAmenities());

        return db.update(TABLE_HOTEL, values, KEY_ID_HOTEL + " = ?",
                new String[]{String.valueOf(hotel.getID())});
    }

    public void deleteHotel(DBHotel hotel) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_HOTEL, KEY_ID_HOTEL + " = ?",
                new String[]{String.valueOf(hotel.getID())});
        db.close();
    }


    public int getHotelCount() {
        String countQuery = "SELECT  * FROM " + TABLE_HOTEL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }

    void addTemib(DBTemib temib) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_TEMIB, temib.getName());
        values.put(KEY_IMAGE_TEMIB, temib.get_image());
        values.put(KEY_DESC_TEMIB, temib.getDesc());
        values.put(KEY_ADDRESS_TEMIB, temib.getAddress());

        db.insert(TABLE_TEMIB, null, values);
        db.close();
    }

    DBTemib getTemib(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_TEMIB, new String[]{KEY_ID_TEMIB,
                        KEY_NAME_TEMIB, KEY_IMAGE_TEMIB, KEY_DESC_TEMIB, KEY_ADDRESS_TEMIB}, KEY_ID_TEMIB + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DBTemib temib = new DBTemib(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4));
        return temib;
    }

    public List<DBTemib> getAllTemib() {
        List<DBTemib> temibList = new ArrayList<DBTemib>();
        String selectQuery = "SELECT  * FROM " + TABLE_TEMIB;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBTemib temib = new DBTemib();
                temib.setID(Integer.parseInt(cursor.getString(0)));
                temib.setName(cursor.getString(1));
                temib.set_image(cursor.getInt(2));
                temib.setDesc(cursor.getString(3));
                temib.setAddress(cursor.getString(4));

                temibList.add(temib);
            } while (cursor.moveToNext());
        }

        return temibList;
    }

    public int updateTemib(DBTemib temib) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_TEMIB, temib.getName());
        values.put(KEY_IMAGE_TEMIB, temib.get_image());
        values.put(KEY_DESC_TEMIB, temib.getDesc());
        values.put(KEY_ADDRESS_TEMIB, temib.getAddress());

        return db.update(TABLE_TEMIB, values, KEY_ID_TEMIB + " = ?",
                new String[]{String.valueOf(temib.getID())});
    }

    public void deleteTemib(DBTemib temib) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TEMIB, KEY_ID_TEMIB + " = ?",
                new String[]{String.valueOf(temib.getID())});
        db.close();
    }


    public int getTemibCount() {
        String countQuery = "SELECT  * FROM " + TABLE_TEMIB;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }

    void addOleh(DBOleh oleh) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_OLEH, oleh.getName());
        values.put(KEY_IMAGE_OLEH, oleh.get_image());
        values.put(KEY_DESC_OLEH, oleh.getDesc());
        values.put(KEY_ADDRESS_OLEH, oleh.getAddress());
        values.put(KEY_OPENING_OLEH, oleh.getOpening());

        db.insert(TABLE_OLEH, null, values);
        db.close();
    }

    DBOleh getOleh(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_OLEH, new String[]{KEY_ID_OLEH,
                        KEY_NAME_OLEH, KEY_IMAGE_OLEH, KEY_DESC_OLEH, KEY_ADDRESS_OLEH, KEY_OPENING_OLEH}, KEY_ID_OLEH + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DBOleh oleh = new DBOleh(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
        return oleh;
    }

    public List<DBOleh> getAllOleh() {
        List<DBOleh> olehList = new ArrayList<DBOleh>();
        String selectQuery = "SELECT  * FROM " + TABLE_OLEH;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBOleh oleh = new DBOleh();
                oleh.setID(Integer.parseInt(cursor.getString(0)));
                oleh.setName(cursor.getString(1));
                oleh.set_image(cursor.getInt(2));
                oleh.setDesc(cursor.getString(3));
                oleh.setAddress(cursor.getString(4));
                oleh.setOpening(cursor.getString(5));

                olehList.add(oleh);
            } while (cursor.moveToNext());
        }

        return olehList;
    }

    public int updateOleh(DBOleh oleh) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_OLEH, oleh.getName());
        values.put(KEY_IMAGE_OLEH, oleh.get_image());
        values.put(KEY_DESC_OLEH, oleh.getDesc());
        values.put(KEY_ADDRESS_OLEH, oleh.getAddress());
        values.put(KEY_OPENING_OLEH, oleh.getOpening());

        return db.update(TABLE_OLEH, values, KEY_ID_OLEH + " = ?",
                new String[]{String.valueOf(oleh.getID())});
    }

    public void deleteOleh(DBOleh oleh) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_OLEH, KEY_ID_OLEH + " = ?",
                new String[]{String.valueOf(oleh.getID())});
        db.close();
    }


    public int getOlehCount() {
        String countQuery = "SELECT  * FROM " + TABLE_OLEH;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }

    void addDetailWisata(DBDetailWisata detailWisata) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IMAGE_DETAIL_WISATA, detailWisata.get_image());
        values.put(KEY_ID_WISATA, detailWisata.getID());

        db.insert(TABLE_DETAIL_WISATA, null, values);
        db.close();
    }

    DBDetailWisata getDetailWisata(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DETAIL_WISATA, new String[]{KEY_ID_DETAIL_WISATA,
                        KEY_IMAGE_DETAIL_WISATA, KEY_ID_WISATA}, KEY_ID_DETAIL_WISATA + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DBDetailWisata detailWisata = new DBDetailWisata(Integer.parseInt(cursor.getString(0)),
                cursor.getInt(1), cursor.getInt(2));
        return detailWisata;
    }

    public List<DBDetailWisata> getAllDetailWisata() {
        List<DBDetailWisata> detailWisataList = new ArrayList<DBDetailWisata>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_DETAIL_WISATA;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBDetailWisata detailWisata = new DBDetailWisata();
                detailWisata.setIDDetailWisata(Integer.parseInt(cursor.getString(0)));
                detailWisata.set_image(cursor.getInt(2));
                detailWisata.setID(cursor.getInt(3));

                detailWisataList.add(detailWisata);
            } while (cursor.moveToNext());
        }

        return detailWisataList;
    }

//    public int updateWisata(DBWisata wisata) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME_WISATA, wisata.getName());
//        values.put(KEY_IMAGE_WISATA, wisata.get_image());
//        values.put(KEY_DESC_WISATA, wisata.getDesc());
//        values.put(KEY_ADDRESS_WISATA, wisata.getAddress());
//        values.put(KEY_TICKET_WISATA, wisata.getTicket());
//
//        return db.update(TABLE_WISATA, values, KEY_ID_WISATA + " = ?",
//                new String[]{String.valueOf(wisata.getID())});
//    }

//    public void deleteWisata(DBWisata wisata) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_WISATA, KEY_ID_WISATA + " = ?",
//                new String[]{String.valueOf(wisata.getID())});
//        db.close();
//    }


    public int getDetailWisataCount(int id) {
        String countQuery = "SELECT  * FROM " + TABLE_DETAIL_WISATA + " WHERE id = " + id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }

    public List<DBDetailWisata> getDetailWisataImage(int id) {
        List<DBDetailWisata> detailWisataList = new ArrayList<DBDetailWisata>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_DETAIL_WISATA + " WHERE id = " + id;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBDetailWisata detailWisata = new DBDetailWisata();
                detailWisata.setIDDetailWisata(Integer.parseInt(cursor.getString(0)));
                detailWisata.set_image(cursor.getInt(1));
                detailWisata.setID(cursor.getInt(2));

                detailWisataList.add(detailWisata);
            } while (cursor.moveToNext());
        }

        return detailWisataList;
    }

    void addDetailKuliner(DBDetailKuliner detailKuliner) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IMAGE_DETAIL_KULINER, detailKuliner.get_image());
        values.put(KEY_ID_KULINER, detailKuliner.getID());

        db.insert(TABLE_DETAIL_KULINER, null, values);
        db.close();
    }

    DBDetailKuliner getDetailKuliner(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DETAIL_KULINER, new String[]{KEY_ID_DETAIL_KULINER,
                        KEY_IMAGE_DETAIL_KULINER, KEY_ID_KULINER}, KEY_ID_DETAIL_KULINER + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DBDetailKuliner detailKuliner = new DBDetailKuliner(Integer.parseInt(cursor.getString(0)),
                cursor.getInt(1), cursor.getInt(2));
        return detailKuliner;
    }

    public List<DBDetailKuliner> getAllDetailKuliner() {
        List<DBDetailKuliner> detailKulinerList = new ArrayList<DBDetailKuliner>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_DETAIL_KULINER;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBDetailKuliner detailKuliner = new DBDetailKuliner();
                detailKuliner.setIDDetailKuliner(Integer.parseInt(cursor.getString(0)));
                detailKuliner.set_image(cursor.getInt(2));
                detailKuliner.setID(cursor.getInt(3));

                detailKulinerList.add(detailKuliner);
            } while (cursor.moveToNext());
        }

        return detailKulinerList;
    }

//    public int updateWisata(DBWisata wisata) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME_WISATA, wisata.getName());
//        values.put(KEY_IMAGE_WISATA, wisata.get_image());
//        values.put(KEY_DESC_WISATA, wisata.getDesc());
//        values.put(KEY_ADDRESS_WISATA, wisata.getAddress());
//        values.put(KEY_TICKET_WISATA, wisata.getTicket());
//
//        return db.update(TABLE_WISATA, values, KEY_ID_WISATA + " = ?",
//                new String[]{String.valueOf(wisata.getID())});
//    }

//    public void deleteWisata(DBWisata wisata) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_WISATA, KEY_ID_WISATA + " = ?",
//                new String[]{String.valueOf(wisata.getID())});
//        db.close();
//    }


    public int getDetailKulinerCount(int id) {
        String countQuery = "SELECT  * FROM " + TABLE_DETAIL_KULINER + " WHERE id = " + id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }

    public List<DBDetailKuliner> getDetailKulinerImage(int id) {
        List<DBDetailKuliner> detailKulinerList = new ArrayList<DBDetailKuliner>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_DETAIL_KULINER + " WHERE id = " + id;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBDetailKuliner detailKuliner = new DBDetailKuliner();
                detailKuliner.setIDDetailKuliner(Integer.parseInt(cursor.getString(0)));
                detailKuliner.set_image(cursor.getInt(1));
                detailKuliner.setID(cursor.getInt(2));

                detailKulinerList.add(detailKuliner);
            } while (cursor.moveToNext());
        }

        return detailKulinerList;
    }

    void addDetailHotel(DBDetailHotel detailHotel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IMAGE_DETAIL_HOTEL, detailHotel.get_image());
        values.put(KEY_ID_HOTEL, detailHotel.getID());

        db.insert(TABLE_DETAIL_HOTEL, null, values);
        db.close();
    }

    DBDetailHotel getDetailHotel(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DETAIL_HOTEL, new String[]{KEY_ID_DETAIL_HOTEL,
                        KEY_IMAGE_DETAIL_HOTEL, KEY_ID_HOTEL}, KEY_ID_DETAIL_HOTEL + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DBDetailHotel detailHotel = new DBDetailHotel(Integer.parseInt(cursor.getString(0)),
                cursor.getInt(1), cursor.getInt(2));
        return detailHotel;
    }

    public List<DBDetailHotel> getAllDetailHotel() {
        List<DBDetailHotel> detailHotelList = new ArrayList<DBDetailHotel>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_DETAIL_HOTEL;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBDetailHotel detailHotel = new DBDetailHotel();
                detailHotel.setIDDetailHotel(Integer.parseInt(cursor.getString(0)));
                detailHotel.set_image(cursor.getInt(2));
                detailHotel.setID(cursor.getInt(3));

                detailHotelList.add(detailHotel);
            } while (cursor.moveToNext());
        }

        return detailHotelList;
    }

//    public int updateWisata(DBWisata wisata) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME_WISATA, wisata.getName());
//        values.put(KEY_IMAGE_WISATA, wisata.get_image());
//        values.put(KEY_DESC_WISATA, wisata.getDesc());
//        values.put(KEY_ADDRESS_WISATA, wisata.getAddress());
//        values.put(KEY_TICKET_WISATA, wisata.getTicket());
//
//        return db.update(TABLE_WISATA, values, KEY_ID_WISATA + " = ?",
//                new String[]{String.valueOf(wisata.getID())});
//    }

//    public void deleteWisata(DBWisata wisata) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_WISATA, KEY_ID_WISATA + " = ?",
//                new String[]{String.valueOf(wisata.getID())});
//        db.close();
//    }


    public int getDetailHotelCount(int id) {
        String countQuery = "SELECT  * FROM " + TABLE_DETAIL_HOTEL + " WHERE id = " + id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }

    public List<DBDetailHotel> getDetailHotelImage(int id) {
        List<DBDetailHotel> detailHotelList = new ArrayList<DBDetailHotel>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_DETAIL_HOTEL + " WHERE id = " + id;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBDetailHotel detailHotel = new DBDetailHotel();
                detailHotel.setIDDetailHotel(Integer.parseInt(cursor.getString(0)));
                detailHotel.set_image(cursor.getInt(1));
                detailHotel.setID(cursor.getInt(2));

                detailHotelList.add(detailHotel);
            } while (cursor.moveToNext());
        }

        return detailHotelList;
    }

    void addTemibDetail(DBDetailTemib detailTemib) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IMAGE_DETAIL_TEMIB, detailTemib.get_image());
        values.put(KEY_ID_TEMIB, detailTemib.getID());

        db.insert(TABLE_DETAIL_TEMIB, null, values);
        db.close();
    }

    DBDetailTemib getDetailTemib(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DETAIL_TEMIB, new String[]{KEY_ID_DETAIL_TEMIB,
                        KEY_IMAGE_DETAIL_TEMIB, KEY_ID_TEMIB}, KEY_ID_DETAIL_TEMIB + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DBDetailTemib detailTemib = new DBDetailTemib(Integer.parseInt(cursor.getString(0)),
                cursor.getInt(1), cursor.getInt(2));
        return detailTemib;
    }

    public List<DBDetailTemib> getAllDetailTemib() {
        List<DBDetailTemib> detailTemibList = new ArrayList<DBDetailTemib>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_DETAIL_TEMIB;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBDetailTemib detailTemib = new DBDetailTemib();
                detailTemib.setIDDetailTemib(Integer.parseInt(cursor.getString(0)));
                detailTemib.set_image(cursor.getInt(2));
                detailTemib.setID(cursor.getInt(3));

                detailTemibList.add(detailTemib);
            } while (cursor.moveToNext());
        }

        return detailTemibList;
    }

//    public int updateWisata(DBWisata wisata) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME_WISATA, wisata.getName());
//        values.put(KEY_IMAGE_WISATA, wisata.get_image());
//        values.put(KEY_DESC_WISATA, wisata.getDesc());
//        values.put(KEY_ADDRESS_WISATA, wisata.getAddress());
//        values.put(KEY_TICKET_WISATA, wisata.getTicket());
//
//        return db.update(TABLE_WISATA, values, KEY_ID_WISATA + " = ?",
//                new String[]{String.valueOf(wisata.getID())});
//    }

//    public void deleteWisata(DBWisata wisata) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_WISATA, KEY_ID_WISATA + " = ?",
//                new String[]{String.valueOf(wisata.getID())});
//        db.close();
//    }


    public int getDetailTemibCount(int id) {
        String countQuery = "SELECT  * FROM " + TABLE_DETAIL_TEMIB + " WHERE id = " + id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }

    public List<DBDetailTemib> getDetailTemibImage(int id) {
        List<DBDetailTemib> detailTemibList = new ArrayList<DBDetailTemib>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_DETAIL_TEMIB + " WHERE id = " + id;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBDetailTemib detailTemib = new DBDetailTemib();
                detailTemib.setIDDetailTemib(Integer.parseInt(cursor.getString(0)));
                detailTemib.set_image(cursor.getInt(1));
                detailTemib.setID(cursor.getInt(2));

                detailTemibList.add(detailTemib);
            } while (cursor.moveToNext());
        }

        return detailTemibList;
    }

    void addDetailOleh(DBDetailOleh detailOleh) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IMAGE_DETAIL_OLEH, detailOleh.get_image());
        values.put(KEY_ID_OLEH, detailOleh.getID());

        db.insert(TABLE_DETAIL_OLEH, null, values);
        db.close();
    }

    DBDetailOleh getDetailOleh(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DETAIL_OLEH, new String[]{KEY_ID_DETAIL_OLEH,
                        KEY_IMAGE_DETAIL_OLEH, KEY_ID_OLEH}, KEY_ID_DETAIL_OLEH + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        DBDetailOleh detailOleh = new DBDetailOleh(Integer.parseInt(cursor.getString(0)),
                cursor.getInt(1), cursor.getInt(2));
        return detailOleh;
    }

    public List<DBDetailOleh> getAllDetailOleh() {
        List<DBDetailOleh> detailOlehList = new ArrayList<DBDetailOleh>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_DETAIL_OLEH;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBDetailOleh detailOleh = new DBDetailOleh();
                detailOleh.setIDDetailOleh(Integer.parseInt(cursor.getString(0)));
                detailOleh.set_image(cursor.getInt(2));
                detailOleh.setID(cursor.getInt(3));

                detailOlehList.add(detailOleh);
            } while (cursor.moveToNext());
        }

        return detailOlehList;
    }

//    public int updateWisata(DBWisata wisata) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME_WISATA, wisata.getName());
//        values.put(KEY_IMAGE_WISATA, wisata.get_image());
//        values.put(KEY_DESC_WISATA, wisata.getDesc());
//        values.put(KEY_ADDRESS_WISATA, wisata.getAddress());
//        values.put(KEY_TICKET_WISATA, wisata.getTicket());
//
//        return db.update(TABLE_WISATA, values, KEY_ID_WISATA + " = ?",
//                new String[]{String.valueOf(wisata.getID())});
//    }

//    public void deleteWisata(DBWisata wisata) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_WISATA, KEY_ID_WISATA + " = ?",
//                new String[]{String.valueOf(wisata.getID())});
//        db.close();
//    }


    public int getDetailOlehCount(int id) {
        String countQuery = "SELECT  * FROM " + TABLE_DETAIL_OLEH + " WHERE id = " + id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }

    public List<DBDetailOleh> getDetailOlehImage(int id) {
        List<DBDetailOleh> detailOlehList = new ArrayList<DBDetailOleh>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_DETAIL_OLEH+ " WHERE id = " + id;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBDetailOleh detailOleh = new DBDetailOleh();
                detailOleh.setIDDetailOleh(Integer.parseInt(cursor.getString(0)));
                detailOleh.set_image(cursor.getInt(1));
                detailOleh.setID(cursor.getInt(2));

                detailOlehList.add(detailOleh);
            } while (cursor.moveToNext());
        }

        return detailOlehList;
    }
}
