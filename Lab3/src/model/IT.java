package model;

public class IT extends Student {
	private double javaScore;
	private double cssScore;
	private double avgScore;


	public IT(String id, String name, Address address, double javaScore, double cssScore) {
		super(id, name, address);
		this.javaScore = javaScore;
		this.cssScore = cssScore;
	}

	public IT() {
		// TODO Auto-generated constructor stub
	}

	public double getJavaScore() {
		return javaScore;
	}

	public void setJavaScore(double javaScore) {
		this.javaScore = javaScore;
	}

	public double getCssScore() {
		return cssScore;
	}

	public void setCssScore(double cssScore) {
		this.cssScore = cssScore;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}
	@Override
	public double avgScore() {
		return (3 * javaScore + cssScore) / 4;
	}

	public void inputStd() {
		String input;
		do {
			System.out.print("Enter Java score: ");		
			input = sc.nextLine().trim();
			if (!input.matches(dv.scorePattern)) {
				System.out.println("Wrong input!");
			}
		} while (!input.matches(dv.scorePattern));
		javaScore = Double.valueOf(input);
		do {
			System.out.print("Enter CSS score: ");
			input = sc.nextLine().trim();
			if (!input.matches(dv.scorePattern)) {
				System.out.println("Wrong input!");
			}
		} while (!input.matches(dv.scorePattern));
		cssScore = Double.valueOf(input);
	}

    @Override
    public String toString() {
        return super.getId()+ " " + super.getName() + " " + super.getAddress() + " " + javaScore + " " + cssScore + " " + null + " " + null + " " + getAvgScore() + "\n";
    }
	
}
