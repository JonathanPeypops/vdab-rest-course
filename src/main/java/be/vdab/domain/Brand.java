package be.vdab.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Brand {
    @Id
    private int id;
    private String brand;

    public Brand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand.toString();
    }

    public void setName(String brand) {
        this.brand = brand;
    }

    public Brand() {
    }
}
