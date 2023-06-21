package ex5.Classes;

public class Area {
    private String areaId;
    private int leftLongitude;
    private int rightLongitude;
    private int topLatitude;
    private int bottomLatitude;

    public Area(String areaId, int leftLongitude, int rightLongitude, int topLatitude, int bottomLatitude)
    {
        this.areaId = areaId;
        this.leftLongitude = leftLongitude;
        this.rightLongitude = rightLongitude;
        this.topLatitude = topLatitude;
        this.bottomLatitude = bottomLatitude;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public int getLeftLongitude() {
        return leftLongitude;
    }

    public void setLeftLongitude(int leftLongitude) {
        this.leftLongitude = leftLongitude;
    }

    public int getRightLongitude() {
        return rightLongitude;
    }

    public void setRightLongitude(int rightLongitude) {
        this.rightLongitude = rightLongitude;
    }

    public int getTopLatitude() {
        return topLatitude;
    }

    public void setTopLatitude(int topLatitude) {
        this.topLatitude = topLatitude;
    }

    public int getBottomLatitude() {
        return bottomLatitude;
    }

    public void setBottomLatitude(int bottomLatitude) {
        this.bottomLatitude = bottomLatitude;
    }

    public boolean isValid() {
        if (this.areaId == null ||
                this.leftLongitude <= 0 ||
                this.rightLongitude <= 0 ||
                this.topLatitude <= 0 ||
                this.bottomLatitude <= 0) return false;
        return true;
    }
}
