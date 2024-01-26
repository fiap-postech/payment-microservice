FROM --platform=linux/amd64 openjdk:17-alpine

WORKDIR /service

COPY ./payment-service.jar ./payment-service.jar

RUN /bin/sh -c 'touch /service/payment-service.jar'

CMD ["java", "-jar", "payment-service.jar"]