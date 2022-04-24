package edu.utd.dc.project2.constants;

/** Contains Global Constants and Configuration details. */
public final class GlobalConstants {

  public static final LogLevel LOG_LEVEL = LogLevel.DEBUG;

  private GlobalConstants() {
    throw new Error("Can't initiate a singleton class");
  }
}