package Dlock.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;

import java.util.concurrent.CountDownLatch;

/**
 * Created by wangliang01 on 2020/2/16 using IDEA.
 */
public class ZkLock {
    private static final String WORKSPACE = "locl-workspace";

    private String lockName;

    //zkClinet
    private CuratorFramework client;

    public ZkLock(String lockName) {
        this.lockName = lockName;
        init();
    }

    public void init() {
        // 从容器中拿到配置好的client
        client = null;
        try{
            if(client.checkExists().forPath(WORKSPACE) == null) {
                client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE).forPath(WORKSPACE);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    // 创建临时节点
    public void getLock() throws Exception {
        while (true) {
            try{
                String lockPath = WORKSPACE + "/" + lockName;
                if(client.checkExists().forPath(lockPath) == null) {
                    client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE).forPath(lockPath);
                }else {
                    // 该子节点已经存在,说明锁已被占用,则阻塞直至收到所释放的通知然后再次尝试创建节点获取锁
                    listenAndWait();
                }
            }catch(Exception e) {
                //异常也进行重试
                listenAndWait();
            }
        }

    }

    public void release() {
        String lockPath = WORKSPACE + "/" + lockName;
        try {
            // 如果锁还存在，则进行删除即代表释放锁
            if(client.checkExists().forPath(lockPath) != null) {
                client.delete().forPath(lockPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listenAndWait() throws Exception {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        PathChildrenCache pathChildrenCache  = new PathChildrenCache(client, WORKSPACE, true);
        pathChildrenCache.start();
        pathChildrenCache.getListenable().addListener(
                new PathChildrenCacheListener() {
                    @Override
                    public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent event) throws Exception {
                        if(event.getType().equals(PathChildrenCacheEvent.Type.CHILD_REMOVED) && event.getData().getPath().contains(lockName)) {
                            countDownLatch.countDown();
                        }
                    }
                }

        );

        countDownLatch.await();
    }
}
