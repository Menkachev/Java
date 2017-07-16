package Ferrari;


public class Ferrari implements Cars {


    private String carModel;
    private String carDriverName;

    private String brakes;
    private String gas_pedal;

    public Ferrari(String carModel, String brakes, String gas_pedal, String carDriverName) {

        this.carModel = carModel;
        this.carDriverName = carDriverName;
        this.brakes = brakes;
        this.gas_pedal = gas_pedal;
    }

    @Override
    public String model() {
        return this.carModel;
    }

    @Override
    public String driverName() {
        return this.carDriverName;
    }

    @Override
    public String brakes() {
        return brakes;
    }

    @Override
    public String gas() {
        return gas_pedal;
    }
}
