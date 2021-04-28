package com.example.myapplicationiipertemuan9;

import java.util.*;

public class HeroDatabase {
    private static String[] heroName = {"Keqing", "Venti", "Xiao", "Bennett", "Zhongli", "Chongyun", "Xinqiu", "Tartaglia(Childe)", "Albedo", "Hu Tao", "Diluc"};
    private static String[] heroSummary = {"Yuheng dari Liyue Qixing, dia punya banyak hal yang ingin dikatakan mengenal Rex Lapis yang memerintah Liyue dan pada kenyataannya, para Dewa mengagumi orang-orang sepertinya.",
            "Salah satu penyair Mondstatd yang bebas berkeliling di antara lorong-lorong di Mondstadt.", "Yaksha, sesosok makhluk abadi yang juga memiliki julukan 'Conqueror Of Demons' atau 'Guardian Yaksha'.",
            "Seorang Petualang yang berbaik hati, tetapi kerap dihantui oleh nasib yang tidak mujur.", "Seseorang tamu misterius yang diundang Wangsheng Funeral Parlor, memiliki pengetahuan mendalam akan banyak hal.",
            "Anak muda pewaris klan pembasmi iblis, Dia telah melakukan segalanya yang bisa dia lakukan untuk menahan 'Luapan Energi yang' yang ada dalam dirinya.",
            "Seorang Pria Muda yang membawa sebilah pedang panjang, sering terlihat di kios buku. Memiliki hati mulia yang menjunjung tinggi keadilan dan kebenaran.", "Anggota ke-11 dari Eleven Harbingers, juga dikenal dengan nama 'Childe'. Ketenaran namanya saja dapat menghantar ketakutan di medan perang.", "Seorang jenius yang dikenal dengan Kreideprinz, dia adalah Kepala Alkemis dan kapter Tim Investigasi Knights Of Favonius." ,
            "Master ke-77 Wangsheng Funeral Parlor. Dia mengambil ahli bisnis ini di umur yang cukup muda.", "Pemilik dari kerajaan kilang anggur di Mondstadt, Kekayaan, ketenaran, dan kekuatannya diakui oleh semua orang."};
    private static String[] herobirthday = {"20 November", "16 Juni", "17 April", "29 Februari", "31 Desember", "7 September","9 Oktober", "20 Juli", "13 September", "15 Juli", "30 April"};
    private static String[] heroaffiliates = {"Liyue Qixing", "Mondstadt", "Liyue Adeptus", "Adventurers' Guild", "Liyue Harbor", "Liyue Harbor", "Feiyun Commerce Guild", "Fatui", "Knights Of Favonius", "Wangsheng Funeral Parlor", "Dawn Winery"};
    private static String[] heroconstellation = {"Trulla Cementarii", "Carmen Dei", "Alatus Nemeseos", "Rola Calamitas", "Lapis Dei", "Nubis Caesor", "Fabulae Textile", "Monoceros Caeli", "Princeps Cretaceus", "Papilio Charontis", "Noctua"};
    private static String[] herovision = {"Electro", "Anemo", "Anemo", "Pyro", "Geo", "Cryo", "Hydro", "Hydro", "Geo", "Pyro", "Pyro"};
    private static int [] photo = {
            R.drawable.lol1,
            R.drawable.venti,
            R.drawable.xiao,
            R.drawable.bennett,
            R.drawable.zhongli,
            R.drawable.chongyun,
            R.drawable.xinqiu,
            R.drawable.childe,
            R.drawable.albedo,
            R.drawable.hutao,
            R.drawable.diluc};

    static ArrayList<Hero> getListData(){
        ArrayList<Hero> list = new ArrayList<>();
        for (int i = 0; i < heroName.length; i++) {
            Hero hero = new Hero();
            hero.setName(heroName[i]);
            hero.setSummary(heroSummary[i]);
            hero.setPhoto(photo[i]);
            hero.setBirthday(herobirthday[i]);
            hero.setAffiliates(heroaffiliates[i]);
            hero.setVision(herovision[i]);
            hero.setConstellation(heroconstellation[i]);
            list.add(hero);
        }
        return list;
    }
    static Hero getData(int i){
            Hero hero = new Hero();
            hero.setName(heroName[i]);
            hero.setSummary(heroSummary[i]);
            hero.setPhoto(photo[i]);
            hero.setBirthday(herobirthday[i]);
            return hero;
    }

}

