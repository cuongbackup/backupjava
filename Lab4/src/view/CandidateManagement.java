package view;

import controller.Manager;
import java.util.ArrayList;
import model.Candidate;
import controller.Menu;
import model.Enum;

public class CandidateManagement extends Menu<String> {

    static String[] menu = {"Experience", "Fresher", "Internship", "Searching", "Exit"};
    private Manager m = new Manager();
    ArrayList<Candidate> candidates = new ArrayList<>();

    public CandidateManagement() {
        super("Candidate Management", menu);
    }

    @Override
    public void execute(int n) {
        m.addData();
        switch(n) {
            case 1:
                m.createCandidate(Enum.Experience);
                break;
            case 2:
                m.createCandidate(Enum.Fresher);
                break;
            case 3:
                m.createCandidate(Enum.Intern);
                break;
            case 4:
                m.searchCandidate();
                break;
            case 5:
                System.out.println("Have a nice day!");
                System.exit(0);
        }

    }

    public static void main(String[] args) {
        CandidateManagement m = new CandidateManagement();
        m.run();
    }
}
