package it.andrea.pokemon.model.attempt;

import it.andrea.pokemon.battle.Battle;
import it.andrea.pokemon.model.condition.ICondition;
import it.andrea.pokemon.model.effect.IEffect;
import it.andrea.pokemon.model.effect.NoEffect;

public class Attempt implements IAttempt {

    private final ICondition<Battle> accuracy;
    private final IEffect onHit;
    private final IEffect onMiss;
    private final IEffect after;

    private Attempt(ICondition<Battle> accuracy, IEffect onHit) {
        this.accuracy = accuracy;
        this.onHit = onHit;
        onMiss = new NoEffect();
        after = new NoEffect();
    }

    public Attempt(ICondition<Battle> accuracy, IEffect onHit, IEffect onMiss, IEffect after) {
        this.accuracy = accuracy;
        this.onHit = onHit;
        this.onMiss = onMiss;
        this.after = after;
    }

    public static Attempt of(ICondition<Battle> accuracy, IEffect onHit) {
        return new Attempt(accuracy, onHit);
    }

    public static Attempt of(ICondition<Battle> accuracy, IEffect onHit, IEffect onMiss, IEffect after) {
        return new Attempt(accuracy, onHit, onMiss, after);
    }

    @Override
    public void execute(Battle battle) {
        if (accuracy.check(battle)) {
            onHit.apply(battle);
        } else {
            onMiss.apply(battle);
        }

        after.apply(battle);
    }
}
