package org.dinvi;

import org.apache.camel.Category;
import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.support.DefaultEndpoint;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriPath;

import java.util.concurrent.ExecutorService;

/**
 * Test component which does bla bla.
 *
 * TODO: Update one line description above what the component does.
 */
@UriEndpoint(firstVersion = "3.20.1", scheme = "test", title = "Test", syntax="test:name",
             category = {Category.JAVA})
public class TestEndpoint extends DefaultEndpoint {
    @UriPath @Metadata(required = true)
    private String name;
    @UriParam(defaultValue = "10")
    private int option = 10;

    public TestEndpoint() {
    }

    public TestEndpoint(String uri, TestComponent component) {
        super(uri, component);
    }

    public Producer createProducer() throws Exception {
        return new TestProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        Consumer consumer = new TestConsumer(this, processor);
        configureConsumer(consumer);
        return consumer;
    }

    /**
     * Some description of this option, and what it does
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Some description of this option, and what it does
     */
    public void setOption(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }

    public ExecutorService createExecutor() {
        // TODO: Delete me when you implemented your custom component
        return getCamelContext().getExecutorServiceManager().newSingleThreadExecutor(this, "TestConsumer");
    }
}
