package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.Trigger;
import de.gurkenlabs.litiengine.entities.TriggerEvent;
import de.gurkenlabs.litiengine.entities.TriggerListener;

import static com.pokemon.game.GameStatus.*;

public class PokemonTriggerListener implements TriggerListener {
    private TriggerBoxEnum trigger;


    public PokemonTriggerListener(TriggerBoxEnum trigger) {
        this.trigger = trigger;
    }

    @Override
    public void activated(TriggerEvent event) {
        instance().setTriggerBox(trigger);
        GameStatus.instance().triggerDialog();
        System.out.println("activated " + trigger);
        //Gebiete laden von Außen + trigger innen laden
        if (trigger == TriggerBoxEnum.TRIGGER_BOX_LABOR_AUSSEN) {
            Game.world().loadEnvironment("LaborInnen");
            Trigger trigger_l_l_1 = Game.world().environment().getTrigger("TRIGGER_BOX_LABOR_INNEN");
            trigger_l_l_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_LABOR_INNEN));
            Trigger trigger_g_l_1 = Game.world().environment().getTrigger("TRIGGER_BOX_G_LABOR_1");
            trigger_g_l_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_LABOR_1));


        }

        if (trigger == TriggerBoxEnum.TRIGGER_BOX_START_AUSSEN) {
            Game.world().loadEnvironment("StarterhausInnen");
            Trigger trigger_l_s_1 = Game.world().environment().getTrigger("TRIGGER_BOX_START_INNEN");
            trigger_l_s_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_START_INNEN));
            Trigger trigger_g_s_1 = Game.world().environment().getTrigger("TRIGGER_BOX_G_START_1");
            trigger_g_s_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_START_1));
        }

        if (trigger == TriggerBoxEnum.TRIGGER_BOX_EER_AUSSEN) {
            Game.world().loadEnvironment("EastereggRoomFinalBackup1");
            Trigger trigger_l_e_1 = Game.world().environment().getTrigger("TRIGGER_BOX_EER_INNEN");
            trigger_l_e_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_EER_INNEN));
            Trigger trigger_g_e_1 = Game.world().environment().getTrigger("TRIGGER_BOX_G_EER_1");
            trigger_g_e_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_EER_1));
        }

        if (trigger == TriggerBoxEnum.TRIGGER_BOX_ARENA_AUSSEN) {
            Game.world().loadEnvironment("ArenaInnenFinalBackup1");
            Trigger trigger_l_a_1 = Game.world().environment().getTrigger("TRIGGER_BOX_ARENA_INNEN");
            trigger_l_a_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_ARENA_INNEN));
            Trigger trigger_g_a_11 = Game.world().environment().getTrigger("TRIGGER_BOX_G_ARENA_11");
            trigger_g_a_11.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_ARENA_11));
            Trigger trigger_g_a_12 = Game.world().environment().getTrigger("TRIGGER_BOX_G_ARENA_12");
            trigger_g_a_12.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_ARENA_12));
            Trigger trigger_g_a_13 = Game.world().environment().getTrigger("TRIGGER_BOX_G_LABOR_13");
            trigger_g_a_13.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_ARENA_13));
            Trigger trigger_g_a_14 = Game.world().environment().getTrigger("TRIGGER_BOX_G_LABOR_14");
            trigger_g_a_14.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_ARENA_14));
        }

        //Gebiet 1 laden
        if (trigger == TriggerBoxEnum.TRIGGER_BOX_LABOR_INNEN) {
            Game.world().loadEnvironment("ErstesGebietTestFinalBackup1");
            Trigger trigger_l_g1_1 = Game.world().environment().getTrigger("TRIGGER_BOX_LABOR_AUSSEN");
            trigger_l_g1_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_LABOR_AUSSEN));
            Trigger trigger_l_g1_2 = Game.world().environment().getTrigger("TRIGGER_BOX_START_AUSSEN");
            trigger_l_g1_2.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_START_AUSSEN));
            Trigger trigger_l_g1_3 = Game.world().environment().getTrigger("TRIGGER_BOX_GEBIET1");
            trigger_l_g1_3.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_GEBIET1));
            Trigger trigger_g_g1_1 = Game.world().environment().getTrigger("TRIGGER_BOX_G_GEBIET1_1");
            trigger_g_g1_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_AUSSEN_1));


        }
        if (trigger == TriggerBoxEnum.TRIGGER_BOX_START_INNEN) {
            GameStatus.instance().spawnpoint = "enter_start";
            Game.world().loadEnvironment("ErstesGebietTestFinalBackup1");
            Trigger trigger_l_g1_1 = Game.world().environment().getTrigger("TRIGGER_BOX_LABOR_AUSSEN");
            trigger_l_g1_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_LABOR_AUSSEN));
            Trigger trigger_l_g1_2 = Game.world().environment().getTrigger("TRIGGER_BOX_START_AUSSEN");
            trigger_l_g1_2.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_START_AUSSEN));
            Trigger trigger_l_g1_3 = Game.world().environment().getTrigger("TRIGGER_BOX_GEBIET1");
            trigger_l_g1_3.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_GEBIET1));
            Trigger trigger_g_g1_1 = Game.world().environment().getTrigger("TRIGGER_BOX_G_AUSSEN_1");
            trigger_g_g1_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_AUSSEN_1));
        }

        if (trigger == TriggerBoxEnum.TRIGGER_BOX_GEBIET2_1) {
            GameStatus.instance().spawnpoint = "enter_gebiet2";
            Game.world().loadEnvironment("ErstesGebietTestFinalBackup1");
            Trigger trigger_l_g1_1 = Game.world().environment().getTrigger("TRIGGER_BOX_LABOR_AUSSEN");
            trigger_l_g1_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_LABOR_AUSSEN));
            Trigger trigger_l_g1_2 = Game.world().environment().getTrigger("TRIGGER_BOX_START_AUSSEN");
            trigger_l_g1_2.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_START_AUSSEN));
            Trigger trigger_l_g1_3 = Game.world().environment().getTrigger("TRIGGER_BOX_GEBIET1");
            trigger_l_g1_3.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_GEBIET1));
            Trigger trigger_g_g1_1 = Game.world().environment().getTrigger("TRIGGER_BOX_START_AUSSEN");
            trigger_g_g1_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_AUSSEN_1));


        }

        //Gebiet 2 laden
        if (trigger == TriggerBoxEnum.TRIGGER_BOX_EER_INNEN) {
            GameStatus.instance().spawnpoint = "enter1";
            Game.world().loadEnvironment("ZweitesGebietFinalBackup1");
            Trigger trigger_g_g2_1 = Game.world().environment().getTrigger("TRIGGER_BOX_G_GEBIET2_1");
            trigger_g_g2_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_GEBIET2_1));
            Trigger trigger_g_g2_2 = Game.world().environment().getTrigger("TRIGGER_BOX_G_GEBIET2_2");
            trigger_g_g2_2.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_GEBIET2_2));
            Trigger trigger_l_g2_1 = Game.world().environment().getTrigger("TRIGGER_BOX_GEBIET2_1");
            trigger_l_g2_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_GEBIET2_1));
            Trigger trigger_l_g2_2 = Game.world().environment().getTrigger("TRIGGER_BOX_GEBIET2_2");
            trigger_l_g2_2.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_GEBIET2_2));
            Trigger trigger_l_g2_3 = Game.world().environment().getTrigger("TRIGGER_BOX_EER_AUSSEN");
            trigger_l_g2_3.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_EER_AUSSEN));
        }

        if (trigger == TriggerBoxEnum.TRIGGER_BOX_GEBIET3_1) {
            GameStatus.instance().spawnpoint = "enter1";
            Game.world().loadEnvironment("ZweitesGebietFinalBackup1");
            Trigger trigger_g_g2_1 = Game.world().environment().getTrigger("TRIGGER_BOX_G_GEBIET2_1");
            trigger_g_g2_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_GEBIET2_1));
            Trigger trigger_g_g2_2 = Game.world().environment().getTrigger("TRIGGER_BOX_G_GEBIET2_2");
            trigger_g_g2_2.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_GEBIET2_2));
            Trigger trigger_l_g2_1 = Game.world().environment().getTrigger("TRIGGER_BOX_GEBIET2_1");
            trigger_l_g2_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_GEBIET2_1));
            Trigger trigger_l_g2_2 = Game.world().environment().getTrigger("TRIGGER_BOX_GEBIET2_2");
            trigger_l_g2_2.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_GEBIET2_2));
            Trigger trigger_l_g2_3 = Game.world().environment().getTrigger("TRIGGER_BOX_EER_AUSSEN");
            trigger_l_g2_3.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_EER_AUSSEN));
        }

        if (trigger == TriggerBoxEnum.TRIGGER_BOX_GEBIET1) {
            GameStatus.instance().spawnpoint = "enter1";
            Game.world().loadEnvironment("ZweitesGebietFinalBackup1");
            Trigger trigger_g_g2_1 = Game.world().environment().getTrigger("TRIGGER_BOX_G_GEBIET2_1");
            trigger_g_g2_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_GEBIET2_1));
            Trigger trigger_g_g2_2 = Game.world().environment().getTrigger("TRIGGER_BOX_G_GEBIET2_2");
            trigger_g_g2_2.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_GEBIET2_2));
            Trigger trigger_l_g2_1 = Game.world().environment().getTrigger("TRIGGER_BOX_GEBIET2_1");
            trigger_l_g2_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_GEBIET2_1));
            Trigger trigger_l_g2_2 = Game.world().environment().getTrigger("TRIGGER_BOX_GEBIET2_2");
            trigger_l_g2_2.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_GEBIET2_2));
            Trigger trigger_l_g2_3 = Game.world().environment().getTrigger("TRIGGER_BOX_EER_AUSSEN");
            trigger_l_g2_3.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_EER_AUSSEN));
        }

        //Gebiet 3 laden
        if (trigger == TriggerBoxEnum.TRIGGER_BOX_ARENA_INNEN) {
            GameStatus.instance().spawnpoint = "enter";
            Game.world().loadEnvironment("LaborGebietFinalBackup1");
            Trigger trigger_g_g3_1 = Game.world().environment().getTrigger("TRIGGER_BOX_GEBIET3_1");
            trigger_g_g3_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_GEBIET3_1));
            Trigger trigger_g_g3_2 = Game.world().environment().getTrigger("TRIGGER_BOX_ARENA_AUSSEN");
            trigger_g_g3_2.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_ARENA_AUSSEN));
        }
        if (trigger == TriggerBoxEnum.TRIGGER_BOX_GEBIET2_2) {
            GameStatus.instance().spawnpoint = "enter";
            Game.world().loadEnvironment("LaborGebietFinalBackup1");
            Trigger trigger_g_g3_1 = Game.world().environment().getTrigger("TRIGGER_BOX_GEBIET3_1");
            trigger_g_g3_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_GEBIET3_1));
            Trigger trigger_g_g3_2 = Game.world().environment().getTrigger("TRIGGER_BOX_ARENA_AUSSEN");
            trigger_g_g3_2.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_ARENA_AUSSEN));
        }



    }


    @Override
    public String canActivate(TriggerEvent event) {
        return null;
    }

    @Override
    public void deactivated(TriggerEvent event) {
        instance().setTriggerBox(TriggerBoxEnum.NONE);
        System.out.println("deactivated" + trigger);
    }
}
