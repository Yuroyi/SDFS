package com.cai.sdfs.datanode.server;

/**
 * 负责和一组nameNode通讯的线程组件
 * @author caiyiyang
 */
public class NameNodeServiceActor {
    public static final String NAMENODE_HOSTNAME = "localhost";
    public static final Integer NAMENODE_PORT = 50070;

    class RegisterThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("Send rpc request to nameNode for registration");
                String ip = "127.0.0.1";
                String hostname = "SDFS_Data_01";
            }
        }
    }
}
