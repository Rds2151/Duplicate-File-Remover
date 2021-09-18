build:
	javac -d . CkSumStore.java
	javac -d . CRC_CheckSum.java
	javac Remover.java

run:
	java Remover
