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
 * Manages all the game information including player stats, game progress, and interactions
 * with various services and screens.
 */
public class GameManager {
    /**
     * The name of the player.
     */
    private String name;

    /**
     * The total number of rounds.
     */
    private Long rounds;

    /**
     * Service to manage difficulty settings.
     */
    private DifficultyService difficulty;

    /**
     * The current round number.
     */
    private int currRound;

    /**
     * Service to manage in-game currency.
     */
    private MoneyService money;

    /**
     * The total points accumulated.
     */
    private double points;

    /**
     * The length of the track for each round.
     */
    private int roundTrackLength;

    /**
     * List of towers available in round one.
     */
    private List<Tower> roundOneTowerList;

    /**
     * Array to store selected towers for round one.
     */
    private Tower[] roundOneSelectedTowerList;

    /**
     * List of towers available for all rounds.
     */
    private List<Tower> genericRoundTowerList;

    /**
     * List of buttons for selected towers in round one.
     */
    private List<Button> roundOneSelectedTowerButtons;

    /**
     * Index to track the length of the track.
     */
    private int trackLengthIndex;

    /**
     * Number of available healing items.
     */
    private int availableHeals;

    /**
     * Number of available revive items.
     */
    private int availableRevives;

    /**
     * Number of available tower upgrades.
     */
    private int availableUpgrades;

    /**
     * Total net worth in the game.
     */
    private int netWorth;

    /**
     * List of cheapest towers available.
     */
    private List<Tower> cheapestTowers;

    /**
     * Array to store towers in slots.
     */
    private Tower[] towersInSlots = new Tower[5];

    /**
     * Service to manage the in-game shop.
     */
    private ShopService shopService;

    /**
     * Flag indicating if it's the first time in the inventory screen.
     */
    private boolean firstTimeInInventory;

    /**
     * Consumer function to launch setup screen.
     */
    private final Consumer<GameManager> setupScreenLauncher;

    /**
     * Consumer function to launch between screen.
     */
    private final Consumer<GameManager> betweenScreenLauncher;

    /**
     * Consumer function to launch game screen.
     */
    private final Consumer<GameManager> gameScreenLauncher;

    /**
     * Consumer function to launch inventory screen.
     */
    private final Consumer<GameManager> inventoryScreenLauncher;

    /**
     * Consumer function to launch shop screen.
     */
    private final Consumer<GameManager> shopScreenLauncher;

    /**
     * Consumer function to launch round one inventory screen.
     */
    private final Consumer<GameManager> roundOneInventoryScreenLauncher;

    /**
     * Consumer function to launch round one game screen.
     */
    private final Consumer<GameManager> roundOneGameScreenLauncher;

    /**
     * Consumer function to launch error screen.
     */
    private final Consumer<GameManager> errorScreenLauncher;

    /**
     * Consumer function to launch finished screen.
     */
    private final Consumer<GameManager> finishedScreenLauncher;

    /**
     * Consumer function to launch losing screen.
     */
    private final Consumer<GameManager> losingScreenLauncher;


