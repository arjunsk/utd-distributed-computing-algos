package edu.utd.dc.sync.core.io.sharedmemory;

import edu.utd.dc.common.design_pattern.listener.Listener;
import edu.utd.dc.common.domain.io.Message;
import edu.utd.dc.common.domain.support.ProcessId;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** Singleton class responsible for handling messages in the network. */
public final class SharedMemoryBus {

  public static Map<ProcessId, List<Destination>> map = new ConcurrentHashMap<>();

  /**
   * Registers an edge.
   *
   * @param source contains start of an edge
   * @param destination contains end of an edge
   * @param listener contains the destination client
   */
  public static void register(ProcessId source, ProcessId destination, Listener listener) {
    map.putIfAbsent(source, new ArrayList<>());
    map.get(source).add(new Destination(destination, listener));
  }

  /**
   * Responsible for sending message. Since we are using Listener Pattern, the message will be
   * delivered immediately as we are invoking the onReceive() function.
   *
   * @param destinationId Destination ProcessId
   * @param message Message to be delivered
   */
  public static synchronized void send(ProcessId destinationId, Message message) {
    ProcessId sourceId = message._source;

    for (Destination destination : map.get(sourceId))
      if (destination.destinationId == destinationId) destination.client.onReceive(message);
  }

  /** Contains the Destination details */
  static class Destination {
    ProcessId destinationId;
    Listener client;

    public Destination(ProcessId destinationId, Listener client) {
      this.destinationId = destinationId;
      this.client = client;
    }
  }
}
