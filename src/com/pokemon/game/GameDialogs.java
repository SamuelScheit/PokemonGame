package com.pokemon.game;

public class GameDialogs {
    private int introcount;
    private int dialog1count;
    private int dialog2count;
    private boolean allowMovement = true;

    public boolean isMovementAllowed() {
        return allowMovement;
    }

    public void setAllowMovement(boolean value) {
        allowMovement = value;
    }


    private static final String[] INTRO = new String[]{"Intro1", "Intro2", "Intro3"};
    private static final String[] DIALOG1 = new String[]{"DIALOG1.1", "DIALOG1.2", "DIALOG1.3", "DIALOG1.4"};
    private static final String[] DIALOG2 = new String[]{"DIALOG2.1", "DIALOG2.2", "DIALOG2.3", "DIALOG2.4"};

    public String getNextIntroText() {
        String textString;
        if (introcount >= INTRO.length) {
            textString = null;
            setAllowMovement(true);

        } else {
            textString = INTRO[introcount];
            introcount = introcount + 1;
            setAllowMovement(false);

        }


        return textString;
    }

    public String getNextDialog1() {
        String textString;
        if (dialog1count >= DIALOG1.length) {
            textString = null;
            setAllowMovement(true);

        } else {
            textString = DIALOG1[dialog1count];
            dialog1count = dialog1count + 1;
            setAllowMovement(false);
        }
        return textString;
    }

    public String getNextDialog2() {
        String textString;
        if (dialog2count >= DIALOG2.length) {
            textString = null;

        } else {
            textString = DIALOG2[dialog2count];
            dialog2count = dialog2count + 1;
        }

        return textString;

    }

    public void onMovementCheck() {

    }


}

