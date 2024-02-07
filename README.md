# Reproducer for JDK bug 9076545

Originally, this problem was detected when using the AspectJ weaving agent, see https://github.com/eclipse-aspectj/aspectj/issues/277.
The problem is totally unrelated to AspectJ, though, which is why I created a minimal reproducer with the simplest agent possible, only returning the original class bytes during transformation.
The workaround in this case is for the agent to return `null`, but that does not solve the problem.
The problem occurs on JDKs 20 and 21, not on JDKs 13-19.
