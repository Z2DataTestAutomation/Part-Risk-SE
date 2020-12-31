pipeline {
    agent none

    stages {
        stage("Build & Test") {
            matrix {
                agent {
                    dockerfile {
                        label "Dockerfile"

                        additionalBuildArgs """
                            --build-arg JAVA_VERSION=$JAVA \
                            --build-arg MAVEN_VERSION=$MAVEN \
                            --build-arg USER_UID=\$(id -u) \
                            -t mymaven:${MAVEN}-jdk-${JAVA}
                        """.stripIndent().trim()

                        args "-v /tmp/maven:/home/jenkins/.m2"
                    }
                }
                axes {
                    axis {
                        name "JAVA"
                        values "15.0.1"
                    }
                    axis {
                        name "MAVEN"
                        values "3.6.3"
                    }
                }
                stages {
                    stage("Build") {
                        steps {
                            sh "mvn -version"
                            sh "mvn -DskipTests clean package"
                        }
                    }
                    stage("Test") {
                        steps {
                            sh "mvn test -P coverage"
                        }
                    }
                }
            }
        }
    }
}