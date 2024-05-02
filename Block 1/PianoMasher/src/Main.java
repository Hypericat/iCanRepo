import org.jfugue.pattern.Pattern;
import org.jfugue.pattern.PatternProducer;

import javax.sound.midi.Instrument;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SoundHandler handler = new SoundHandler(10);
        Pattern p = handler.getPatternFromMidi("finale.mid");
        handler.play(p);

    }
}