# Maximum-Flow-Minimum-Cut
## Abstract
The main objective is to implement the MaxFlow-MinCut problem for a given network which contains the following requirements.
### Network Requirements: 
* Directed Graph.
* Should contain source and sink nodes.
* Weights(Capacities).
### Flow Network
<img width="282" alt="network" src="https://cloud.githubusercontent.com/assets/18632383/25983214/35fd787e-36b1-11e7-8bce-fd91202e5b88.png">.

### Constraints
* Flow on any edge is non-negative and doesn’t exceed the capacity.
     0 ≤ f ≤ C, where f – flow in edge, C – capacity of an edge.
* Incoming flow is equal to the outgoing flow for every nodes except source and sink.

## Residual Network
* Residual Network, N = (V, E, Cf, s, t)
* In Residual Network, all edges having zero capacities are removed.
<img width="334" alt="residual" src="https://cloud.githubusercontent.com/assets/18632383/25983586/c0f408ec-36b3-11e7-886e-6798f1d47898.png">.
## Ford-Fulkerson Algorithm
* Initialize the network with zero flow.
* While there is an augment path,<br />
--find the augment path;<br />
--find the possible flow through the above path;<br />
--add the found possible flow to overall flow; <br />
--update the residual network;
* Repeat the above procedure until you find augment paths.
<img width="623" alt="augment1" src="https://cloud.githubusercontent.com/assets/18632383/25983840/36d0d2a6-36b5-11e7-83d0-19d38283240e.png">
