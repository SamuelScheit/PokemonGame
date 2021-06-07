package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;

public class GameDialogs {
    private int introcount;
    private int dialog1count;
    private int dialog2count;
    private int dialog2_1count;
    private int dialog3count;
    private int dialog4count;
    private int dialog5count;
    private int dialog5_1count;
    private int dialog6count;
    private int dialog7count;
    private int dialog8count;
    private int dialog9count;
    private boolean allowMovement = true;

    public boolean isMovementAllowed() {
        return allowMovement;
    }

    public void setAllowMovement(boolean value) {
        allowMovement = value;
    }


    private static final String[] INTRO = new String[]{"ASH: Guten Morgen!", "MUTTER: Alles gute zu deinem 10ten Geburtstag.", "MUTTER: Bist du bereit dein erster Pokemon abzuholen und auf die große Reise zu gehen?", "ASH: JAA!"};
    private static final String[] DIALOG1 = new String[]{"ASH: Hallo Herr Wagner, ich bin bereit Pokemon Trainer zu werden!", "HERR WAGNER: Hallo Ash alles gute zu deinem 10ten Geburtstag", "ASH: Vielen Dank!", "ASH: Welche Pokemon habe ich zur Wahl ", "HERR WAGNER: Du hast die Wahl zwischen diesen drei Starterpokemon:", "ASH: Schwere Entscheidung", "HERR WAGNER: Wähle weiße", "HERR WAGNER: Eine sehr gute Entscheidung", "ASH: vielen Dank für meine aller erstes Pokemon", "ASH: Ich freue mich auf die große Reise"};
    private static final String[] DIALOG2 = new String[]{"FREMDE: Hallo, lass uns kämpfen","" ,"Fremde: Wow, du bist echt gut, viel Glück auf deiner Reise"};
    private static final String[] DIALOG2_1 = new String[]{"FREMDE: Bevor ich gegen dich kämpfen kann, musst du dir dein erstes Pokemon bei Herr Wagner abholen"};
    private static final String[] DIALOG3 = new String[]{"ASH: Hallo!", "ASH: Was machen du hier ganz alleine im Wald?", "FREMDER: Hallo!", "FREMDER: Ich bin nicht alleine ich habe meine Pokemon hier bei mir.", "FREMDER: Ich habe vor sehr langer Zeit mit der Forschungen in verschiedenen Regionen über die unterschiedlichsten Pokemon begonnen.", "FREMDER: Ich habe beispielsweise für alle Pokemon eine Art „Supertrank“ gebraut. Dieser Trank lässt die Pokemon nach dem Kampf sofort wieder volles Leben regenerieren!", "FREMDER: Wenn deine Pokemon Schaden genommen haben, kannst du einfach zu meinem Bruder da drüben gehen und der heilt sie wieder voll", "ASH: Super vielen Dank!"};
    private static final String[] DIALOG4 = new String[]{"HERR WAGNER: Willkommen du hast also meine geheime Sammlung mit ein Paar Artefakten aus berühmten Spielen gefunden!", "HERR WAGNER: Kuck dich ruhig in Ruhe um."};
    private static final String[] DIALOG5 = new String[]{"FREMDER: Hallo, du musst schon meinen Bruder getroffen haben, der allen von seinen Tränken erzählt.", "Nun, ich habe ein paar bei mir, sag einfach bescheid, wenn du einen brauchst", ""};
    private static final String[] DIALOG5_1 = new String[]{"FREMDER: Hallo, ich habe Tränke bei mir, die deine Pokemon heilen können", "FREMDER: Falls du mehr über die Tränke erfahren willst, frag einfach meinen Bruder, der ist unten am Fluss", "Ach ja, ich habe übrigens ein paar Tränke über, wenn deine Pokemon also Schaden genommen haben, kann ich sie wieder voll heilen", ""};
    private static final String[] DIALOG6 = new String[]{"HERR WAGNER: Ich sehe, du hast es durch mein Labyrinth geschafft und auch etwas Kampferfahrung gesammelt ", "Ich denke, du bist bereit auch gegen mich zu kämpfen", "Wow, du bist echt gut geworden, seit ich dir dein erstes Pokemon gegeben hab. Herzlichen Glückwunsch zum Sieg, Ash", ""};
    private static final String[] DIALOG7 = new String[]{"Stop! Du musst dir einen anderen Weg suchen, um weiterzukommen"};
    private static final String[] DIALOG8 = new String[]{"Stop! Du musst dir einen anderen Weg suchen, um weiterzukommen"};
    private static final String[] DIALOG9 = new String[]{"Stop! Du musst dir einen anderen Weg suchen, um weiterzukommen"};

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
        if (dialog1count == 6) {
            Game.screens().display(SelectPokemonScreen.NAME);
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
        if (dialog2count == 2) {
            System.out.println("fight!");
            FightScreen screen = (FightScreen) Game.screens().get(FightScreen.NAME);
            screen.pokemon1 = Player.instance().inventory.get(0);
            screen.pokemon2 = GameStatus.instance().db.getPokemon("2");
            Game.screens().display(FightScreen.NAME);
        }

        return textString;
    }

