package com.pokemon.game;

public class GameDialogs {
    private int introcount;
    private int dialog1count;


    private static final String[] INTRO = new String[]{ "Intro1", "Intro2", "Intro3" };
    private static final String[] DIALOG1 = new String[]{ "DIALOG1.1", "DIALOG1.2", "DIALOG1.3", "DIALOG1.4" };

    public String getNextIntroText() {
        String textString;
        if (introcount >= INTRO.length) {
            textString = null;
        }
        else {
            textString = INTRO[introcount];
            introcount = introcount + 1;
        }

        return textString;
    }

    public String getNextDialog1() {
        String textString;
        if (dialog1count >= DIALOG1.length) {
            textString = null;

        } else {
            textString = DIALOG1[dialog1count];
            dialog1count = dialog1count + 1;
        }

        return textString;
    }
}

