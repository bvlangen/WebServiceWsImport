
package com.bvlangen.webservice.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloWorld", targetNamespace = "http://helloworld.webservice.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloWorld {


    /**
     * 
     * @param parameters
     * @return
     *     returns com.bvlangen.webservice.generated.SayHelloResponse
     */
    @WebMethod
    @WebResult(name = "sayHelloResponse", targetNamespace = "http://helloworld.webservice.com", partName = "parameters")
    public SayHelloResponse sayHello(
        @WebParam(name = "sayHello", targetNamespace = "http://helloworld.webservice.com", partName = "parameters")
        SayHello parameters);

}