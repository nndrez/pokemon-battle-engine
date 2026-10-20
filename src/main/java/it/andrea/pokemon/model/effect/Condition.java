package it.andrea.pokemon.model.effect;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.condition.ICondition;

public class Condition implements IEffect {

    private final IEffect onPass;
    private final IEffect onFail;
    private final ICondition<Battle> condition;

    public Condition(IEffect onPass, IEffect onFail, ICondition<Battle> condition) {
        this.onPass = onPass;
        this.onFail = onFail;
        this.condition = condition;
    }

    @Override
    public void apply(Battle battle) {
        if (condition.check(battle)) {
            onPass.apply(battle);
        } else {
            onFail.apply(battle);
        }
    }
}
