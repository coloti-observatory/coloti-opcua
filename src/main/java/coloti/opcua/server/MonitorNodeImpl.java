package coloti.opcua.server;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.milo.opcua.sdk.server.nodes.UaVariableNode;

public class MonitorNodeImpl implements MonitorNode{
    protected AtomicBoolean run=new AtomicBoolean(false);
    protected UaVariableNode node;
    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    @Override
    public synchronized void setNode(UaVariableNode node) {
       this.node=node;
    }

    @Override
    public synchronized void start() {
        run.set(true);
    }

    @Override
    public synchronized void stop() {
        run.set(false);
    }

    @Override
    public synchronized boolean isRunning() {
        return run.get();
    }
    
}
