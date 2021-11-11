JFLAGS = -g
JC = javac
JVM= java
FILE=

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) -Xlint:all $*.java

CLASSES = \
	Bosque.java \
	Bueno.java \
	Druida.java \
	Enemigo.java \
	Guerrero.java \
	Jefe_Final.java \
	Jugador.java \
	Mago.java \
	Main.java \
	Malo.java \
	Mision.java \
	Monstruo.java \
	Montana.java \
	Neutro.java \
	NPC.java \
	Planicie.java \
	Tierra.java

MAIN = Main

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN) $(FILE)

.PHONY: clean
clean:
	$(RM) *.class