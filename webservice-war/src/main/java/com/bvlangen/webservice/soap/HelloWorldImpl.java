package com.bvlangen.webservice.soap;

import com.bvlangen.webservice.generated.HelloWorld;
import com.bvlangen.webservice.generated.SayHello;
import com.bvlangen.webservice.generated.SayHelloResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "HelloWorld", targetNamespace = "http://helloworld.webservice.com")
public class HelloWorldImpl implements HelloWorld {

    @WebMethod
    @WebResult(name = "sayHelloResponse", targetNamespace = "http://helloworld.webservice.com", partName = "parameters")
    public SayHelloResponse sayHello(
            @WebParam(name = "sayHello", targetNamespace = "http://helloworld.webservice.com", partName = "parameters")
            SayHello parameters) {
        SayHelloResponse sayHelloResponse = new SayHelloResponse();
        sayHelloResponse.setSayHelloReturn(parameters.getName());
        return sayHelloResponse;
    }
}
