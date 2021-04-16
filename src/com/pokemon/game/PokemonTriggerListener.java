package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
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
        if(trigger == TriggerBoxEnum.TRIGGER_BOX_1){
            Game.world().loadEnvironment("map2");
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
