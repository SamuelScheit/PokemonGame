package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;

public class GameDialogs {
    private int introcount;
    private int dialog1count;
    private int dialog2count;
    private int dialog3count;
    private boolean allowMovement = true;

    public boolean isMovementAllowed() {
        return allowMovement;
    }

    public void setAllowMovement(boolean value) {
        allowMovement = value;
    }


    private static final String[] INTRO = new String[]{"ASH: Guten Morgen!", "MUTTER: Alles gute zu deinem 10ten Geburtstag.", "MUTTER: Bist du bereit dein erster Pokemon abzuholen und auf die große Reise zu gehen?","ASH: JAA!"};
    private static final String[] DIALOG1 = new String[]{"ASH: Hallo Herr Wagner, ich bin bereit Pokemon Trainer zu werden!", "HERR WAGNER: Hallo Ash alles gute zu deinem 10ten Geburtstag", "ASH: Vielen Dank!", "ASH: Welche Pokemon habe ich zur Wahl ","HERR WAGNER: Du hast die Wahl zwischen diesen drei Starterpokemon:","","ASH: Schwere Entscheidung","HERR WAGNER: Wähle weiße","HERR WAGNER: Eine sehr gute Entscheidung", "ASH: vielen Dank für meine aller erstes Pokemon","ASH: Ich freue mich auf die große Reise"};
    private static final String[] DIALOG2 = new String[]{"ASH: Hallo!", "ASH: Was machen du hier ganz alleine im Wald?", "FREMDER: Hallo!", "FREMDER: Ich bin nicht alleine ich habe meine Pokemon hier bei mir.","FREMDER: Ich habe vor sehr langer Zeit mit der Forschungen in verschiedenen Regionen über die unterschiedlichsten Pokemon begonnen.","FREMDER: Ich habe beispielsweise für alle Pokemon eine Art „Supertrank“ gebraut. Dieser Trank lässt die Pokemon nach dem Kampf sofort wieder volles Leben regenerieren!","FREMDER: Wenn deine Pokemon Schaden genommen haben, komm einfach zu mir und ich fülle ihr Leben wieder auf", "ASH: Super vielen Dank!"};
    private static final String[] DIALOG3 = new String[]{"HERR WAGNER: Willkommen du hast also meine geheime Sammlung mit ein Paar Artefakten aus berühmten Spielen gefunden!", "HERR WAGNER: Kuck dich ruhig in Ruhe um."};
    /*private static final String[] DIALOG4 = new String[]{"", "", "", ""};
    private static final String[] DIALOG5 = new String[]{"", "", "", ""};
    private static final String[] DIALOG6 = new String[]{"", "", "", ""};
    private static final String[] DIALOG7 = new String[]{"", "", "", ""};
    private static final String[] DIALOG8 = new String[]{"", "", "", ""};
    private static final String[] DIALOG9 = new String[]{"", "", "", ""};
    private static final String[] DIALOG10 = new String[]{"", "", "", ""};
    private static final String[] DIALOG11 = new String[]{"", "", "", ""};
    private static final String[] DIALOG12 = new String[]{"", "", "", ""};
    private static final String[] DIALOG13 = new String[]{"", "", "", ""};
    private static final String[] DIALOG14 = new String[]{"", "", "", ""};
    private static final String[] DIALOG15 = new String[]{"", "", "", ""};
    private static final String[] DIALOG16 = new String[]{"", "", "", ""};*/
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
        if(dialog1count == 6){
            Game.screens().display("selectPokemon");
        }
        return textString;
    }

    public String getNextDialog2() {
        String textString;
        if (dialog2count >= DIALOG2.length) {
            textString = null;
            setAllowMovement(true);

        } else {
            textString = DIALOG2[dialog2count];
            dialog2count = dialog2count + 1;
            setAllowMovement(false);
        }
        if(dialog1count == 6){
            Game.screens().display("Heal");
        }

        return textString;

    }

    public String getNextDialog3() {
        String textString;
        if (dialog3count >= DIALOG3.length) {
            textString = null;
            setAllowMovement(true);

        } else {
            textString = DIALOG3[dialog3count];
            dialog3count = dialog3count + 1;
            setAllowMovement(false);
        }

        return textString;

    }



}




