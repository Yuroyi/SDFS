package com.cai.sdfs.namenode.server;

/**
 * @author caiyiyang
 */
public class NameSystem {
    private Directory directory;
    private EditLog editlog;

    public NameSystem() {
        this.directory = new Directory();
        this.editlog = new EditLog();
    }

    public Boolean mkdir(String path) throws Exception {
        return true;
    }
}
