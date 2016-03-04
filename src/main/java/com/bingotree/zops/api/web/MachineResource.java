package com.bingotree.zops.api.web;

import com.bingotree.zops.api.ops.OpsService;
import com.bingotree.zops.api.web.request.MachineEntity;
import com.bingotree.zops.api.web.response.MachineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MachineResource {

    @Autowired
    private OpsService opsService;

    @RequestMapping(value="/v1/machines",
            method= RequestMethod.POST,
            consumes="application/json")
    public ResponseEntity<?> addMachine(@RequestBody MachineEntity machineEntity){
        MachineResponse result = this.opsService.addMachine(machineEntity);
        if (result.getResult() == 0){
            return new ResponseEntity<MachineResponse>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<MachineResponse>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/v1/machines/{id}/down",
            method= RequestMethod.POST,
            consumes="application/json")
    public ResponseEntity<?> downMachine(@PathVariable int id){
        MachineResponse result = this.opsService.downMachine(id);
        if (result.getResult() == 0){
            return new ResponseEntity<MachineResponse>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<MachineResponse>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/v1/machines/{id}/eat/cpu",
            method= RequestMethod.POST,
            consumes="application/json")
    public ResponseEntity<?> eatMachineCPU(@PathVariable int id,
                                           @RequestBody MachineEntity machineEntity){
        MachineResponse result = this.opsService.eatCPU(id, machineEntity);
        if (result.getResult() == 0){
            return new ResponseEntity<MachineResponse>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<MachineResponse>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/v1/machines/{id}/eat/memory",
            method= RequestMethod.POST,
            consumes="application/json")
    public ResponseEntity<?> eatMachineMemory(@PathVariable int id,
                                              @RequestBody MachineEntity machineEntity){
        MachineResponse result = this.opsService.eatMemory(id, machineEntity);
        if (result.getResult() == 0){
            return new ResponseEntity<MachineResponse>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<MachineResponse>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/v1/machines/{id}/free/cpu",
            method= RequestMethod.POST,
            consumes="application/json")
    public ResponseEntity<?> freeMachineCPU(@PathVariable int id,
                                            @RequestBody MachineEntity machineEntity){
        MachineResponse result = this.opsService.freeCPU(id, machineEntity);
        if (result.getResult() == 0){
            return new ResponseEntity<MachineResponse>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<MachineResponse>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/v1/machines/{id}/free/memory",
            method= RequestMethod.POST,
            consumes="application/json")
    public ResponseEntity<?> freeMachineMemory(@PathVariable int id,
                                               @RequestBody MachineEntity machineEntity){
        MachineResponse result = this.opsService.freeMemory(id, machineEntity);
        if (result.getResult() == 0){
            return new ResponseEntity<MachineResponse>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<MachineResponse>(result, HttpStatus.BAD_REQUEST);
        }
    }
}
