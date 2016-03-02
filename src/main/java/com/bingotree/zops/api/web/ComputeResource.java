package com.bingotree.zops.api.web;


import com.bingotree.zops.api.ops.OpsService;
import com.bingotree.zops.api.web.request.ResourceEntity;
import com.bingotree.zops.api.web.response.MsgResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComputeResource {

    @Autowired
    private OpsService opsService;

    @RequestMapping(value="/v1/resources",
                    method= RequestMethod.POST,
                    consumes="application/json")
    public ResponseEntity<?> createResource(@RequestBody ResourceEntity resourceEntity){
        System.out.println(resourceEntity.getDiskSize());
        this.opsService.ApplyResource(1, 2, 2);
        return new ResponseEntity<MsgResponse>(new MsgResponse("Successful"), HttpStatus.OK);
    }
}
