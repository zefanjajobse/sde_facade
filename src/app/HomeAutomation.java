package app;

public class HomeAutomation {
    private Amplifier amp = new Amplifier("Top-O-Line Amplifier");
    private Tuner tuner = new Tuner("Top-O-Line AM/FM Tuner", amp);
    private DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player", amp);
    private CdPlayer cd = new CdPlayer("Top-O-Line CD Player", amp);
    private Projector projector = new Projector("Top-O-Line Projector", dvd);
    private TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
    private Screen screen = new Screen("Theater Screen");
    private PopcornPopper popper = new PopcornPopper("Popcorn Popper");

    /**
     * set the scene for watching a movie in the teather room
     * @param movie the movie to watch
     */
    public void watchMovie(String movie) {
        this.popper.on();
        this.popper.pop();
        this.lights.dim(2);
        this.screen.down();
        this.projector.on();
        this.projector.wideScreenMode();
        this.amp.on();
        this.amp.setDvd(this.dvd);
        this.amp.setSurroundSound();
        this.amp.setVolume(5);
        this.dvd.on();
        this.dvd.play(movie);
    }

    /**
     * returns the scene back to normal after watching the movie
     */
    public void finishMovie() {
        this.popper.off();
        this.lights.on();
        this.screen.up();
        this.projector.off();
        this.amp.off();
        this.dvd.stop();
        this.dvd.eject();
        this.dvd.off();
    }

    /**
     * makes the theater room ready for music
     * @param title title of the song
     */
    public void listenMusic(String title) {
        this.lights.on();
        this.amp.on();
        this.amp.setVolume(5);
        this.amp.setCd(this.cd);
        this.amp.setStereoSound();
        this.cd.on();
        this.cd.play(title);
    }

    /**
     * turn the theater room back to normal
     */
    public void finishMusic() {
        this.amp.off();
        this.cd.eject();
        this.cd.off();
    }

    /**
     * listen to the radio in the theater room
     * @param frequency which radio frequency
     */
    public void listenRadio(double frequency) {
        this.tuner.on();
        this.tuner.setFrequency(frequency);
        this.amp.on();
        this.amp.setVolume(5);
        this.amp.setTuner(this.tuner);
    }

    /**
     * turn the radio back off in the theater room
     */
    public void finishRadio() {
        tuner.off();
        amp.off();
    }
}
