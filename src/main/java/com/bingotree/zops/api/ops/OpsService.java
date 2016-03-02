package com.bingotree.zops.api.ops;

/**
 * Created by thuanqin on 16/3/2.
 */
public interface OpsService {

    boolean ApplyResource(int memorySize, int cpuSize, int diskSize);
    boolean ReleaseResource(int id);
    boolean migrateResource(int id, String currentMachineIp, String targetMachineIp);

}
