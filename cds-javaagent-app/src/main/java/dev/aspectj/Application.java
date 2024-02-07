package dev.aspectj;

import java.lang.management.ManagementFactory;

public class Application {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    ManagementFactory.getGarbageCollectorMXBeans();
  }
}
