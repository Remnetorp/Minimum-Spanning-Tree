The program is based on a minimum spanning tree algorithm, following the Kruskal's algorithm. A minimum spanning tree of a connected weighted graph is a connected subgraph, without cycles, for which the sum of the weights of all the edges in the subgraph is minimal. In this program the nodes will represent people and the edges will represent friendships. If a person is friend with another person then the people related to one of the persons automatically "knows" the other person. The weight of each edge is the amount of minutes t would take the two nodes to become friends. The program will give the total sum of the weights of the minimum spanning tree, which is the minimum amount of minutes for all people to connect.

To run the algorithm, use following lines: <br>
(1) $ javac MinimumSpanTree.java Relation.java <br>
(2) $ java MinimumSpanTree < data-input/data3.in <br>
(3) $ java MinimumSpanTree < data-input/data3.in output <br>
