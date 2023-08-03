package model;

public class Fresher extends Candidate {
    private int graduationDate;
    private String graduationRank;
    private String graduationSchool;
    
    public Fresher() {
    }

    public Fresher(String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int graduationDate, String graduationRank, String graduationSchool, int typeOfCandidate) {
        super(id, firstName, lastName, birthDate, address, phone, email, typeOfCandidate);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.graduationSchool = graduationSchool;
    }

    public int getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getGraduationSchool() {
        return graduationSchool;
    }

    public void setGraduationSchool(String graduationSchool) {
        this.graduationSchool = graduationSchool;
    }
    
    
}
