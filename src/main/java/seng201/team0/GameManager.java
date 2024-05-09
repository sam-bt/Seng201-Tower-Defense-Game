package seng201.team0;
import seng201.team0.models.Setup;
import seng201.team0.services.DifficultyService;
import seng201.team0.services.MoneyService;

import java.util.function.Consumer;

/**
 *
 * Class that manages all the game information
 *
 */

public class GameManager {
    private String name;
    private Long rounds;
    private DifficultyService difficulty;
    private int currRound;
    private MoneyService money;
    private final Consumer<GameManager> setupScreenLauncher;
    private final Consumer<GameManager> betweenScreenLauncher;
    private final Consumer<GameManager> gameScreenLauncher;
    private final Runnable clearScreen;
    public GameManager(Consumer<GameManager> setupScreenLauncher, Consumer<GameManager> betweenScreenLauncher, Consumer<GameManager> gameScreenLauncher, Runnable clearScreen){
        this.setupScreenLauncher = setupScreenLauncher;
        this.betweenScreenLauncher = betweenScreenLauncher;
        this.gameScreenLauncher = gameScreenLauncher;
        this.clearScreen = clearScreen;
        launchSetupScreen();
    }
    public void setSetup(Setup setup){
        setName(setup.getName());
        setRounds(setup.getNumRounds());
    }
    public void setCurrRound()  {currRound = 0; }
    public void incrementRound() { currRound += 1; } // TODO check for round == to max rounds, if so then terminate
    public int getCurrRound() { return currRound; }
    public void launchSetupScreen() { setupScreenLauncher.accept(this); }
    public void launchBetweenRoundsScreen() { betweenScreenLauncher.accept(this); }
    public void launchGameScreen() {
        gameScreenLauncher.accept(this);
    }
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }
    public void setRounds(Long rounds) { this.rounds = rounds; }
    public Long getRounds() {
        return rounds;
    }
    public void setDifficulty(DifficultyService difficulty) { this.difficulty = difficulty; }
    public Double getDifficulty() {return difficulty.getDifficulty();}
    public void setMoney(MoneyService money) { this.money = money; }
    public int getMoney() { return money.getCurrentAmount(); }

    public void closeSetupScreen() {
        clearScreen.run();
        launchBetweenRoundsScreen();
    }
    public void closeBetweenRoundScreen() {
        clearScreen.run();
        launchGameScreen();
    }
    public void closeGameScreen(){
        clearScreen.run();
        launchBetweenRoundsScreen();
    }
}
