package com.gants.rgm.alphaservice;

public class ID {
  private static int counter;

  public static synchronized int getId() {
    return counter++;
  }
}
