//Movie class to store movie information read in from the JSON file.
//Ocean Lee 11/5/17

public class Movie {
    private double budget;
    private double revenue;
    private double vote_average;

    //Default Dummy Constructor
    public Movie(){
    }

    //Parameterized constructor.
    public Movie(int budget, int revenue, double vote_average){
        this.budget = budget;
        this.revenue = revenue;
        this.vote_average = vote_average;
    }

    //Getters and Setters for movie class.
    public double getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    //toString for testing
    public String toString(){
        return "Budget: " + budget + "Revenue: " + revenue + "User Rating: " + vote_average;
    }
}
