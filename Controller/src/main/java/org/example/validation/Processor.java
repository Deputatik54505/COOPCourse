package org.example.validation;

//TODO: try to validate using Fabric pattern

public abstract class Processor {
    private final Processor nextProcessor;
    public Processor(Processor nextProcessor){
        this.nextProcessor = nextProcessor;
    };
    public void process(Request request){
        if(this.nextProcessor != null) {
            this.nextProcessor.process(request);
        }
    };
}
