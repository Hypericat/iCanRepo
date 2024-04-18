import java.util.Arrays;

public class ipAddress {
    byte block0;
    byte block1;
    byte block2;
    byte block3;

    public ipAddress(byte block0, byte block1, byte block2, byte block3) {
        this.block0 = (byte) (block0 - 128);
        this.block1 = (byte) (block1 - 128);
        this.block2 = (byte) (block2 - 128);
        this.block3 = (byte) (block3 - 128);
    }
    public ipAddress(int block0, int block1, int block2, int block3) {
        this((byte) block0, (byte) block1, (byte) block2, (byte) block3);
    }
    public ipAddress(String ip) {
        String[] addArray = ip.split("\\.");
        if (addArray.length != 4) throw new IllegalArgumentException("Invalid ip provided");
        for (int i = 0; i < 4; i++) {
            try {
                setBlock(i, Integer.parseInt(addArray[i]));
            } catch (NumberFormatException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public short getBlock0() {
        return (short) (((short) block0) + 128);
    }

    public short getBlock1() {
        return (short) (((short) block1) + 128);
    }

    public short getBlock2() {
        return (short) (((short) block2) + 128);
    }

    public short getBlock3() {
        return (short) (((short) block3) + 128);
    }

    public void setBlock0(int block0) {
        this.block0 = (byte) (block0 - 128);
    }

    public void setBlock1(int block1) {
        this.block1 = (byte) (block1 - 128);
    }

    public void setBlock2(int block2) {
        this.block2 = (byte) (block2 - 128);
    }

    public void setBlock3(int block3) {
        this.block3 = (byte) (block3 - 128);
    }
    public String toString() {
        return getBlock0() + "." + getBlock1() + "." + getBlock2() + "." + getBlock3();
    }
    public void setBlock(int blockIndex, int val) {
        switch (blockIndex) {
            case (0) -> setBlock0(val);
            case (1) -> setBlock1(val);
            case (2) -> setBlock2(val);
            case (3) -> setBlock3(val);
        };
    }
    public short getBlock(int blockIndex) {
        return switch (blockIndex) {
            case (0) -> getBlock0();
            case (1) -> getBlock1();
            case (2) -> getBlock2();
            case (3) -> getBlock3();
            default -> -1;
        };
    }
}
