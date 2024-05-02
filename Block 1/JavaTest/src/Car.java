public class Car {
    private final int gasCapacity;
    private int currentGas;

    public Car(int currentGas, int gasCapacity) {
        this.currentGas = currentGas;
        this.gasCapacity = gasCapacity;
    }

    public void drive(int dist) {
        int gasCost = (int) ((float) dist / 5f);
        if (gasCost < this.getCurrentGas()) {
            this.setCurrentGas(this.getCurrentGas() - gasCost);
            return;
        }
        int distanceTravelled = this.getCurrentGas() * 5;
        this.setCurrentGas(0);
        System.out.println("Ran out of gas, travelled " + distanceTravelled + " units. " + (dist - distanceTravelled) + " units left.");
    }

    public void fillGas() {
        this.currentGas = gasCapacity;
    }

    public String toString() {
        return "GasCapacity : " + getGasCapacity() + "\n" +
                "CurrentGas : " + getCurrentGas();
    }

    public int getGasCapacity() {
        return gasCapacity;
    }

    public int getCurrentGas() {
        return currentGas;
    }

    public void setCurrentGas(int currentGas) {
        this.currentGas = currentGas;
    }
}
