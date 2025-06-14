// === Worker.java ===
public class Worker {
    private int id;
    private String name;
    private String workerCode;

    public Worker(String name, String workerCode) {
        this.name = name;
        this.workerCode = workerCode;
    }

    public Worker(int id, String name, String workerCode) {
        this.id = id;
        this.name = name;
        this.workerCode = workerCode;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getWorkerCode() { return workerCode; }
}
