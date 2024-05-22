package seng201.team0;
import javafx.scene.control.Button;
import seng201.team0.models.Setup;
import seng201.team0.models.Tower;
import seng201.team0.services.DifficultyService;
import seng201.team0.services.MoneyService;
import seng201.team0.services.RoundService;

import java.util.ArrayList;
import java.util.List;
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
    private int roundTrackLength;
    private List<Tower> roundOneTowerList;
    private Tower[] roundOneSelectedTowerList;
    private Tower[] genericRoundTowerList;
    private List<Button> roundOneSelectedTowerButtons;
    private int trackLengthIndex;
    private final Consumer<GameManager> setupScreenLauncher;
    private final Consumer<GameManager> betweenScreenLauncher;
    private final Consumer<GameManager> gameScreenLauncher;
    private final Consumer<GameManager> inventoryScreenLauncher;
    private final Consumer<GameManager> shopScreenLauncher;
    private final Consumer<GameManager> roundOneInventoryScreenLauncher;
    private final Consumer<GameManager> roundOneGameScreenLauncher;
    private final Consumer<GameManager> errorScreenLauncher;
    private final Consumer<GameManager> finishedScreenLauncher;
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
        launchSetupScreen();
    }
    public void setSetup(Setup setup){
        setName(setup.getName());
        setRounds(setup.getNumRounds());
        this.money.editMoney(100*difficulty.getDifficulty());
        setRoundTrackLength(100);
    }
    public void setCurrRound()  {currRound = 1; }
    public void setRoundTrackLength(int trackLength) { roundTrackLength = trackLength; }
    public int getRoundTrackLength() { return roundTrackLength; }
    public void incrementRound() { currRound += 1; } // TODO check for round == to max rounds, if so then terminate
    public int getCurrRound() { return currRound; }
    public void launchSetupScreen() { setupScreenLauncher.accept(this); }
    public void launchBetweenRoundsScreen() { betweenScreenLauncher.accept(this); }
    public void launchFinishedScreen() { finishedScreenLauncher.accept(this); }
    public void launchGameScreen() { gameScreenLauncher.accept(this); }
    public void launchShopScreen() { shopScreenLauncher.accept(this); }
    public void launchInventoryScreen() { inventoryScreenLauncher.accept(this); }
    public void launchRoundOneInventoryScreen() { roundOneInventoryScreenLauncher.accept(this); }
    public void launchRoundOneGameScreen() { roundOneGameScreenLauncher.accept(this); }
    public void launchErrorScreen() { errorScreenLauncher.accept(this); }
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }
    public void setRounds(Long rounds) { this.rounds = rounds; }
    public Long getRounds() { return rounds; }
    public void setDifficulty(DifficultyService difficulty) { this.difficulty = difficulty; } //TODO FIX THIS NONSENSE
    public Double getDifficulty() {return difficulty.getDifficulty();}
    public DifficultyService getDifficultyService() {return difficulty;}

    public void setMoney(MoneyService money) { this.money = money; }
    public double getMoneyAmount() { return money.getCurrentAmount(); }
    public MoneyService getMoneyService() { return money; }
    public void startPoints() { this.points = 0; }
    public void incrementPoints() { this.points += 100*getDifficulty(); }
    public double getPoints() { return points; }
    public void setRoundOneSelectedTowerButtons(List<Button> roundOneSelectedTowerButtons) {this.roundOneSelectedTowerButtons = roundOneSelectedTowerButtons; }
    public List<Button> getRoundOneSelectedTowerButtons() {return roundOneSelectedTowerButtons; }
    public void setRoundOneTowerList(List<Tower> roundOneTowerList){
        System.out.println(roundOneTowerList.get(0).getHealth());
        this.roundOneTowerList = roundOneTowerList;
    }
    public List<Tower> getRoundOneTowerList(){
        return roundOneTowerList;
    }
    public void setRoundOneSelectedTowerList(Tower[] roundOneSelectedTowerList){
        this.roundOneSelectedTowerList = roundOneSelectedTowerList; }
    public Tower[] getRoundOneSelectedTowerList(){ return roundOneSelectedTowerList; }
    public boolean isRoundOneSelectedTowerListNull(){ return roundOneSelectedTowerList == null;}
    public List<Integer> getRoundOneTowerListIndices(){
        List<Integer> roundOneTowerIndices = new ArrayList<Integer>();
        if (this.roundOneSelectedTowerList != null) {
            for (int i = 0; i < this.roundOneSelectedTowerList.length; i++) {
                if (roundOneSelectedTowerList[i] != null) {
                    roundOneTowerIndices.add(i);
                }
            }
        }
        return roundOneTowerIndices;
    }
    public void setGenericRoundTowerList(Tower[] genericRoundTowerList){
        this.genericRoundTowerList = genericRoundTowerList;
    }
    public Tower[] getGenericRoundTowerList(){
        return genericRoundTowerList;
    }

    public void setTrackLengthIndex(int index){
        this.trackLengthIndex = index;
    }
    public int getTrackLengthIndex(){
        return trackLengthIndex;
    }

    public void closeSetupScreen() {
        if (getName().length() < 3 || getName().length() > 15 || !getName().matches("[a-zA-Z0-9]+")) {
            launchErrorScreen(); }
        else { launchBetweenRoundsScreen(); } }

    public void closeBetweenRoundScreen() {
        if (this.getCurrRound() == 2) { // TODO change to 1 when round screen is fixed
            launchRoundOneGameScreen();
        }
        else {
            launchGameScreen();
        }
    }
    public void openRoundOneInventoryScreen() {
        launchRoundOneInventoryScreen();
    }
    public void openInventoryScreen(){
        launchInventoryScreen();
    }
    public void closeRoundOneInventoryScreen(){
        launchBetweenRoundsScreen();
    }
    public void openShopScreen(){
        launchShopScreen();
    }
    public void closeGameScreen(){
        if (getCurrRound() <= getRounds()) {
            RoundService.completeRound(this);
            launchBetweenRoundsScreen();
        }
        else {
            launchFinishedScreen();
        }
    }
    public void closeInvalidNameScreen(){
        launchSetupScreen();
    }


}
