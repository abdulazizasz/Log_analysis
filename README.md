# Log_analysis

Run

1. mvn clean install
2. export HADOOP_CLASSPATH=hadoop-examples-accesslog.jar
3. hadoop fs -put short.txt
4. hadoop jar hadoop-examples-accesslog.jar AccessLog short.txt output
