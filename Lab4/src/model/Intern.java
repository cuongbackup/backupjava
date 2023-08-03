package model;

public class Intern extends Candidate{
    private String major;
    private String semester;
    private String internSchool;
        
    public Intern() {
    }

    public Intern(String id, String firstName, String lastName, int birthDate, String address, String phone, String email, String major, String semester, String internSchool, int typeOfCandidate) {
        super(id, firstName, lastName, birthDate, address, phone, email, typeOfCandidate);
        this.major = major;
        this.semester = semester;
        this.internSchool = internSchool;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getInternSchool() {
        return internSchool;
    }

    public void setInternSchool(String internSchool) {
        this.internSchool = internSchool;
    }
}
