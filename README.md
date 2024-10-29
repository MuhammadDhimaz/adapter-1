<br />
<div align="center">
  <h1 align="center">JSReport Backend Service</h1>
  <p align="center">
    JSReport backend service built using Java Spring Boot
  </p>
</div>

<!-- ABOUT THE PROJECT -->

## About The Project

This system is an adapter to Impala Database and JSReport Service

### Built With

- Spring Boot
- Java JDK 21

## Getting Started

### Prerequisites

- Java JDK 21 on your machine
- Maven
- ImpalaJDBC driver on your local maven
- H2 Server (Optional)

### Java Installation

1. Go to oracle website and download Java 21 SDK based on your machine
   https://www.oracle.com/id/java/technologies/downloads/#java21
2. Install and don't forget to add Java bin to the path folder

### ImpalaJDBC Installation

Impala JDBC Driver 42 onward is not on public maven due to license, you need to install it on your local maven.

ImpalaJDBC42 already included in resources folder, you can install it by following this instruction:

Make sure maven already installed

1. Run this command (adjust ImpalaJDBC path) to install driver

```shell
mvn install:install-file \
  -Dfile=/path/to/ImpalaJDBC42.jar \
  -DgroupId=com.cloudera.impala \
  -DartifactId=ImpalaJDBC42 \
  -Dversion=2.6.33.1062 \
  -Dpackaging=jar
```

2. Confirm the installation succeeds by making sure `ImpalaJDBC42-2.6.33.1062` exists in:

**Windows**
> C:\Users\<your-windows-username>\.m2\repository\com\cloudera\impala\ImpalaJDBC42

**Linux**
> ~/.m2/repository/com/cloudera/impala/ImpalaJDBC42

### H2 Server Installation (Optional)

1. Download the server from
   https://www.h2database.com/html/download.html

2. Start H2 Server

```shell
java -cp /path/to/h2*.jar org.h2.tools.Server -tcp -tcpAllowOthers -tcpPort 9092
```

### Backend Installation

1. Download the latest release .zip file
2. Extract content
3. Start the server by running this command and provide these values

```shell
java -Dh2JdbcUrl="" \
     -Dh2Username="" \
     -Dh2Password="" \
     -DjsreportUrl="" \
     -DjsreportUsername="" \
     -DjsreportPassword="" \
     -DcorePoolSize="" \
     -DmaxPoolSize="" \
     -DqueueCapacity="" \
     -jar -Xms62g -Xmx62g JSReport-*.jar
```

**Parameter Description**

| Values           |              Description               | Example                                             |
|------------------|:--------------------------------------:|-----------------------------------------------------|
| h2JdbcUrl        |              h2 jdbc url               | jdbc:h2:tcp://h2.server.api:9092/~/path/to/database |
| h2Username       |          h2 database username          | testUsername                                        |
| h2Password       |          h2 database password          | testPassword                                        |
| jsreportUrl      |          jsreport server url           | jsreport.dev.bpjstk.id                              |
| jsreportUsername |        jsreport server username        | Test                                                |
| jsreportPassword |        jsreport server password        | Test                                                |
| corePoolSize     |       thread core for async task       | 13                                                  |
| maxPoolSize      |       thread pool for async task       | 13                                                  |
| queueCapacity    |     query capacity for async task      | 50                                                  |
| Xms              | initial memory allocation pool for JVM | 62g,256m,...                                        |
| Xmx              | maximum memory allocation pool for JVM | 62g,256m,...                                        |

### Adjust JVM Memory

Adjust JVM memory for your application based on your server requirement
