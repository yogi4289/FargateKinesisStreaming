
package com.amazonaws.services.kinesis.samples.dataprocessor;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Value;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.*;

import com.amazonaws.services.kinesis.producer.*;

@RestController
public class InputEventController {

    //Read Config from env variables
    String region = System.getenv("REGION");
    static String streamName = System.getenv("STREAM_NAME");



    private final KinesisProducerConfiguration config = new KinesisProducerConfiguration().setRegion(region);
    private final KinesisProducer kinesis = new KinesisProducer(config);

    //Healthcheck
    @GetMapping(value="/healthcheck")
    public void returnHealthy() {
        //Returns HTTP Status 200 
    }

    //Handler for post requests
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public void processInputEvent(@RequestBody Map<String, Object> payload) throws UnsupportedEncodingException {
        String element = (String) payload.get("data");
        System.out.println("DATADATADATA");
        System.out.println(element);
        String key = UUID.randomUUID().toString();
        ByteBuffer data = ByteBuffer.wrap(element.getBytes("UTF-8"));
        kinesis.addUserRecord(streamName, key, data);

        return;
    }
} 
