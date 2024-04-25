import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.theory.Note;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class SoundHandler {
    private Player player;
    private Random random;
    private int soundDelayTime;
    public SoundHandler(int soundDelayTime) {
        player = new Player();
        random = new Random();
        this.soundDelayTime = soundDelayTime;
    }
    public void playNote(String note) {
        playNote(note, 0);
    }
    public void playNote(Sound sound) {
        playNote(sound.getNote());
    }
    public void playNote(Sound sound, int offset) {
        playNote(sound.getNote(), offset);
    }
    public void play(Pattern p) {
        player.play(p);
    }
    public void playNote(Sound sound, int offset, double duration) {
        Note note = new Note(sound.getNote() + offset);
        note.setDuration(duration);
        player.play(note);
    }
    public void playNote(String note, int offset) {
        Thread thread = new Thread(new SoundThread(player ,note, offset));
        thread.start();
        try {
            Thread.sleep(soundDelayTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public Pattern getPatternFromMidi(String midi) throws IOException {
        File midiFile = new File("midi\\" + midi);
        Pattern p;
        try {
            p = MidiFileManager.loadPatternFromMidi(midiFile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return p;
    }
    public int getRandPitch() {
        return random.nextInt(2, 8);
    }
    public Sound getRandNote() {
        return Sound.values()[random.nextInt(Sound.values().length)];
    }
    public void playRandNote() {
        playNote(getRandNote(), getRandPitch());
    }

}
