package com.cai.sdfs.namenode.server;


/**
 * @author caiyiyang
 */
public class NameNodeRpcServer {
    public static final Integer DEFAULT_PORT = 50070;
    private NameSystem nameSystem;
    private DataNodeManager dataNodeManager;

    public NameNodeRpcServer(NameSystem nameSystem, DataNodeManager dataNodeManager) {
        this.nameSystem = nameSystem;
        this.dataNodeManager = dataNodeManager;
    }
}
