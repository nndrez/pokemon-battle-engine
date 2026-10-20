package it.andrea.pokemon.battle;

import it.andrea.pokemon.model.rules.IGenerationRuleset;

/**
 * Represents a battle between two battlers in the Pokémon game.
 */
public class Battle {

    private final Battler humanPlayer;
    private final Battler computerPlayer;
    private final IGenerationRuleset ruleset;

    private Battler attacker;
    private Battler defender;

    private int turnCounter;

    public Battle(Battler humanPlayer, Battler computerPlayer, IGenerationRuleset ruleset) {
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
        this.ruleset = ruleset;
        this.turnCounter = 1;
    }

    public Battler getHumanPlayer() {
        return humanPlayer;
    }

    public Battler getComputerPlayer() {
        return computerPlayer;
    }

    public Battler getAttacker() {
        return attacker;
    }

    public void setAttacker(Battler attacker) {
        this.attacker = attacker;
    }

    public Battler getDefender() {
        return defender;
    }

    public void setDefender(Battler defender) {
        this.defender = defender;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public IGenerationRuleset getRuleset() {
        return ruleset;
    }
}
