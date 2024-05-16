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
    private double points;
    private final Consumer<GameManager> setupScreenLauncher;
    private final Consumer<GameManager> betweenScreenLauncher;
    private final Consumer<GameManager> gameScreenLauncher;
    private final Consumer<GameManager> inventoryScreenLauncher;
    private final Consumer<GameManager> shopScreenLauncher;
    private final Consumer<GameManager> roundOneInventoryScreenLauncher;
    private final Consumer<GameManager> roundOneGameScreenLauncher;
    private final Consumer<GameManager> errorScreenLauncher;
    private final Consumer<GameManager> finishedScreenLauncher;
    private final Runnable clearScreen;
    public GameManager(Consumer<GameManager> setupScreenLauncher, Consumer<GameManager> betweenScreenLauncher, Consumer<GameManager> gameScreenLauncher, Consumer<GameManager> inventoryScreenLauncher, Consumer<GameManager> shopScreenLauncher, Consumer<GameManager> roundOneInventoryScreenLauncher, Consumer<GameManager> roundOneGameScreenLauncher, Consumer<GameManager> errorScreenLauncher, Consumer<GameManager> finishedScreenLauncher, Runnable clearScreen){
        this.setupScreenLauncher = setupScreenLauncher;
        this.betweenScreenLauncher = betweenScreenLauncher;
        this.gameScreenLauncher = gameScreenLauncher;
        this.inventoryScreenLauncher = inventoryScreenLauncher;
        this.shopScreenLauncher = shopScreenLauncher;
        this.errorScreenLauncher = errorScreenLauncher;
        this.finishedScreenLauncher = finishedScreenLauncher;
        this.roundOneInventoryScreenLauncher = roundOneInventoryScreenLauncher; //TODO add call for inventory button
        this.roundOneGameScreenLauncher = roundOneGameScreenLauncher;
        this.clearScreen = clearScreen;
        launchSetupScreen();
    }
    public void setSetup(Setup setup){
        setName(setup.getName());
        setRounds(setup.getNumRounds());
    }
    public void setCurrRound()  {currRound = 1; }
    public void incrementRound() { currRound += 1; } // TODO check for round == to max rounds, if so then terminate
    public int getCurrRound() { return currRound; }
    public void launchSetupScreen() { setupScreenLauncher.accept(this); }
    public void launchBetweenRoundsScreen() { betweenScreenLauncher.accept(this); }
    public void launchFinishedScreen() { finishedScreenLauncher.accept(this); }
    public void launchGameScreen() { gameScreenLauncher.accept(this); }
    public void launchShopScreen() { setupScreenLauncher.accept(this); }
    public void launchInventoryScreen() { setupScreenLauncher.accept(this); }
    public void launchRoundOneInventoryScreen() { roundOneInventoryScreenLauncher.accept(this); }
    public void launchRoundOneGameScreen() { roundOneGameScreenLauncher.accept(this); }
    public void launchErrorScreen() { errorScreenLauncher.accept(this); }
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }
    public void setRounds(Long rounds) { this.rounds = rounds; }
    public Long getRounds() { return rounds; }
    public void setDifficulty(DifficultyService difficulty) { this.difficulty = difficulty; }
    public Double getDifficulty() {return difficulty.getDifficulty();}
    public void setMoney(MoneyService money) { this.money = money; }
    public int getMoney() { return money.getCurrentAmount(); }
    public void startPoints() { this.points = 0; }
    public void incrementPoints() { this.points += 100*getDifficulty(); }
    public double getPoints() { return points; }

    public void closeSetupScreen() {
//        clearScreen.run();
        if (getName().length() < 3 || getName().length() > 15 || !getName().matches("[a-zA-Z0-9]+")) {
            launchErrorScreen(); }
        else { launchBetweenRoundsScreen(); } }

    public void closeBetweenRoundScreen() {
//        clearScreen.run();
        if (this.getCurrRound() == 2) { // TODO change to 1 when round screen is fixed
            launchRoundOneGameScreen();
        }
        else {
            launchShopScreen();
        }
    }
    public void openRoundOneInventoryScreen() {
        launchRoundOneInventoryScreen();
    }
    public void openInventoryScreen(){
        launchInventoryScreen();
    }
    public void closeGameScreen(){
//        clearScreen.run();
        if (getCurrRound() <= getRounds()) {
        launchBetweenRoundsScreen(); }
        else {
            launchFinishedScreen();
        }
    }
    public void closeInvalidNameScreen(){
        launchSetupScreen();
    }
}
