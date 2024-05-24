package seng201.team0;
import javafx.scene.control.Button;
import seng201.team0.models.Setup;
import seng201.team0.models.Tower;
import seng201.team0.services.DifficultyService;
import seng201.team0.services.MoneyService;
import seng201.team0.services.RoundService;
import seng201.team0.services.ShopService;

import java.util.*;
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
    private List<Tower> genericRoundTowerList;
    private List<Button> roundOneSelectedTowerButtons;
    private int trackLengthIndex;
    private int availableHeals;
    private int availableRevives;
    private int availableUpgrades;
    private int netWorth;
    private List<Tower> cheapestTowers;
    private Tower[] towersInSlots = new Tower[5];
    private ShopService shopService;
    private boolean firstTimeInInventory;
    private final Consumer<GameManager> setupScreenLauncher;
    private final Consumer<GameManager> betweenScreenLauncher;
    private final Consumer<GameManager> gameScreenLauncher;
    private final Consumer<GameManager> inventoryScreenLauncher;
    private final Consumer<GameManager> shopScreenLauncher;
    private final Consumer<GameManager> roundOneInventoryScreenLauncher;
    private final Consumer<GameManager> roundOneGameScreenLauncher;
    private final Consumer<GameManager> errorScreenLauncher;
    private final Consumer<GameManager> finishedScreenLauncher;
    private final Consumer<GameManager> losingScreenLauncher;
    public GameManager(Consumer<GameManager> setupScreenLauncher, Consumer<GameManager> betweenScreenLauncher, Consumer<GameManager> gameScreenLauncher, Consumer<GameManager> inventoryScreenLauncher, Consumer<GameManager> shopScreenLauncher, Consumer<GameManager> roundOneInventoryScreenLauncher, Consumer<GameManager> roundOneGameScreenLauncher, Consumer<GameManager> errorScreenLauncher, Consumer<GameManager> finishedScreenLauncher,Consumer<GameManager> losingScreenLauncher, Runnable clearScreen){
        this.setupScreenLauncher = setupScreenLauncher;
        this.betweenScreenLauncher = betweenScreenLauncher;
        this.gameScreenLauncher = gameScreenLauncher;
        this.inventoryScreenLauncher = inventoryScreenLauncher;
        this.shopScreenLauncher = shopScreenLauncher;
        this.errorScreenLauncher = errorScreenLauncher;
        this.finishedScreenLauncher = finishedScreenLauncher;
        this.roundOneInventoryScreenLauncher = roundOneInventoryScreenLauncher;
        this.roundOneGameScreenLauncher = roundOneGameScreenLauncher;
        this.losingScreenLauncher = losingScreenLauncher;
        this.shopService = new ShopService(this);
        launchSetupScreen();
    }
    public void setSetup(Setup setup){
        setName(setup.getName());
        setRounds(setup.getNumRounds());
        money.editMoney(1500);
    }
    public void buyTower(Tower tower) {
        shopService.buyTower(tower);
    }

    public void sellTower(Tower tower) {
        shopService.sellTower(tower);
    }

    public void buyItem(String item) {
        shopService.buyItem(item);
    }

    public void sellItem(String item) {
        shopService.sellItem(item);
    }
    public void setCurrRound()  {currRound = 1; }
    public void setRoundTrackLength(int trackLength) { roundTrackLength = trackLength; }
    public int getRoundTrackLength() { return roundTrackLength; }
    public int getNetWorth() {
        return netWorth;
    }
    public void setNetWorth(int value) {
        netWorth = value;
    }

    public double getCheapestTowersSum(List<Tower> genericRoundTowerList) {
        List<Tower> sortedList = new ArrayList<>(genericRoundTowerList);
        Collections.sort(sortedList, Comparator.comparingDouble(Tower::getBuyPrice));
        double sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += sortedList.get(i).getBuyPrice();
        }

        return sum;
    }
    public void incrementRound() { currRound += 1; }
    public int getCurrRound() { return currRound; }
    public void launchSetupScreen() { setupScreenLauncher.accept(this); }
    public void launchBetweenRoundsScreen() { betweenScreenLauncher.accept(this); }
    public void launchFinishedScreen() { finishedScreenLauncher.accept(this); }
    public void launchGameScreen() { gameScreenLauncher.accept(this); }
    public void launchShopScreen() { shopScreenLauncher.accept(this); }
    public void launchInventoryScreen() { inventoryScreenLauncher.accept(this); }
    public void launchRoundOneInventoryScreen() { roundOneInventoryScreenLauncher.accept(this); }
    public void launchRoundOneGameScreen() { roundOneGameScreenLauncher.accept(this); }
    public void launchLosingScreen() { losingScreenLauncher.accept(this); }
    public void launchErrorScreen() { errorScreenLauncher.accept(this); }
    public void incrementHeals() {
        availableHeals += 1;
    }
    public void incrementRevives() {
        availableRevives += 1;
    }
    public void incrementUpgrades() {
        availableUpgrades += 1;
    }

    public void decrementHeals() {
        availableHeals -= 1;
    }

    public void decrementRevives() {
        availableRevives -= 1;
    }
    public void decrementUpgrades() {
        availableUpgrades -= 1;
    }
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }
    public void setRounds(Long rounds) { this.rounds = rounds; }
    public Long getRounds() { return rounds; }
    public void setDifficulty(DifficultyService difficulty) { this.difficulty = difficulty; }
    public Double getDifficulty() {return difficulty.getDifficulty();}
    public DifficultyService getDifficultyService() {return difficulty;}

    public void setMoney(MoneyService money) { this.money = money; }
    public double getMoneyAmount() { return money.getCurrentAmount(); }
    public MoneyService getMoneyService() { return money; }
    public void startPoints() { points = 0; }
    public void incrementPoints() { points += 100*getDifficulty(); }
    public double getPoints() { return points; }
    public Tower[] getTowersInSlots() {
        return towersInSlots;
    }
    public void setTowersInSlots(Tower[] towersInSlots) {
        this.towersInSlots = towersInSlots;
    }
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
    public boolean isGenericRoundTowerListNull() { return genericRoundTowerList == null;}
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
    public List<Integer> getGenericRoundTowerListIndices(){
        List<Integer> genericRoundTowerListIndices = new ArrayList<Integer>();
        if (this.genericRoundTowerList != null){
            for (int i = 0; i < this.genericRoundTowerList.size(); i++) {
                if (genericRoundTowerList.get(i) != null) {
                    genericRoundTowerListIndices.add(i);
                }
            }
        }
        return genericRoundTowerListIndices;
    }

    public void setGenericRoundTowerList(List<Tower> genericRoundTowerList){
        this.genericRoundTowerList = genericRoundTowerList;
    }
    public List<Tower> getGenericRoundTowerList(){
        return genericRoundTowerList;
    }
    public int getAvailableHeals() {
        return availableHeals;
    }
    public int getAvailableRevives() {
        return availableRevives;
    }

    public int getAvailableUpgrades() {
        return availableUpgrades;
    }
    public void consumeHeal() {
        availableHeals -= 1;
    }
    public void consumeRevive() { availableRevives -= 1; }
    public void consumeUpgrade() {
        availableUpgrades -= 1;
    }

    public void setTrackLengthIndex(int index){
        trackLengthIndex = index;
    }
    public int getTrackLengthIndex(){
        return trackLengthIndex;
    }
    public boolean isNotFirstTimeInInventory() { return firstTimeInInventory;}
    public void setNotFirstTimeInInventory(boolean firstTimeInInventory) {
        this.firstTimeInInventory = firstTimeInInventory;
    }
    public void closeSetupScreen() {
        if (getName().length() < 3 || getName().length() > 15 || !getName().matches("[a-zA-Z0-9]+")) {
            launchErrorScreen(); }
        else { launchBetweenRoundsScreen(); } }

    public void closeBetweenRoundScreen() {
        if (this.getCurrRound() == 2) {
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
    public void openLosingScreen() {
        launchLosingScreen();
    }
}
