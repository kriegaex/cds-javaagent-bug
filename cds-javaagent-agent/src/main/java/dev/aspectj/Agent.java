package dev.aspectj;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.Arrays;

public class Agent {
  public static void premain(String options, Instrumentation instrumentation) {
    boolean returnNull = "returnNull".equalsIgnoreCase(options);
    System.out.printf("Initialising java agent in '%s' mode%n", returnNull ? "return null" : "return original bytes");
    ClassFileTransformer transformer = new ClassFileTransformer() {
      @Override
      public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        System.out.printf("%n Transforming %s", className);
        return returnNull ? null : Arrays.copyOf(classfileBuffer, classfileBuffer.length);
      }
    };
    instrumentation.addTransformer(transformer);
  }
}
