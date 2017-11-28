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
	ButtonListener.java\
	StartPage.java

all: classes

start: all
	java StartPage

classes:
	$(JC) $(JFLAGS) $(CLASSES)

clean:
	rm *.class

