package com.cai.sdfs.namenode.server;

import java.util.LinkedList;
import java.util.List;

/**
 * 负责管理内存中的文件树
 * @author caiyiyang
 */
public class Directory {
    /**
     * 内存中的文件目录树
     */
    private final INodeDirectory dirTree;

    /**
     * 构造函数
     */
    public Directory() {
        this.dirTree = new INodeDirectory("/usr/warehouse/hive");
    }

    /**
     * 代表文件目录树中的一个节点
     */
    private interface INode {

    }

    /**
     * 代表文件目录树中的一个目录
     */
    public static class INodeDirectory implements INode {
        private String path;
        private List<INode> children;

        public INodeDirectory(String path) {
            this.path = path;
            this.children = new LinkedList<INode>();
        }

        public void addChild(INode inode) {
            this.children.add(inode);
        }
        public String getPath() {
            return path;
        }
        public void setPath(String path) {
            this.path = path;
        }
        public List<INode> getChildren() {
            return children;
        }
        public void setChildren(List<INode> children) {
            this.children = children;
        }
    }

    /**
     * 代表文件目录树中的一个文件
     */
    public static class INodeFile implements INode {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * 创建一个目录
     * @param path 目录路径
     */
    public void makeDirectory(String path) {
        //  假设path = /usr/warehouse/hive
        synchronized (dirTree) {
            String[] paths = path.split("/");
            INodeDirectory parent = dirTree;

            for (String splitPath : paths) {
                if ("".equals(splitPath.trim())) {
                    continue;
                }
                // 递归的查找节点
                INodeDirectory directory = findDirectory(dirTree, splitPath);

                // 如果找到了，就继续往下面找
                if (directory != null){
                    parent = directory;
                    continue;
                }

                // 如果没有找到，就创建一个子节点，挂上去
                INodeDirectory child = new INodeDirectory(splitPath);
                parent.addChild(child);
            }
        }
    }

    /**
     * 对文件目录树递归的查找目录
     * @param directory 文件目录树
     * @param path 路径
     * @return 处理结果
     */
    private INodeDirectory findDirectory(INodeDirectory directory, String path) {
        if (directory.getChildren().size() == 0) {
            return null;
        }

        INodeDirectory resultDirectory = null;

        for (INode child : directory.getChildren()) {
            if (child instanceof INodeDirectory) {
                INodeDirectory childDir = (INodeDirectory) child;

                if (childDir.getPath().equals(path)) {
                    return childDir;
                }

                resultDirectory = findDirectory(childDir, path);

                if (resultDirectory != null) {
                    return resultDirectory;
                }
            }
        }
        return null;
    }
}





















