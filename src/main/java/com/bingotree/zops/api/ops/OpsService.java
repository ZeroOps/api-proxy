package com.bingotree.zops.api.ops;

import com.bingotree.zops.api.web.request.MachineEntity;
import com.bingotree.zops.api.web.request.ResourceEntity;
import com.bingotree.zops.api.web.response.MachineResponse;
import com.bingotree.zops.api.web.response.ResourceResponse;

import java.util.List;

/**
 * Created by thuanqin on 16/3/2.
 */
public interface OpsService {

    ResourceResponse applyResource(ResourceEntity resourceEntity);
    ResourceResponse releaseResource(int id);
    ResourceResponse migrateResource(int id, ResourceEntity resourceEntity);
    ResourceResponse applyBatchResource(List<ResourceEntity> resourceEntityList);
    ResourceResponse releaseBatchResource(List<ResourceEntity> resourceEntityList);

    MachineResponse addMachine(MachineEntity machineEntity);
    MachineResponse downMachine(int id);
    MachineResponse eatCPU(int id, MachineEntity machineEntity);
    MachineResponse eatMemory(int id, MachineEntity machineEntity);
    MachineResponse freeCPU(int id, MachineEntity machineEntity);
    MachineResponse freeMemory(int id, MachineEntity machineEntity);
}
