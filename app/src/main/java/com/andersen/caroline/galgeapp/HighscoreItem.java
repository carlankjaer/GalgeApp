package com.andersen.caroline.galgeapp;

public class HighscoreItem {
    private String highscoreNavn;
    private String highscore;

    public HighscoreItem(String highscoreNavn, String highscore) {
        this.highscoreNavn = highscoreNavn;
        this.highscore = highscore;
    }

    public String getHighscoreNavn() {
        return highscoreNavn;
    }

    public String getHighscore() {
        return highscore;
    }
}
