package com.bingotree.zops.api.ops.openstack;

import com.bingotree.zops.api.ops.OpsService;
import com.bingotree.zops.api.web.request.MachineEntity;
import com.bingotree.zops.api.web.request.ResourceEntity;
import com.bingotree.zops.api.web.response.MachineResponse;
import com.bingotree.zops.api.web.response.ResourceResponse;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class OpenStackImpl implements OpsService {

    public OpenStackImpl() {
    }

    public ResourceResponse applyResource(ResourceEntity resourceEntity) {
        System.out.println("Apply Resource");
        return new ResourceResponse();
    }

    public ResourceResponse releaseResource(int id) {
        System.out.println("Release Resource");
        return new ResourceResponse();
    }

    public ResourceResponse migrateResource(int id, ResourceEntity resourceEntity) {
        System.out.println("Migrate Resource");
        return new ResourceResponse();
    }

    public ResourceResponse applyBatchResource(List<ResourceEntity> resourceEntityList) {
        System.out.println("Apply Batch Resource");
        return new ResourceResponse();
    }

    public ResourceResponse releaseBatchResource(List<ResourceEntity> resourceEntityList) {
        System.out.println("Release Batch Resource");
        return new ResourceResponse();
    }

    public MachineResponse addMachine(MachineEntity machineEntity) {
        System.out.println("Add Machine");
        return new MachineResponse();
    }

    public MachineResponse downMachine(int id) {
        System.out.println("Down Machine");
        return new MachineResponse();
    }

    public MachineResponse eatCPU(int id, MachineEntity machineEntity) {
        System.out.println("Eat CPU");
        return new MachineResponse();
    }

    public MachineResponse eatMemory(int id, MachineEntity machineEntity) {
        System.out.println("Eat Memory");
        return new MachineResponse();
    }

    public MachineResponse freeCPU(int id, MachineEntity machineEntity) {
        System.out.println("Free CPU");
        return new MachineResponse();
    }

    public MachineResponse freeMemory(int id, MachineEntity machineEntity) {
        System.out.println("Free Memory");
        return new MachineResponse();
    }
}
