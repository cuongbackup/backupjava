package model;

import java.util.Date;

public class Nvtv extends Employee{
    private String cktv;

    public Nvtv(String cktv) {

    }

    public Nvtv(String id, String firstName, String lastName, String age, Date birthDate, String workDate, String cktv) {
        super(id, firstName, lastName, age, birthDate, workDate);
        this.cktv = cktv;
    }

    public String getCktv() {
        return cktv;
    }

    public void setCktv(String cktv) {
        this.cktv = cktv;
    }
    
    @Override
    
    public int getSalary() {
        return Integer.parseInt(super.getWorkDate()) * 1000000 * Integer.parseInt(cktv);
    }
}
