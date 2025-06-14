// === Car.java ===
public class Car {
    private int id;
    private String licensePlate;
    private String model;
    private String color;
    private boolean parked;
    private int ownerId;
    private String parkedByWorkerCode;

    public Car(String licensePlate, String model, String color, boolean parked, int ownerId, String parkedByWorkerCode) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.color = color;
        this.parked = parked;
        this.ownerId = ownerId;
        this.parkedByWorkerCode = parkedByWorkerCode;
    }

    public int getId() { return id; }
    public String getLicensePlate() { return licensePlate; }
    public String getModel() { return model; }
    public String getColor() { return color; }
    public boolean isParked() { return parked; }
    public int getOwnerId() { return ownerId; }
    public String getParkedByWorkerCode() { return parkedByWorkerCode; }
}
