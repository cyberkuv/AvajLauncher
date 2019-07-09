find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java src.za.wethinkcode.avaj.Simulator scenario.txt