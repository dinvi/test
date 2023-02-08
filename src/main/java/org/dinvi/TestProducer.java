package org.dinvi;

import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestProducer extends DefaultProducer {
    private static final Logger LOG = LoggerFactory.getLogger(TestProducer.class);
    private TestEndpoint endpoint;

    public TestProducer(TestEndpoint endpoint) {
        super(endpoint);
        this.endpoint = endpoint;
    }

    public void process(Exchange exchange) throws Exception {
        LOG.info("TestProducer process: {}", exchange.getIn().getBody());
    }

}
