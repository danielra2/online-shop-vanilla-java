package app.system;

public class PopularProduct {
    private int popularProductId;
    private int frequency;

    public int getPopularProductId() {
        return popularProductId;
    }

    public void setPopularProductId(int popularProductId) {
        this.popularProductId = popularProductId;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public PopularProduct(int popularProductId, int frequency) {
        this.popularProductId = popularProductId;
        this.frequency = frequency;
    }
}
