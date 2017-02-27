The entry to the project is dijkstra.Main.java. This class expects one argument to run, which is the path to the input file.
e.g. If the input file "SampleInput.txt" is located in the Temp directory inside C drive, then the argument will be "C:\Temp\SampleInput.txt".
For the test input, the towns should be named from A to D.  A route between two towns (A to B) with a distance of 5 is represented as AB5.

This application then executes various instructions such as:
- The distance of the route between various nodes
- The number of trips between a source and a destination with specific number of stops.
- The length of the shortest route (in terms of distance to travel) between two nodes
- The number of different routes between a source and destination with a distance of less than x.

Changes to the instructions can be made in dijkstra.RoutesFinder.java

A Sample input file "SampleInput.txt" is also located inside the project root folder, which shows how the entries should look like. Example is:
AB6
BC4

 