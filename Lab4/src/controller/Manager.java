package controller;

import java.util.ArrayList;
import java.util.Calendar;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import model.Enum;
import view.Validation;

public class Manager {
    
    ArrayList<Candidate> candidates = new ArrayList<>();
    
    public void addData() {
        Experience ex1 = new Experience("1", "Nguyen Van", "Hoang", 2000, "Quang Nam", "0963035714", "hoangnguyen@gmail.com", 5, "code", 0);
        candidates.add(ex1);
        Experience ex2 = new Experience("4", "Nguyen Thi", "Hoang", 2003, "Quang Nam", "0963074214", "abc@gmail.com", 8, "code", 0);
        candidates.add(ex2);
        Intern in1 = new Intern("3", "Nguyen Hoa", "Hai", 2002, "Ha Noi", "0986246813", "abc@gmail.com", "PRO211", "Fall", "FPT University", 2); 
        candidates.add(in1);
        Intern in2 = new Intern("6", "Nguyen Van", "Truong", 2003, "Ha Noi", "0985216813", "super@gmail.com", "PRO211", "Fall", "FPT University", 2);
        candidates.add(in2);
        Fresher fresh1 = new Fresher("2", "Phan Van", "Truong", 2001, "Da Nang", "0984481349", "phantruong@gmail.com", 2021, "good", "Da Nang Uni", 2);
        candidates.add(fresh1);
        Fresher fresh2 = new Fresher("5", "Phan Tran", "Long", 2004, "Da Nang", "0984621349", "edf@gmail.com", 2020, "good", "Multi Uni", 1);
        candidates.add(fresh2);
    }

    public void createCandidate(Enum type) {
        while (true) {
            System.out.print("Enter id: ");
            String id = Validation.checkInputString();
            System.out.print("Enter first name: ");
            String firstName = Validation.checkInputString();
            System.out.print("Enter last name: ");
            String lastName = Validation.checkInputString();
            System.out.print("Enter birth date: ");
            int birthDate = Validation.checkInputIntLimit(1900, Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Enter address: ");
            String address = Validation.checkInputString();
            System.out.print("Enter phone: ");
            String phone = Validation.checkInputPhone();
            System.out.print("Enter email: ");
            String email = Validation.checkInputEmail();
            Candidate candidate = new Candidate(id, firstName, lastName, birthDate, address, phone, email, 0);
            switch (type) {
                case Experience:
                    createExperience(candidate);
                    break;
                case Fresher:
                    createFresher(candidate);
                    break;
                case Intern:
                    createIntern(candidate);
                    break;
            }
            System.out.print("Do you want to continue (Y/N): ");
            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }

    public void createExperience(Candidate candidate) {
        System.out.print("Enter year of experience: ");
        int year = Validation.checkInputExprience(candidate.getBirthDate());
        System.out.print("Enter professional skill: ");
        String proSkill = Validation.checkInputString();
        candidates.add(new Experience(candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), year, proSkill, candidate.getTypeOfCandidate()));
    }

    public void createFresher(Candidate candidate) {
        System.out.print("Enter graduated year: ");
        int year = Validation.checkInputGraduation(candidate.getBirthDate());
        System.out.print("Enter rank of graduation: ");
        String rank = Validation.checkInputGraduationRank();
        System.out.print("Enter where student graduated: ");
        String graduate = Validation.checkInputString();
        candidates.add(new Fresher(candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), year, rank, graduate, candidate.getTypeOfCandidate()));
    }

    public void createIntern(Candidate candidate) {
        System.out.print("Enter major: ");
        String major = Validation.checkInputString();
        System.out.print("Enter semester: ");
        String semester = Validation.checkInputString();
        System.out.print("Enter university name: ");
        String internSchool = Validation.checkInputString();
        candidates.add(new Intern(candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), major, semester, internSchool, candidate.getTypeOfCandidate()));
    }

    public void searchCandidate() {
        if (candidates.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            printListNameCandidate();
            System.out.print("\nEnter candidate name: ");
            String nameSearch = Validation.checkInputString();
            String search = nameSearch.toLowerCase();
            for (Candidate candidate : candidates) {
                String fullname = candidate.getFirstName().concat(" ").concat(candidate.getLastName());
                String full = fullname.toLowerCase();
                if (full.contains(search)) {
                    System.out.println(candidate.toString());
                }
            }
        }
    }
       
    public void printListNameCandidate() {
        System.out.println("\nExperience Candidates: ");
        String alignment1 = "| %-8s | %-20s | %-20s | %-10d | %-20s | %-12s | %-22s | %-20d | %-10s\n";
        System.out
                .format("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
        System.out
                .format("| ID       | First Name           | Last Name            | Birth date | Address              | Phone        | Email                  | Years of experience  | Prof skill\n");
        for (int i = 0; i < candidates.size(); i++) {
            if (candidates.get(i) instanceof Experience) {
                System.out.format(alignment1, candidates.get(i).getId(), candidates.get(i).getFirstName(),
                        candidates.get(i).getLastName(), candidates.get(i).getBirthDate(),
                        candidates.get(i).getAddress(), candidates.get(i).getPhone(), candidates.get(i).getEmail(),
                        ((Experience) candidates.get(i)).getYearExperience(), ((Experience) candidates.get(i)).getProfessionalSkill());
            }
        }
        System.out.println("\nFresher Candidates: ");
        String alignment2 = "| %-8s | %-20s | %-20s | %-10d | %-20s | %-12s | %-22s | %-9d | %-9s | %-10s\n";
        System.out
                .format("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
        System.out
                .format("| ID       | First Name           | Last Name            | Birth date | Address              | Phone        | Email                  | Grad date | Grad rank | Grad school\n");
       for (int i = 0; i < candidates.size(); i++) {
            if (candidates.get(i) instanceof Fresher) {
                System.out.format(alignment2, candidates.get(i).getId(), candidates.get(i).getFirstName(),
                        candidates.get(i).getLastName(), candidates.get(i).getBirthDate(),
                        candidates.get(i).getAddress(), candidates.get(i).getPhone(), candidates.get(i).getEmail(),
                        ((Fresher) candidates.get(i)).getGraduationDate(), ((Fresher) candidates.get(i)).getGraduationRank(), 
                        ((Fresher) candidates.get(i)).getGraduationSchool());
            }
        }
        System.out.println("\nInternship Candidates: ");
        String alignment3 = "| %-8s | %-20s | %-20s | %-10d | %-20s | %-12s | %-22s | %-8s | %-8s | %-13s\n";
        System.out
                .format("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
        System.out
                .format("| ID       | First Name           | Last Name            | Birth date | Address              | Phone        | Email                  | Major    | Semester | Intern school\n");
        for (int i = 0; i < candidates.size(); i++) {
            if (candidates.get(i) instanceof Intern) {
                System.out.format(alignment3, candidates.get(i).getId(), candidates.get(i).getFirstName(),
                        candidates.get(i).getLastName(), candidates.get(i).getBirthDate(),
                        candidates.get(i).getAddress(), candidates.get(i).getPhone(), candidates.get(i).getEmail(),
                        ((Intern) candidates.get(i)).getMajor(), ((Intern) candidates.get(i)).getSemester(), 
                        ((Intern) candidates.get(i)).getInternSchool());
            }
        }
    }
}
