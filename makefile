JAVAC=javac
JAVA=java
.SUFFIXES: .java .class
.java.class:
	$(JAVAC) $*.java

NTreeDiameter.class: NTreeDiameter.java
	$(JAVAC) NTreeDiameter.java

run: NTreeDiameter.class
	$(JAVA) NTreeDiameter

clean:
	$(RM) *.class
