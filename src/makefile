JC = javac
JFLAGS = -g
CLASSES = \
        DisplayCharacters.java \
        Scheduler.java\
	Parser.java\
	Lesson.java\
	UserInput.java\
	SelectionPage.java\
	MakeResults.java\
	Results.java\
	ButtonListener.java

all: classes

start: all
	java SelectionPage

classes:
	$(JC) $(JFLAGS) $(CLASSES)

clean:
	rm *.class

