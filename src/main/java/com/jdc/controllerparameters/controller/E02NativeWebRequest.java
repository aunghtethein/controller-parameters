package com.jdc.controllerparameters.controller;

import org.apache.catalina.connector.RequestFacade;
import org.apache.catalina.connector.ResponseFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import static com.jdc.controllerparameters.util.JoinUtils.join;
import java.io.IOException;
@Controller
public class E02NativeWebRequest {

    //curl "localhost:8080/actionB?name=John&country=US"
    @ResponseBody
    @GetMapping("/actionB")
    public void actionB(NativeWebRequest nativeWebRequest) throws IOException {
        RequestFacade requestFacade = nativeWebRequest.getNativeRequest(RequestFacade.class);
        ResponseFacade responseFacade = nativeWebRequest.getNativeResponse(ResponseFacade.class);

        responseFacade.getOutputStream().println(
                String.format(
                        "Retrieved request with headers = [%s] , parameters = [%s]",
                        join(requestFacade.getHeaderNames()),
                        join(requestFacade.getParameterNames())
                )
        );


    }

}
