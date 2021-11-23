package com.cai.sdfs.namenode.server;

/**
 * @author caiyiyang
 */
public class NameNode {
    /**
     * 负责管理元数据的核心组件，管理文件目录树，支持权限设置。
     */
    private NameSystem nameSystem;
    /**
     * 负责管理集群中所有的Datanode的组件
     */
    private DataNodeManager dataNodeManager;
    /**
     * NameNode对外提供rpc接口的server，可以响应请求
     */
    private NameNodeRpcServer rpcServer;
    /**
     * 初始化nameNode
     */
    private void initialize() throws Exception {
        this.nameSystem = new NameSystem();
        this.dataNodeManager = new DataNodeManager();
        this.rpcServer = new NameNodeRpcServer(this.nameSystem, this.dataNodeManager);
    }
}













