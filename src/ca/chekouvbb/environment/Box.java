package ca.chekouvbb.environment;

public class Box {
    private int position_x;
    private int position_y;
    private Boolean jewelry;
    private Boolean dust;
    private Boolean agent;


    public Box(int position_x, int position_y) {
        this.position_x = position_x;
        this.position_y = position_y;
        this.jewelry = false;
        this.dust = false;
        this.agent = false;
    }

    public Box(int position_x, int position_y, Boolean agent) {
        this.position_x = position_x;
        this.position_y = position_y;
        this.jewelry = false;
        this.dust = false;
        this.agent = agent;
    }

    public Box(int position_x, int position_y, Boolean jewelry, Boolean dust, Boolean agent) {
        this.position_x = position_x;
        this.position_y = position_y;
        this.jewelry = jewelry;
        this.dust = dust;
        this.agent = agent;
    }

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public Boolean getJewelry() {
        return jewelry;
    }

    public void setJewelry(Boolean jewelry) {
        this.jewelry = jewelry;
    }

    public Boolean getDust() {
        return dust;
    }

    public void setDust(Boolean dust) {
        this.dust = dust;
    }

    public Boolean getAgent() {
        return agent;
    }

    public void setAgent(Boolean agent) {
        this.agent = agent;
    }

    public Boolean toClean(){
        return (this.dust || this.jewelry);
    }

}
