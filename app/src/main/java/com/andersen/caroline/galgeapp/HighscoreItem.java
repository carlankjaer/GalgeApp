package com.andersen.caroline.galgeapp;

public class HighscoreItem {
    private String placering;
    private String highscoreNavn;
    private String highscore;

    public HighscoreItem(String placering, String highscoreNavn, String highscore) {
        this.placering = placering;
        this.highscoreNavn = highscoreNavn;
        this.highscore = highscore;
    }

    public String getPlacering() {
        return placering;
    }

    public String getHighscoreNavn() {
        return highscoreNavn;
    }

    public String getHighscore() {
        return highscore;
    }
}
