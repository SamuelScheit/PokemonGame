package com.pokemon.game;

public class GameStatus {
    public DbCommands db;
    private TriggerBoxEnum triggerBox;
    private String nextDialog;
    private boolean startup;
    private GameDialogs dialogs;
    private boolean firstDialog;
    private boolean secondDialog;
    private boolean thirdDialog;
    private boolean forthDialog;
    private boolean fifthDialog;
    private boolean sixthDialog;
    private boolean seventhDialog;
    private boolean eightDialog;
    private boolean ninthDialog;
    private boolean ingame;
    private static GameStatus instance;
    public String spawnpoint = "enter";

    public GameStatus() {
        this.startup = true;
        this.dialogs = new GameDialogs();
        this.firstDialog = false;
        this.ingame = false;
        db = new DbCommands();
    }

    public static GameStatus instance() {
        if (instance == null) {
            instance = new GameStatus();
        }

        return instance;
    }

    public boolean isIngame() {
        return ingame;
    }

    public void setIngame(boolean value) {
        ingame = value;
    }

    public boolean isStartup() {
        return startup;
    }

    public void setStartup(boolean startup) {
        this.startup = startup;
    }

    public boolean isFirstDialog() {
        return firstDialog;
    }

    public void setFirstDialog(boolean firstDialog) {
        this.firstDialog = firstDialog;
    }

    public boolean isSecondDialog() {
        return secondDialog;
    }

    public void setSecondDialog(boolean secondDialog) {
        this.secondDialog = secondDialog;
    }

    public boolean isThirdDialog() {
        return thirdDialog;
    }

    public void setThirdDialog(boolean thirdDialog) {
        this.thirdDialog = thirdDialog;
    }

    public boolean isForthDialog() {
        return forthDialog;
    }

    public void setForthDialog(boolean forthDialog) {
        this.forthDialog = forthDialog;
    }

    public boolean isFifthDialog() {
        return fifthDialog;
    }

    public void setFifthDialog(boolean fifthDialog) {
        this.fifthDialog = fifthDialog;
    }

    public boolean isSixthDialog() {
        return sixthDialog;
    }

    public void setSixthDialog(boolean sixthDialog) {
        this.sixthDialog = sixthDialog;
    }

    public boolean isSeventhDialog() {
        return seventhDialog;
    }

    public void setSeventhDialog(boolean seventhDialog) {
        this.seventhDialog = seventhDialog;
    }

    public boolean isEightDialog() {
        return eightDialog;
    }

    public void setEightDialog(boolean eightDialog) {
        this.eightDialog = eightDialog;
    }

    public boolean isNinthDialog() {
        return ninthDialog;
    }

    public void setNinthDialog(boolean ninthDialog) {
        this.ninthDialog = ninthDialog;
    }

    public String getNextDialog() {
        return nextDialog;
    }

    public void triggerDialog() {

        if (isStartup() && getTriggerBox() == TriggerBoxEnum.TRIGGER_BOX_G_START_1) {
            nextDialog = this.dialogs.getNextIntroText();
            if (nextDialog == null) {
                setStartup(false);
                setFirstDialog(true);
            }
        }
        if (isFirstDialog() && getTriggerBox() == TriggerBoxEnum.TRIGGER_BOX_G_LABOR_1) {
            nextDialog = this.dialogs.getNextDialog1();
            if (nextDialog == null) {
                setFirstDialog(false);
                setSecondDialog(true);

            }
        }
        if (isFirstDialog() && getTriggerBox() == TriggerBoxEnum.TRIGGER_BOX_G_AUSSEN_1) {
            nextDialog = this.dialogs.getNextDialog2_1();
        }

        if (isSecondDialog() && getTriggerBox() == TriggerBoxEnum.TRIGGER_BOX_G_AUSSEN_1) {
            nextDialog = this.dialogs.getNextDialog2();
            if (nextDialog == null) {
                setSecondDialog(false);
            }
        }
        if (isThirdDialog() && getTriggerBox() == TriggerBoxEnum.TRIGGER_BOX_G_GEBIET2_1) {
            nextDialog = this.dialogs.getNextDialog3();
            if (nextDialog == null) {
                setThirdDialog(false);
                setForthDialog(true);
            }
        }
        if (isThirdDialog() && getTriggerBox() == TriggerBoxEnum.TRIGGER_BOX_G_GEBIET2_2) {
            nextDialog = this.dialogs.getNextDialog5_1();
            if (nextDialog == null) {

            }
        }
        if (isForthDialog() && getTriggerBox() == TriggerBoxEnum.TRIGGER_BOX_G_GEBIET2_2) {
            nextDialog = this.dialogs.getNextDialog5();
            if (nextDialog == null) {
                setForthDialog(false);
                setFifthDialog(true);
            }
        }


    }


    public TriggerBoxEnum getTriggerBox() {
        return triggerBox;
    }

    public void setTriggerBox(TriggerBoxEnum triggerBox) {
        this.triggerBox = triggerBox;
    }

    public boolean isMovementAllowed() {
        return this.dialogs.isMovementAllowed();
    }


}

