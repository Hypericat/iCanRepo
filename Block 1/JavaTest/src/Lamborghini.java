public class Lamborghini extends Car {

    int gasInefficiency;
    public Lamborghini(int currentGas, int gasCapacity, int gasInefficiency) {
        super(currentGas, gasCapacity);
        this.gasInefficiency = gasInefficiency;
    }
    @Override
    public void drive(int dist) {
        int gasCost = (int) ((float) dist / 5f) * (gasInefficiency / 10);
        if (gasCost < this.getCurrentGas()) {
            this.setCurrentGas(this.getCurrentGas() - gasCost);
            return;
        }
        int distanceTravelled = this.getCurrentGas() * 5;
        this.setCurrentGas(0);
        System.out.println("Ran out of gas, travelled " + distanceTravelled + " units. " + (dist - distanceTravelled) + " units left.");
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "gasInefficiency : " + gasInefficiency;
    }

    public int getGasInefficiency() {
        return gasInefficiency;
    }
    public void setGasInefficiency(int inefficiency) {
        this.gasInefficiency = inefficiency;
    }
}