    public String getNextDialog2_1() {
        String textString;
        if (dialog2_1count >= DIALOG2_1.length) {
            textString = null;
            setAllowMovement(true);
        } else {
            textString = DIALOG2_1[dialog2_1count];
            dialog2_1count = dialog2_1count + 1;
            setAllowMovement(false);
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

    public String getNextDialog4() {
        String textString;
        if (dialog4count >= DIALOG4.length) {
            textString = null;
            setAllowMovement(true);
        } else {
            textString = DIALOG4[dialog4count];
            dialog4count = dialog4count + 1;
            setAllowMovement(false);
        }

        return textString;
    }

    public String getNextDialog5() {
        String textString;
        if (dialog5count >= DIALOG5.length) {
            textString = null;
            setAllowMovement(true);
            dialog5count = 0;
        } else {
            textString = DIALOG5[dialog5count];
            dialog5count = dialog5count + 1;
            setAllowMovement(false);
        }
        if (dialog1count == 3) {
            //heal
        }

        return textString;
    }

    public String getNextDialog5_1() {
        String textString;
        if (dialog5_1count >= DIALOG5_1.length) {
            textString = null;
            setAllowMovement(true);
        } else {
            textString = DIALOG5_1[dialog5_1count];
            dialog5_1count = dialog5_1count + 1;
            setAllowMovement(false);
        }
        if (dialog1count == 4) {
            //heal
        }

        return textString;
    }

    public String getNextDialog6() {
        String textString;
        if (dialog6count >= DIALOG6.length) {
            textString = null;
            setAllowMovement(true);
        } else {
            textString = DIALOG6[dialog6count];
            dialog6count = dialog6count + 1;
            setAllowMovement(false);
        }
        if (dialog1count == 3) {
            //kampf
        }

        return textString;
    }

    public String getNextDialog7() {
        String textString;
        if (dialog7count >= DIALOG7.length) {
            textString = null;
            setAllowMovement(true);
            dialog7count = 0;
        } else {
            textString = DIALOG7[dialog7count];
            dialog7count = dialog7count + 1;
            setAllowMovement(false);
        }

        return textString;
    }

    public String getNextDialog8() {
        String textString;
        if (dialog8count >= DIALOG8.length) {
            textString = null;
            setAllowMovement(true);
            dialog8count = 0;
        } else {
            textString = DIALOG8[dialog8count];
            dialog8count = dialog8count + 1;
            setAllowMovement(false);

        }

        return textString;
    }

    public String getNextDialog9() {
        String textString;
        if (dialog9count >= DIALOG9.length) {
            textString = null;
            setAllowMovement(true);
            dialog9count = 0;
        } else {
            textString = DIALOG9[dialog9count];
            dialog9count = dialog9count + 1;
            setAllowMovement(false);
        }

        return textString;
    }

}




