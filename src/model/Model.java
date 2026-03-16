package model;

public class Model {
    private Long id;
    private String name;
    private int pricePerDay;

    public Model(Long id, String name, int pricePerDay) {
        this.id = id;
        this.name = name;
        this.pricePerDay = pricePerDay;
    }

    public Model(String name, int pricePerDay) {
        this.name = name;
        this.pricePerDay = pricePerDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getpricePerDay() {
        return pricePerDay;
    }

    public void setpricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + pricePerDay;
    }
}
