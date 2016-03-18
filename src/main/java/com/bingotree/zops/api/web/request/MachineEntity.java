package com.bingotree.zops.api.web.request;

/**
 * Created by thuanqin on 16/3/4.
 */
public class MachineEntity {

    private int roundId;

    private int cpuEatNumber; // 吃掉多少CPU
    private int memoryEatSize; //吃点多少内存

    private int cpuNumer;
    private int memorySize;
    private int diskSize;

    private String ip;

    public MachineEntity() {
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getCpuEatNumber() {
        return cpuEatNumber;
    }

    public void setCpuEatNumber(int cpuEatNumber) {
        this.cpuEatNumber = cpuEatNumber;
    }

    public int getMemoryEatSize() {
        return memoryEatSize;
    }

    public void setMemoryEatSize(int memoryEatSize) {
        this.memoryEatSize = memoryEatSize;
    }

    public int getCpuNumer() {
        return cpuNumer;
    }

    public void setCpuNumer(int cpuNumer) {
        this.cpuNumer = cpuNumer;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }
}
