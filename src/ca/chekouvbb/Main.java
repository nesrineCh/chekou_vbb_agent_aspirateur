package ca.chekouvbb;

import ca.chekouvbb.agent.Agent;
import ca.chekouvbb.environment.Environment;
import ca.chekouvbb.environment.Manor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Boolean run = true;

        while (run){
            System.out.println("Welcome to the intelligent Agent");
            System.out.println("He was named 'VacuumCleanerMax'");

            System.out.println("Please, choose the desired exploration\n\t1 for Exploration BFS\n\t2 for Exploration A*");
            System.out.println("Choose 1 or 2 : ");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            int choice_number = Integer.parseInt(choice.trim());

            if (choice_number != 1 && choice_number != 2) {
                System.out.println("This choice isn't correct !");
                continue;
            }
            run = false;

            Agent.Exploration exploration = Agent.Exploration.BFS;

            if (choice_number == 2) {
                exploration = Agent.Exploration.A_STAR;
            }
            Environment environment = new Environment(new Manor(5));
            Thread environmentThread = new Thread(environment);
            Thread agentThread = new Thread(new Agent(environment, exploration));
            environmentThread.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            agentThread.start();
        }
    }
}
