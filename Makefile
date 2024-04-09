FILENAME=bin

SRCS=$(shell find * -name "*.java")

all: $(FILENAME)/.compiled

$(FILENAME)/.compiled: $(SRCS)
	@-mkdir -p $(FILENAME)
	@echo $(SRCS) > $(FILENAME)/sources.txt
	@javac -d $(FILENAME) @$(FILENAME)/sources.txt
	@touch $(FILENAME)/.compiled

clean:
	@-find . -name "*.class" -delete
	@-rm -rf $(FILENAME)

re: clean all

exec:
	java -cp $(FILENAME) src/com/avaj/simulator/Simulator scenario.txt

.PHONY: all clean re exec
