package com.bingotree.zops.api.web.request;


public class ResourceEntity {

    private int memorySize = 512; // unit is MB
    private int cpuNumber = 16;
    private int diskSize = 2048; // unit is MB
    private String currentMachineIp;
    private String targetMachineIp;

    public ResourceEntity() {
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public int getCpuNumber() {
        return cpuNumber;
    }

    public void setCpuNumber(int cpuNumber) {
        this.cpuNumber = cpuNumber;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }

    public String getCurrentMachineIp() {
        return currentMachineIp;
    }

    public void setCurrentMachineIp(String currentMachineIp) {
        this.currentMachineIp = currentMachineIp;
    }

    public String getTargetMachineIp() {
        return targetMachineIp;
    }

    public void setTargetMachineIp(String targetMachineIp) {
        this.targetMachineIp = targetMachineIp;
    }
}