    /**
     * Constructor for the GameManager class.
     * Initializes the screen launchers and services, and launches the setup screen.
     *
     * @param setupScreenLauncher Consumer to launch the setup screen
     * @param betweenScreenLauncher Consumer to launch the between rounds screen
     * @param gameScreenLauncher Consumer to launch the game screen
     * @param inventoryScreenLauncher Consumer to launch the inventory screen
     * @param shopScreenLauncher Consumer to launch the shop screen
     * @param roundOneInventoryScreenLauncher Consumer to launch the round one inventory screen
     * @param roundOneGameScreenLauncher Consumer to launch the round one game screen
     * @param errorScreenLauncher Consumer to launch the error screen
     * @param finishedScreenLauncher Consumer to launch the finished screen
     * @param losingScreenLauncher Consumer to launch the losing screen
     * @param clearScreen Runnable to clear the screen
     */
    public GameManager(Consumer<GameManager> setupScreenLauncher, Consumer<GameManager> betweenScreenLauncher, Consumer<GameManager> gameScreenLauncher, Consumer<GameManager> inventoryScreenLauncher, Consumer<GameManager> shopScreenLauncher, Consumer<GameManager> roundOneInventoryScreenLauncher, Consumer<GameManager> roundOneGameScreenLauncher, Consumer<GameManager> errorScreenLauncher, Consumer<GameManager> finishedScreenLauncher, Consumer<GameManager> losingScreenLauncher, Runnable clearScreen) {
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

    /**
     * Sets up the initial game settings.
     *
     * @param setup The setup object containing initial game settings.
     */
    public void setSetup(Setup setup) {
        setName(setup.getName());
        setRounds(setup.getNumRounds());
        money.editMoney(1500);
    }

    /**
     * Buys a tower using the shop service.
     *
     * @param tower The tower to be bought.
     */
    public void buyTower(Tower tower) {
        shopService.buyTower(tower);
    }

    /**
     * Sells a tower using the shop service.
     *
     * @param tower The tower to be sold.
     */
    public void sellTower(Tower tower) {
        shopService.sellTower(tower);
    }

    /**
     * Buys an item using the shop service.
     *
     * @param item The item to be bought.
     */
    public void buyItem(String item) {
        shopService.buyItem(item);
    }

    /**
     * Sells an item using the shop service.
     *
     * @param item The item to be sold.
     */
    public void sellItem(String item) {
        shopService.sellItem(item);
    }

    /**
     * Sets the current round to 1.
     */
    public void setCurrRound() {
        currRound = 1;
    }

    /**
     * Sets the length of the current round track.
     *
     * @param trackLength The length of the round track.
     */
    public void setRoundTrackLength(int trackLength) {
        roundTrackLength = trackLength;
    }

    /**
     * Gets the length of the current round track.
     *
     * @return The length of the round track.
     */
    public int getRoundTrackLength() {
        return roundTrackLength;
    }

    /**
     * Gets the net worth.
     *
     * @return The net worth.
     */
    public int getNetWorth() {
        return netWorth;
    }

    /**
     * Sets the net worth.
     *
     * @param value The new net worth value.
     */
    public void setNetWorth(int value) {
        netWorth = value;
    }

    /**
     * Calculates the sum of the buy prices of the five cheapest towers.
     *
     * @param genericRoundTowerList The list of towers to consider.
     * @return The sum of the buy prices of the five cheapest towers.
     */
    public double getCheapestTowersSum(List<Tower> genericRoundTowerList) {
        List<Tower> sortedList = new ArrayList<>(genericRoundTowerList);
        Collections.sort(sortedList, Comparator.comparingDouble(Tower::getBuyPrice));
        double sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += sortedList.get(i).getBuyPrice();
        }
        return sum;
    }

    /**
     * Increments the current round number.
     */
    public void incrementRound() {
        currRound += 1;
    }

    /**
     * Gets the current round number.
     *
     * @return The current round number.
     */
    public int getCurrRound() {
        return currRound;
    }

    /**
     * Launches the setup screen.
     */
    public void launchSetupScreen() {
        setupScreenLauncher.accept(this);
    }

    /**
     * Launches the between rounds screen.
     */
    public void launchBetweenRoundsScreen() {
        betweenScreenLauncher.accept(this);
    }

    /**
     * Launches the finished screen.
     */
    public void launchFinishedScreen() {
        finishedScreenLauncher.accept(this);
    }

    /**
     * Launches the game screen.
     */
    public void launchGameScreen() {
        gameScreenLauncher.accept(this);
    }

    /**
     * Launches the shop screen.
     */
    public void launchShopScreen() {
        shopScreenLauncher.accept(this);
    }

    /**
     * Launches the inventory screen.
     */
    public void launchInventoryScreen() {
        inventoryScreenLauncher.accept(this);
    }

    /**
     * Launches the round one inventory screen.
     */
    public void launchRoundOneInventoryScreen() {
        roundOneInventoryScreenLauncher.accept(this);
    }

    /**
     * Launches the round one game screen.
     */
    public void launchRoundOneGameScreen() {
        roundOneGameScreenLauncher.accept(this);
    }

    /**
     * Launches the losing screen.
     */
    public void launchLosingScreen() {
        losingScreenLauncher.accept(this);
    }

    /**
     * Launches the error screen.
     */
    public void launchErrorScreen() {
        errorScreenLauncher.accept(this);
    }

    /**
     * Increments the available heals by 1.
     */
    public void incrementHeals() {
        availableHeals += 1;
    }

    /**
     * Increments the available revives by 1.
     */
    public void incrementRevives() {
        availableRevives += 1;
    }

    /**
     * Increments the available upgrades by 1.
     */
    public void incrementUpgrades() {
        availableUpgrades += 1;
    }

    /**
     * Decrements the available heals by 1.
     */
    public void decrementHeals() {
        availableHeals -= 1;
    }

    /**
     * Decrements the available revives by 1.
     */
    public void decrementRevives() {
        availableRevives -= 1;
    }

    /**
     * Decrements the available upgrades by 1.
     */
    public void decrementUpgrades() {
        availableUpgrades -= 1;
    }

