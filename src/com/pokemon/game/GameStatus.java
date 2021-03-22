package com.pokemon.game;

public class GameStatus {
    private String nextDialog;
    private boolean startup;
    private GameDialogs dialogs;
    private boolean firstDialog;

    public GameStatus() {
        this.startup = true;
        this.dialogs = new GameDialogs();
        this.firstDialog = false;

    }

    public boolean isStartup() {
        return startup;
    }

    public void setStartup(boolean startup) {
        this.startup = startup;
    }

    public boolean isFirstDialog(){
        return firstDialog;
    }

    public void setFirstDialog(boolean firstDialog){
        this.firstDialog = firstDialog;
    }

    public String getNextDialog() {
        return nextDialog;
    }

    public void triggerDialog(){
        if(isStartup()){
            nextDialog = this.dialogs.getNextIntroText();
            if(nextDialog == null){
                setStartup(false);
                setFirstDialog(true);
            }
        }
        if(isFirstDialog()){
            nextDialog = this.dialogs.getNextDialog1();
            if(nextDialog == null){
               setFirstDialog(false);
            }
        }
    }
}
