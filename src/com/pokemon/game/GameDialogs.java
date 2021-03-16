package com.pokemon.game;

public class GameDialogs {
    private int introcount;

    private static final String[] INTRO = new String[]{
            "Intro1", "Intro2", "Intro3"
    };

    public String getNextIntroText() {
        String textString;
        if (introcount >= INTRO.length) {
            textString = null;
        } else {
            textString = INTRO[introcount];
            introcount = introcount + 1;
        }


        return textString;
    }


}