    /**
     * Gets the name of the game.
     *
     * @return The game name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the game.
     *
     * @param name The new game name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the number of rounds.
     *
     * @param rounds The number of rounds.
     */
    public void setRounds(Long rounds) {
        this.rounds = rounds;
    }

    /**
     * Gets the number of rounds.
     *
     * @return The number of rounds.
     */
    public Long getRounds() {
        return rounds;
    }

    /**
     * Sets the difficulty service.
     *
     * @param difficulty The difficulty service.
     */
    public void setDifficulty(DifficultyService difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Gets the current difficulty level.
     *
     * @return The difficulty level.
     */
    public Double getDifficulty() {
        return difficulty.getDifficulty();
    }

    /**
     * Gets the difficulty service.
     *
     * @return The difficulty service.
     */
    public DifficultyService getDifficultyService() {
        return difficulty;
    }

    /**
     * Sets the money service.
     *
     * @param money The money service.
     */
    public void setMoney(MoneyService money) {
        this.money = money;
    }

    /**
     * Gets the current amount of money.
     *
     * @return The current amount of money.
     */
    public double getMoneyAmount() {
        return money.getCurrentAmount();
    }

    /**
     * Gets the money service.
     *
     * @return The money service.
     */
    public MoneyService getMoneyService() {
        return money;
    }

    /**
     * Starts the points at 0.
     */
    public void startPoints() {
        points = 0;
    }

    /**
     * Increments the points based on the current difficulty level.
     */
    public void incrementPoints() {
        points += 100 * getDifficulty();
    }

    /**
     * Gets the current points.
     *
     * @return The current points.
     */
    public double getPoints() {
        return points;
    }

    /**
     * Gets the towers in the slots.
     *
     * @return The array of towers in the slots.
     */
    public Tower[] getTowersInSlots() {
        return towersInSlots;
    }

    /**
     * Sets the towers in the slots.
     *
     * @param towersInSlots The array of towers to set in the slots.
     */
    public void setTowersInSlots(Tower[] towersInSlots) {
        this.towersInSlots = towersInSlots;
    }

    /**
     * Sets the selected tower buttons for round one.
     *
     * @param roundOneSelectedTowerButtons The list of selected tower buttons.
     */
    public void setRoundOneSelectedTowerButtons(List<Button> roundOneSelectedTowerButtons) {
        this.roundOneSelectedTowerButtons = roundOneSelectedTowerButtons;
    }

    /**
     * Gets the selected tower buttons for round one.
     *
     * @return The list of selected tower buttons.
     */
    public List<Button> getRoundOneSelectedTowerButtons() {
        return roundOneSelectedTowerButtons;
    }

    /**
     * Sets the tower list for round one.
     *
     * @param roundOneTowerList The list of towers for round one.
     */
    public void setRoundOneTowerList(List<Tower> roundOneTowerList) {
        System.out.println(roundOneTowerList.get(0).getHealth());
        this.roundOneTowerList = roundOneTowerList;
    }

    /**
     * Gets the tower list for round one.
     *
     * @return The list of towers for round one.
     */
    public List<Tower> getRoundOneTowerList() {
        return roundOneTowerList;
    }

    /**
     * Sets the selected tower list for round one.
     *
     * @param roundOneSelectedTowerList The array of selected towers for round one.
     */
    public void setRoundOneSelectedTowerList(Tower[] roundOneSelectedTowerList) {
        this.roundOneSelectedTowerList = roundOneSelectedTowerList;
    }

    /**
     * Gets the selected tower list for round one.
     *
     * @return The array of selected towers for round one.
     */
    public Tower[] getRoundOneSelectedTowerList() {
        return roundOneSelectedTowerList;
    }

    /**
     * Checks if the selected tower list for round one is null.
     *
     * @return True if the selected tower list for round one is null, false otherwise.
     */
    public boolean isRoundOneSelectedTowerListNull() {
        return roundOneSelectedTowerList == null;
    }

    /**
     * Checks if the generic round tower list is null.
     *
     * @return True if the generic round tower list is null, false otherwise.
     */
    public boolean isGenericRoundTowerListNull() {
        return genericRoundTowerList == null;
    }

    /**
     * Gets the indices of the selected towers for round one.
     *
     * @return A list of indices of the selected towers for round one.
     */
    public List<Integer> getRoundOneTowerListIndices() {
        List<Integer> roundOneTowerIndices = new ArrayList<>();
        if (this.roundOneSelectedTowerList != null) {
            for (int i = 0; i < this.roundOneSelectedTowerList.length; i++) {
                if (roundOneSelectedTowerList[i] != null) {
                    roundOneTowerIndices.add(i);
                }
            }
        }
        return roundOneTowerIndices;
    }

    /**
     * Gets the indices of the generic round towers.
     *
     * @return A list of indices of the generic round towers.
     */
    public List<Integer> getGenericRoundTowerListIndices() {
        List<Integer> genericRoundTowerListIndices = new ArrayList<>();
        if (this.genericRoundTowerList != null) {
            for (int i = 0; i < this.genericRoundTowerList.size(); i++) {
                if (genericRoundTowerList.get(i) != null) {
                    genericRoundTowerListIndices.add(i);
                }
            }
        }
        return genericRoundTowerListIndices;
    }

    /**
     * Sets the generic round tower list.
     *
     * @param genericRoundTowerList The list of generic round towers.
     */
    public void setGenericRoundTowerList(List<Tower> genericRoundTowerList) {
        this.genericRoundTowerList = genericRoundTowerList;
    }

    /**
     * Gets the generic round tower list.
     *
     * @return The list of generic round towers.
     */
    public List<Tower> getGenericRoundTowerList() {
        return genericRoundTowerList;
    }

    /**
     * Gets the number of available heals.
     *
     * @return The number of available heals.
     */
    public int getAvailableHeals() {
        return availableHeals;
    }

    /**
     * Gets the number of available revives.
     *
     * @return The number of available revives.
     */
    public int getAvailableRevives() {
        return availableRevives;
    }

    /**
     * Gets the number of available upgrades.
     *
     * @return The number of available upgrades.
     */
    public int getAvailableUpgrades() {
        return availableUpgrades;
    }

    /**
     * Consumes a heal.
     */
    public void consumeHeal() {
        availableHeals -= 1;
    }

    /**
     * Consumes a revive.
     */
    public void consumeRevive() {
        availableRevives -= 1;
    }

    /**
     * Consumes an upgrade.
     */
    public void consumeUpgrade() {
        availableUpgrades -= 1;
    }

    /**
     * Sets the track length index.
     *
     * @param index The track length index.
     */
    public void setTrackLengthIndex(int index) {
        trackLengthIndex = index;
    }

    /**
     * Gets the track length index.
     *
     * @return The track length index.
     */
    public int getTrackLengthIndex() {
        return trackLengthIndex;
    }

    /**
     * Checks if it is not the first time in the inventory.
     *
     * @return True if it is not the first time in the inventory, false otherwise.
     */
    public boolean isNotFirstTimeInInventory() {
        return firstTimeInInventory;
    }

    /**
     * Sets whether it is the first time in the inventory.
     *
     * @param firstTimeInInventory True if it is the first time in the inventory, false otherwise.
     */
    public void setNotFirstTimeInInventory(boolean firstTimeInInventory) {
        this.firstTimeInInventory = firstTimeInInventory;
    }

    /**
     * Closes the setup screen and launches the next screen based on the name validity.
     */
    public void closeSetupScreen() {
        if (getName().length() < 3 || getName().length() > 15 || !getName().matches("[a-zA-Z0-9]+")) {
            launchErrorScreen();
        } else {
            launchBetweenRoundsScreen();
        }
    }

    /**
     * Closes the between round screen and launches the appropriate game screen.
     */
    public void closeBetweenRoundScreen() {
        if (this.getCurrRound() == 2) {
            launchRoundOneGameScreen();
        } else {
            launchGameScreen();
        }
    }

    /**
     * Launches the round one inventory screen.
     */
    public void openRoundOneInventoryScreen() {
        launchRoundOneInventoryScreen();
    }
    /**
     * Launches generic inventory screen.
     */
    public void openInventoryScreen(){
        launchInventoryScreen();
    }

    /**
     * Launches between rounds screen.
     */
    public void closeRoundOneInventoryScreen(){
        launchBetweenRoundsScreen();
    }

    /**
     * Launches shop screen.
     */
    public void openShopScreen(){
        launchShopScreen();
    }

    /**
     * Launches between round screen or launches finished screen if it's the last round.
     */
    public void closeGameScreen(){
        if (getCurrRound() <= getRounds()) {
            RoundService.completeRound(this);
            launchBetweenRoundsScreen();
        }
        else {
            launchFinishedScreen();
        }
    }

    /**
     * Launches setup screen.
     */
    public void closeInvalidNameScreen(){
        launchSetupScreen();
    }

    /**
     * Launches losing screen.
     */
    public void openLosingScreen() {
        launchLosingScreen();
    }
}
