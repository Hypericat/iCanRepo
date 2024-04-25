public enum Sound {
    C("C"),
    Cs("C#"),
    D("D"),
    Eb("Eb"),
    E("E"),
    F("F"),
    Fs("F#"),
    G("G"),
    Gs("G#"),
    A("A"),
    Bb("Bb"),
    B("B");
    private String note;
    Sound(String note) {
        this.note = note;
    }
    public String getNote() {
        return note;
    }
}
