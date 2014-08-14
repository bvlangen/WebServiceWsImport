package com.bvlangen.webservice.soap;

import com.bvlangen.webservice.generated.HelloWorld;
import com.bvlangen.webservice.generated.SayHello;
import com.bvlangen.webservice.generated.SayHelloResponse;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebService(name = "HelloWorld", targetNamespace = "http://helloworld.webservice.com")
public class HelloWorldImpl implements HelloWorld {

    @Resource
    WebServiceContext wsCtxt;

    @WebMethod
    @WebResult(name = "sayHelloResponse", targetNamespace = "http://helloworld.webservice.com", partName = "parameters")
    public SayHelloResponse sayHello(
            @WebParam(name = "sayHello", targetNamespace = "http://helloworld.webservice.com", partName = "parameters")
            SayHello parameters) {

        MessageContext context = wsCtxt.getMessageContext();
        HttpServletRequest req = (HttpServletRequest) context.get(MessageContext.SERVLET_REQUEST);
        String clientIP = req.getRemoteAddr();
        System.out.println("\n\n\t\tClient's IP Address is : " + clientIP);

        Map map = (Map) context.get(MessageContext.HTTP_REQUEST_HEADERS);
        String str = "";

        Set entries = map.entrySet();
        for (Object entry1 : entries) {
            Map.Entry entry = (Map.Entry) entry1;
            str = str + "\nHeader:" + entry.getKey() + " \tValue: " + entry.getValue();
        }

        System.out.println("\n\t\tClient's HTTP Headers are : " + str);

        SayHelloResponse sayHelloResponse = new SayHelloResponse();
        sayHelloResponse.setSayHelloReturn("Return: " + parameters.getName() +
                "\n\t\tClient's IP Address is : " + clientIP +
                "\n\t\tClient's HTTP Headers are : " + str);
        return sayHelloResponse;
    }
}
