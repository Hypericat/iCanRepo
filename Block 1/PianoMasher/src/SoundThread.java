import org.jfugue.player.Player;

public class SoundThread implements Runnable {
    private Player player;
    private String sound;
    private int offset;
    public SoundThread(Player player, String sound, int offset) {
        this.player = player;
        this.sound = sound;
        this.offset = offset;
    }
    @Override
    public void run() {
        player.play(sound + offset);
    }
}
