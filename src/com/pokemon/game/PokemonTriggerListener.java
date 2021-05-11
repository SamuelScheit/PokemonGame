package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.Trigger;
import de.gurkenlabs.litiengine.entities.TriggerEvent;
import de.gurkenlabs.litiengine.entities.TriggerListener;

public class PokemonTriggerListener implements TriggerListener {
    private TriggerBoxEnum trigger;

    public PokemonTriggerListener(TriggerBoxEnum trigger) {
        this.trigger = trigger;
    }

    @Override
    public void activated(TriggerEvent event) {
        GameStatus.instance().setTriggerBox(trigger);
        System.out.println("activated "+ trigger);
        if(trigger == TriggerBoxEnum.TRIGGER_BOX_LABOR_AUSSEN){
            Game.world().loadEnvironment("LaborInnen");
            Trigger trigger_l_l_1 = Game.world().environment().getTrigger("TRIGGER_BOX_LABOR_INNEN");
            trigger_l_l_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_LABOR_INNEN));
            Trigger trigger_g_l_1 = Game.world().environment().getTrigger("TRIGGER_BOX_G_LABOR_1");
            trigger_g_l_1.addTriggerListener(new PokemonTriggerListener(TriggerBoxEnum.TRIGGER_BOX_G_LABOR_1));
        }
        if(trigger == TriggerBoxEnum.TRIGGER_BOX_LABOR_INNEN){
            Game.world().loadEnvironment("ErstesGebiet");

            }
        }


    @Override
    public String canActivate(TriggerEvent event) {
        return null;
    }

    @Override
    public void deactivated(TriggerEvent event) {
        GameStatus.instance().setTriggerBox(TriggerBoxEnum.NONE);
        System.out.println("deactivated" + trigger);
    }
}
