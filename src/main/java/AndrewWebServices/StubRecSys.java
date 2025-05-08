package AndrewWebServices;

/*
 * StubRecSys is a test double for RecSys that immediately returns a predefined recommendation.
 * (This is a classic stub implementation)
 */
public class StubRecSys extends RecSys {
    private final String recommendation;

    public StubRecSys(String recommendation) {
        this.recommendation = recommendation;
    }

    @Override
    public String getRecommendation(String accountName) {
        return recommendation; // No delay, just return the predefined value
    }
}