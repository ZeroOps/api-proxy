package com.bingotree.zops.api.web;


import com.bingotree.zops.api.ops.OpsService;
import com.bingotree.zops.api.web.request.ResourceEntity;
import com.bingotree.zops.api.web.response.ResourceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputeResource {

    @Autowired
    private OpsService opsService;

    @RequestMapping(value="/v1/resources",
                    method= RequestMethod.POST,
                    consumes="application/json")
    public ResponseEntity<?> applyResource(@RequestBody ResourceEntity resourceEntity){
        ResourceResponse result = this.opsService.applyResource(resourceEntity);
        if (result.getResult() == 0) {
            return new ResponseEntity<ResourceResponse>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<ResourceResponse>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/v1/resources/{id}",
            method= RequestMethod.DELETE,
            consumes="application/json")
    public ResponseEntity<?> releaseResource(@PathVariable int id){
        ResourceResponse result = this.opsService.releaseResource(id);
        if (result.getResult() == 0) {
            return new ResponseEntity<ResourceResponse>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<ResourceResponse>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/v1/resources/{id}/migrate",
            method= RequestMethod.POST,
            consumes="application/json")
    public ResponseEntity<?> migrateResource(@PathVariable int id,
                                             @RequestBody ResourceEntity resourceEntity){
        ResourceResponse result = this.opsService.migrateResource(id, resourceEntity);
        if (result.getResult() == 0) {
            return new ResponseEntity<ResourceResponse>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<ResourceResponse>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/v1/batch/resources",
            method= RequestMethod.POST,
            consumes="application/json")
    public ResponseEntity<?> applyBatchResource(@RequestBody List<ResourceEntity> resourceEntityList){
        ResourceResponse result = this.opsService.applyBatchResource(resourceEntityList);
        if (result.getResult() == 0) {
            return new ResponseEntity<ResourceResponse>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<ResourceResponse>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/v1/batch/resources",
            method= RequestMethod.DELETE,
            consumes="application/json")
    public ResponseEntity<?> releaseBatchResource(@RequestBody List<ResourceEntity> resourceEntityList){
        ResourceResponse result = this.opsService.releaseBatchResource(resourceEntityList);
        if (result.getResult() == 0) {
            return new ResponseEntity<ResourceResponse>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<ResourceResponse>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
