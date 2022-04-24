package edu.utd.dc.project2.algo.spanning_tree.bfs.layered.domain.payload.ack;

/** If you get IAM done message from your neighbour, then the neighbour is child of the node. */
public class PAckPayload {

  public int maxProcessId;

  public PAckPayload(int processId) {
    this.maxProcessId = processId;
  }

  @Override
  public String toString() {
    return "PAckPayload{}";
  }
}
