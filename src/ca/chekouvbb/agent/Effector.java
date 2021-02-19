package ca.chekouvbb.agent;

public class Effector {
    private Agent agent;

    public Effector(Agent agent){
        this.agent = agent;
    }

    public void move_left(){
        this.agent.getEnvironment().getManor().getCase(agent.getCurrentPosition().getPosition_x(), agent.getCurrentPosition().getPosition_y()).setAgent(false);
        this.agent.getEnvironment().getManor().getCase(agent.getCurrentPosition().getPosition_x() - 1, agent.getCurrentPosition().getPosition_y()).setAgent(true);
        agent.setCurrentPosition(this.agent.getEnvironment().getManor().getCase(agent.getCurrentPosition().getPosition_x() - 1, agent.getCurrentPosition().getPosition_y()));
    }
    public void move_right(){
        this.agent.getEnvironment().getManor().getCase(agent.getCurrentPosition().getPosition_x(), agent.getCurrentPosition().getPosition_y()).setAgent(false);
        this.agent.getEnvironment().getManor().getCase(agent.getCurrentPosition().getPosition_x() + 1, agent.getCurrentPosition().getPosition_y()).setAgent(true);
        agent.setCurrentPosition(this.agent.getEnvironment().getManor().getCase(agent.getCurrentPosition().getPosition_x() + 1, agent.getCurrentPosition().getPosition_y()));

    }
    public void move_up(){
        this.agent.getEnvironment().getManor().getCase(agent.getCurrentPosition().getPosition_x(), agent.getCurrentPosition().getPosition_y()).setAgent(false);
        this.agent.getEnvironment().getManor().getCase(agent.getCurrentPosition().getPosition_x(), agent.getCurrentPosition().getPosition_y() - 1).setAgent(true);
        agent.setCurrentPosition(this.agent.getEnvironment().getManor().getCase(agent.getCurrentPosition().getPosition_x(), agent.getCurrentPosition().getPosition_y() - 1));

    }
    public void move_down(){
        this.agent.getEnvironment().getManor().getCase(agent.getCurrentPosition().getPosition_x(), agent.getCurrentPosition().getPosition_y()).setAgent(false);
        this.agent.getEnvironment().getManor().getCase(agent.getCurrentPosition().getPosition_x(), agent.getCurrentPosition().getPosition_y() + 1).setAgent(true);
        agent.setCurrentPosition(this.agent.getEnvironment().getManor().getCase(agent.getCurrentPosition().getPosition_x(), agent.getCurrentPosition().getPosition_y() + 1));
    }

    public void vacuum(){
        agent.getCurrentPosition().setDust(false);
        agent.getEnvironment().getManor().getCase(agent.getCurrentPosition().getPosition_x(),agent.getCurrentPosition().getPosition_y()).setDust(false);
        if (agent.getCurrentPosition().getJewelry()){
            agent.setScore(-2);
            agent.getCurrentPosition().setJewelry(false);
            agent.getEnvironment().getManor().getCase(agent.getCurrentPosition().getPosition_x(),agent.getCurrentPosition().getPosition_y()).setJewelry(false);
        }
        else {
            agent.setScore(1);
        }

    }
    public void pick(){
        agent.setScore(1);
        agent.getCurrentPosition().setJewelry(false);
        agent.getEnvironment().getManor().getCase(agent.getCurrentPosition().getPosition_x(),agent.getCurrentPosition().getPosition_y()).setJewelry(false);
    }
}
