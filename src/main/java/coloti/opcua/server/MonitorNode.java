package coloti.opcua.server;


import org.eclipse.milo.opcua.sdk.server.nodes.UaVariableNode;

public interface MonitorNode extends Runnable{

    public void setNode(UaVariableNode node);
    public void start();
    public void stop();
    public boolean isRunning();
}
