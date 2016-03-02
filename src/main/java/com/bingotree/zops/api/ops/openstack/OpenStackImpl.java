package com.bingotree.zops.api.ops.openstack;

import com.bingotree.zops.api.ops.OpsService;
import org.springframework.stereotype.Component;


@Component
public class OpenStackImpl implements OpsService {

    public OpenStackImpl() {
    }

    public boolean ApplyResource(int memorySize, int cpuSize, int diskSize) {
        System.out.println("Apply Resource");
        return false;
    }

    public boolean ReleaseResource(int id) {
        System.out.println("Release Resource");
        return false;
    }

    public boolean migrateResource(int id, String currentMachineIp, String targetMachineIp) {
        System.out.println("Migrate Resource");
        return false;
    }
}
