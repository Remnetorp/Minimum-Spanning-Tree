import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MinimumSpanTree{
    private int nPeople,nRelations;
    private Relation start;
    private HashSet<Integer> visitedNodes;
    private Map<Integer, LinkedList<Relation>> relations = new HashMap<>();
    private PriorityQueue<Relation> relationQueue = new PriorityQueue<>();

     /**
     * Method readFile() takes in-files in the format where first line contains two integers, the first integer is the number of people(nodes).
     * The second integer is the number of relations(edges). After that follows on each line a relation each, where there are three integers. 
     * The first integer is the source, second integer is the target and third integer is the cost. 
     * There are some examples of input files added in the folder data-input in the repository. 
     * 
     * @param output Decideds if extra information should be printed out or not in the terminal.
     * 
     */
    private void readFile(boolean output){
        Scanner scanner = new Scanner(System.in);
        nPeople = scanner.nextInt();
        for (int i = 1; i < nPeople+1; i++){
            relations.put(i, new LinkedList<>());
        }
        nRelations = scanner.nextInt();

        if (output){
            System.out.println("Number of people: " + nPeople);
            System.out.println("Number of relations: " + nRelations +"\n--------------------");
        }

        for(int i=0; i < nRelations; i++){
            int person1 = scanner.nextInt();
            int person2 = scanner.nextInt();
            int weight = scanner.nextInt();

            // Print the preferences to make sure it works, call it by sending "output" in the argument when running from terminal.
            if (output){
                System.out.println("Source:" + person1 + " Target:" + person2 + " Cost:" + weight);
            }

            // Adds relevant input data about the relations/edges into a map, The info important info from input file contais target, source and cost.
            Relation relation = new Relation(person1,person2,weight);
            relations.get(person1).add(relation);
            relations.get(person2).add(new Relation(person2,person1,weight));

            if(start == null){
                start = relation;
            }else if(relation.getMinutes() < start.getMinutes()){
                start = relation;
            }
        } 

        scanner.close();
    }

     /**
     * Method algorithmMST() calculates the minimum cost to connect all the persons, in other words it produces the minimum spanning
     * tree for all the given nodes, edges and costs. 
     * 
     */
    private int algorithmMST(){
        int length = 0;
        visitedNodes = new HashSet<>();
        visitedNodes.add(start.getPerson());
        relationQueue.addAll(relations.get(start.getPerson()));

        while(relationQueue.size() != 0 && visitedNodes.size() != nPeople){
            Relation relation = relationQueue.poll();
            int targetPerson = relation.getTarget();
            if(!visitedNodes.contains(targetPerson)){
                length += relation.getMinutes();
                visitedNodes.add(targetPerson);
                relationQueue.addAll(relations.get(targetPerson));
            }
        }

        return length;

    }
    
    public static void main(String[] args){
        MinimumSpanTree test = new MinimumSpanTree();
        boolean output = false;
        for(String arg : args){
            if (arg.equals("output")){
                output = true;
            }
        }
        test.readFile(output);
        int result = test.algorithmMST();
        System.out.println(result);
    }


    
}