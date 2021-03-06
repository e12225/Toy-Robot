package simulator.processor;

/**
 * ValueHolder maintains the attributes of the robot in terms of X,Y and F values.
 */
public class ValueHolder {

    private Integer x;
    private Integer y;
    private String face;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }
}
