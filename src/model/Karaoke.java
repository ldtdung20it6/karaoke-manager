/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DungLe
 */
public class Karaoke {
    int Stt;
    String SongCode , NameMusic , SingerName , YearOfCreation , Lyrics ;

    public Karaoke() {
    }

    public Karaoke(int Stt, String SongCode, String NameMusic, String SingerName, String YearOfCreation, String Lyrics) {
        this.Stt = Stt;
        this.SongCode = SongCode;
        this.NameMusic = NameMusic;
        this.SingerName = SingerName;
        this.YearOfCreation = YearOfCreation;
        this.Lyrics = Lyrics;
    }

    public Karaoke(String SongCode, String NameMusic, String SingerName, String YearOfCreation, String Lyrics) {
        this.SongCode = SongCode;
        this.NameMusic = NameMusic;
        this.SingerName = SingerName;
        this.YearOfCreation = YearOfCreation;
        this.Lyrics = Lyrics;
    }

    public int getStt() {
        return Stt;
    }

    public void setStt(int Stt) {
        this.Stt = Stt;
    }

    public String getSongCode() {
        return SongCode;
    }

    public void setSongCode(String SongCode) {
        this.SongCode = SongCode;
    }

    public String getNameMusic() {
        return NameMusic;
    }

    public void setNameMusic(String NameMusic) {
        this.NameMusic = NameMusic;
    }

    public String getSingerName() {
        return SingerName;
    }

    public void setSingerName(String SingerName) {
        this.SingerName = SingerName;
    }

    public String getYearOfCreation() {
        return YearOfCreation;
    }

    public void setYearOfCreation(String YearOfCreation) {
        this.YearOfCreation = YearOfCreation;
    }

    public String getLyrics() {
        return Lyrics;
    }

    public void setLyrics(String Lyrics) {
        this.Lyrics = Lyrics;
    }

}