//Movie class to store movie information read in from the JSON file.
//Ocean Lee 11/5/17

public class Movie {
    private int budget;
    private int revenue;
    private double userRating;

    //Parameterized constructor.
    public Movie(int budget, int revenue, double userRating){
        this.budget = budget;
        this.revenue = revenue;
        this.userRating = userRating;
    }

    //Getters and Setters for movie class.
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    //toString for testing
    public String toString(){
        return "Budget: " + budget + "Revenue: " + revenue + "User Rating: " + userRating;
    }
}
