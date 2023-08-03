package model;

public class Biz extends Student {
	private double accScore;
	private double marScore;
	private double avgScore;

	public Biz(String id, String name, Address address, double accScore, double marScore) {
		super(id, name, address);
		this.accScore = accScore;
		this.marScore = marScore;
	}

	public Biz() {
		// TODO Auto-generated constructor stub
	}

	public double getAccScore() {
		return accScore;
	}

	public void setAccScore(double accScore) {
		this.accScore = accScore;
	}

	public double getMarScore() {
		return marScore;
	}

	public void setMarScore(double marScore) {
		this.marScore = marScore;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	@Override
	public double avgScore() {
		return (accScore * 2 + marScore) / 3;
	}

	public void inputStd() {
		String input;
		do {
			System.out.print("Enter Accounting score: ");
			input = sc.nextLine().trim();
			if (!input.matches(dv.scorePattern)) {
				System.out.println("Wrong input!");
			}
		} while (!input.matches(dv.scorePattern));
		accScore = Double.valueOf(input);
		do {
			System.out.print("Enter Marketing score: ");
			input = sc.nextLine().trim();
			if (!input.matches(dv.scorePattern)) {
				System.out.println("Wrong input!");
			}
		} while (!input.matches(dv.scorePattern));
		marScore = Double.valueOf(input);
	}
	    public String toString() {
        return super.getId() + " " + super.getName() + " " + super.getAddress() + " " + " " + null + " " + null + " " +accScore + " " + marScore + " " + getAvgScore() + " " + "\n";
    }
}
