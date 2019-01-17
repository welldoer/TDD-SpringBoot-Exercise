#-d bootVersion=1.5.18.RELEASE -d packaging=jar \
curl https://start.spring.io/starter.tgz -d dependencies=web,actuator \
-d groupId=net.blogjava -d artifactId=tddspringboot \
-d language=java -d type=gradle-project | tar -xzvf -
