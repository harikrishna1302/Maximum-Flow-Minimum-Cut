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
