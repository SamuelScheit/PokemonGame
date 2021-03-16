package com.pokemon.game;

public class GameStatus {
    private String nextDialog;
    private boolean startup;
    private GameDialogs dialogs;

    public GameStatus(boolean startup) {
        this.startup = startup;
        this.dialogs = new GameDialogs();
    }

    public boolean isStartup() {
        return startup;
    }

    public void setStartup(boolean startup) {
        this.startup = startup;
    }

    public String getNextDialog() {
        return nextDialog;
    }

    public void triggerIntro() {
        if (isStartup()) {
            nextDialog = this.dialogs.getNextIntroText();
        } else {
            nextDialog = "fehler";
        }


    }
}
