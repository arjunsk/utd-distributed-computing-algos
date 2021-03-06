package edu.utd.dc.async.layered_bfs;

import edu.utd.dc.async.layered_bfs.algo.LayeredBfsManager;
import edu.utd.dc.async.layered_bfs.io.file.ConfigFileReader;
import edu.utd.dc.common.telemetry.MessageTelemetryUtils;

public class Driver {

  public static void main(String[] args) {
    // Read Config
    String configFileName = args[0];
    ConfigFileReader configFileReader = new ConfigFileReader(configFileName);

    // Run Layered BFS & find max processId
    LayeredBfsManager layeredBFSManager = new LayeredBfsManager(configFileReader);
    int leaderId = layeredBFSManager.buildBFSTreeAndReturnLeader();

    // Print Leader
    System.out.println("Leader Id : " + leaderId);

    // Print Telemetry
    MessageTelemetryUtils.print();
  }
}
