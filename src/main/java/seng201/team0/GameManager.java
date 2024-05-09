package seng201.team0;
import seng201.team0.models.Setup;
import java.util.function.Consumer;

/**
 *
 * Class that manages all the game information
 *
 */

public class GameManager {
    private String name;
    private Long rounds;
    private Long difficulty;
    private final Consumer<GameManager> setupScreenLauncher;
    private final Runnable clearScreen;
    public GameManager(Consumer<GameManager> setupScreenLauncher, Consumer<GameManager> mainScreenLauncher, Runnable clearScreen){
        this.setupScreenLauncher = setupScreenLauncher;
        this.clearScreen = clearScreen;
        launchSetupScreen();
    }
    public void setSetup(Setup setup){
        setName(setup.getName());
        setRounds(setup.getNumRounds());
        setDifficulty(setup.getDifficulty());
    }
    public void launchSetupScreen() {
        setupScreenLauncher.accept(this);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRounds(Long rounds) { this.rounds = rounds; }
    public Long getRounds() {
        return rounds;
    }
    public void setDifficulty(Long difficulty) { this.difficulty = difficulty; }
    public Long getDifficulty() {
        return difficulty;
    }

    public void closeSetupScreen() {
        clearScreen.run();
//        launchMainScreen();
    }
}
