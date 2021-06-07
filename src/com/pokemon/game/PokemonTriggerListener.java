package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.Trigger;
import de.gurkenlabs.litiengine.entities.TriggerEvent;
import de.gurkenlabs.litiengine.entities.TriggerListener;

import java.util.ArrayList;

import static com.pokemon.game.GameStatus.*;

public class PokemonTriggerListener implements TriggerListener {
    private int skipTrigger = 0;
    private ArrayList<String> worldsLoaded = new ArrayList<>();

    public PokemonTriggerListener() {
        Game.world().onLoaded(environment -> {
            if (worldsLoaded.contains(environment.getMap().getName())) return;
            if (environment.getMap().getName().equals("ZweitesGebietFinalBackup1")) skipTrigger = 2;
            if (environment.getMap().getName().equals("LaborInnen")) skipTrigger = 1;
            worldsLoaded.add(environment.getMap().getName());
        });
    }

    @Override
    public void activated(TriggerEvent event) {
        if (skipTrigger > 0) {
            System.out.println("skip trigger");
            skipTrigger--;
            return;
        }
        TriggerBoxEnum trigger = TriggerBoxEnum.valueOf(event.getTrigger().getName());

        instance().setTriggerBox(trigger);
        GameStatus.instance().triggerDialog();
        System.out.println("activated " + trigger);

        //Gebiete laden von Außen + trigger innen laden
        if (trigger == TriggerBoxEnum.TRIGGER_BOX_LABOR_AUSSEN) {
            GameStatus.instance().spawnpoint = "enter";
            Game.world().loadEnvironment("LaborInnen");
        }

        if (trigger == TriggerBoxEnum.TRIGGER_BOX_START_AUSSEN) {
            GameStatus.instance().spawnpoint = "enter";
            Game.world().loadEnvironment("StarterhausInnen");
        }

        if (trigger == TriggerBoxEnum.TRIGGER_BOX_EER_AUSSEN) {
            GameStatus.instance().spawnpoint = "enter";
            Game.world().loadEnvironment("EastereggRoomFinalBackup1");
        }

        if (trigger == TriggerBoxEnum.TRIGGER_BOX_ARENA_AUSSEN) {
            GameStatus.instance().spawnpoint = "enter";
            Game.world().loadEnvironment("ArenaInnenFinalBackup1");
        }

        // Gebiet 1 laden
        if (trigger == TriggerBoxEnum.TRIGGER_BOX_LABOR_INNEN) {
            GameStatus.instance().spawnpoint = "enter_labor";
            Game.world().loadEnvironment("ErstesGebietTestFinalBackup1");
        }

        if (trigger == TriggerBoxEnum.TRIGGER_BOX_START_INNEN) {
            GameStatus.instance().spawnpoint = "enter_start";
            Game.world().loadEnvironment("ErstesGebietTestFinalBackup1");
        }
        if (trigger == TriggerBoxEnum.TRIGGER_BOX_GEBIET2_1) {
            GameStatus.instance().spawnpoint = "enter_gebiet2";
            Game.world().loadEnvironment("ErstesGebietTestFinalBackup1");
        }

        //Gebiet 2 laden
        if (trigger == TriggerBoxEnum.TRIGGER_BOX_EER_INNEN) {
            GameStatus.instance().spawnpoint = "enter2";
            Game.world().loadEnvironment("ZweitesGebietFinalBackup1");
        }

        if (trigger == TriggerBoxEnum.TRIGGER_BOX_GEBIET3_1) {
            GameStatus.instance().spawnpoint = "enter1";
            Game.world().loadEnvironment("ZweitesGebietFinalBackup1");
        }

        if (trigger == TriggerBoxEnum.TRIGGER_BOX_GEBIET1) {
            GameStatus.instance().spawnpoint = "enter1";
            Game.world().loadEnvironment("ZweitesGebietFinalBackup1");
        }

        //Gebiet 3 laden
        if (trigger == TriggerBoxEnum.TRIGGER_BOX_ARENA_INNEN) {
            GameStatus.instance().spawnpoint = "enter1";
            Game.world().loadEnvironment("LaborGebietFinalBackup1");
        }
        if (trigger == TriggerBoxEnum.TRIGGER_BOX_GEBIET2_2) {
            GameStatus.instance().spawnpoint = "enter1";
            Game.world().loadEnvironment("LaborGebietFinalBackup1");
        }
    }

    @Override
    public String canActivate(TriggerEvent event) {
        return null;
    }

    @Override
    public void deactivated(TriggerEvent event) {
        instance().setTriggerBox(TriggerBoxEnum.NONE);
        System.out.println("deactivated" + event.getTrigger().getName());
    }
}
