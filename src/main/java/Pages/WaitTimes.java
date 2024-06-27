package Pages;

public enum WaitTimes {
    SHORT_WAIT(5),
    MEDIUM_WAIT(10),
    LONG_WAIT(30);

    private final int seconds;

    WaitTimes(int seconds) {
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }
}
