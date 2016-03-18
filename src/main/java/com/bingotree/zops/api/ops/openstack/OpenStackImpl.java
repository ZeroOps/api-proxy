package com.bingotree.zops.api.ops.openstack;

import com.bingotree.zops.api.ops.OpsService;
import com.bingotree.zops.utils.db.MySQLHandler;
import com.bingotree.zops.api.web.request.MachineEntity;
import com.bingotree.zops.api.web.request.ResourceEntity;
import com.bingotree.zops.api.web.response.MachineResponse;
import com.bingotree.zops.api.web.response.ResourceResponse;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Component;

import java.sql.*;
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
        MySQLHandler mySQLHandler = new MySQLHandler();
        String SQL = "INSERT INTO MACHINES(ip, cpu_num, memory_size, disk_size, status, round_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = mySQLHandler.getConn().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, machineEntity.getIp());
            pst.setInt(2, machineEntity.getCpuNumer());
            pst.setInt(3, machineEntity.getMemorySize());
            pst.setInt(4, machineEntity.getDiskSize());
            pst.setString(5, "RUNNING");
            pst.setInt(6, machineEntity.getRoundId());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            rs.next();
            return new MachineResponse().setResult(0).setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
            return new MachineResponse().setResult(-1);
        }
    }

    public MachineResponse downMachine(int id) {
        System.out.println("Down Machine");
        MySQLHandler mySQLHandler = new MySQLHandler();
        String SQL = "UPDATE MACHINES SET status=? WHERE id=?";
        try {
            PreparedStatement pst = mySQLHandler.getConn().prepareStatement(SQL);
            pst.setString(1, "DOWN");
            pst.setInt(2, id);
            pst.executeUpdate();
            return new MachineResponse().setResult(0);
        } catch (SQLException e) {
            e.printStackTrace();
            return new MachineResponse().setResult(-1);
        }
    }

    public MachineResponse eatCPU(int id, MachineEntity machineEntity) {
        System.out.println("Eat CPU");
        MySQLHandler mySQLHandler = new MySQLHandler();
        try {
            String SQL = "SELECT cpu_num FROM MACHINES WHERE id=" + id;
            Statement stmt = mySQLHandler.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
            int currentCPUNumber = rs.getInt(1);

            SQL = "SELECT COUNT(VMS.cpu_num) AS cnt FROM VMS, MACHINES " +
                    "WHERE VMS.machine_id=MACHINES.id AND MACHINES.id=?";
            PreparedStatement pst = mySQLHandler.getConn().prepareStatement(SQL);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            int currentCPUNumberCost = rs.getInt(1);
            if (currentCPUNumberCost + machineEntity.getCpuEatNumber() >= currentCPUNumber) {
                System.out.println("01 EAT TOO MUCH CPU, IGNORE IT.");
                return new MachineResponse().setResult(0);
            } else if (currentCPUNumber - machineEntity.getCpuEatNumber() <= 0) {
                System.out.println("02 EAT TOO MUCH CPU, IGNORE IT.");
                return new MachineResponse().setResult(0);
            }else {
                SQL = "UPDATE MACHINES SET cpu_num=cpu_num-? WHERE " +
                        "id=?";
                pst = mySQLHandler.getConn().prepareStatement(SQL);
                pst.setInt(1, machineEntity.getCpuEatNumber());
                pst.setInt(2, id);
                pst.executeUpdate();
                return new MachineResponse().setResult(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();;
            return new MachineResponse().setResult(-1);
        }
    }

    public MachineResponse eatMemory(int id, MachineEntity machineEntity) {
        System.out.println("Eat Memory");
        MySQLHandler mySQLHandler = new MySQLHandler();
        try {
            String SQL = "SELECT memory_size FROM MACHINES WHERE id=" + id;
            Statement stmt = mySQLHandler.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            rs.next();
            int currentMemorySize = rs.getInt(1);

            SQL = "SELECT COUNT(VMS.memory_size) AS cnt FROM VMS, MACHINES " +
                    "WHERE VMS.machine_id=MACHINES.id AND MACHINES.id=?";
            PreparedStatement pst = mySQLHandler.getConn().prepareStatement(SQL);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            rs.next();
            int currentMemorySizeCost = rs.getInt(1);
            if (currentMemorySizeCost + machineEntity.getMemoryEatSize() >= currentMemorySize) {
                System.out.println("01 EAT TOO MUCH MEMORY, IGNORE IT.");
                return new MachineResponse().setResult(0);
            } else if (currentMemorySize - machineEntity.getMemoryEatSize() <= 0) {
                System.out.println("02 EAT TOO MUCH MEMORY, IGNORE IT.");
                return new MachineResponse().setResult(0);
            }else {
                SQL = "UPDATE MACHINES SET memory_size=memory_size-? WHERE " +
                        "id=?";
                pst = mySQLHandler.getConn().prepareStatement(SQL);
                pst.setInt(1, machineEntity.getMemoryEatSize());
                pst.setInt(2, id);
                pst.executeUpdate();
                return new MachineResponse().setResult(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();;
            return new MachineResponse().setResult(-1);
        }
    }

    public MachineResponse freeCPU(int id, MachineEntity machineEntity) {
        System.out.println("Free CPU");
        MySQLHandler mySQLHandler = new MySQLHandler();
        try {
            String SQL = "UPDATE MACHINES SET cpu_num=cpu_num+? WHERE id=?";
            PreparedStatement pst = mySQLHandler.getConn().prepareStatement(SQL);
            pst.setInt(1, machineEntity.getCpuEatNumber());
            pst.setInt(2, id);
            pst.executeUpdate();
            return new MachineResponse().setResult(0);
        } catch (SQLException e) {
            e.printStackTrace();;
            return new MachineResponse().setResult(-1);
        }
    }

    public MachineResponse freeMemory(int id, MachineEntity machineEntity) {
        System.out.println("Free Memory");
        MySQLHandler mySQLHandler = new MySQLHandler();
        try {
            String SQL = "UPDATE MACHINES SET memory_size=memory_size+? WHERE id=?";
            PreparedStatement pst = mySQLHandler.getConn().prepareStatement(SQL);
            pst.setInt(1, machineEntity.getMemoryEatSize());
            pst.setInt(2, id);
            pst.executeUpdate();
            return new MachineResponse().setResult(0);
        } catch (SQLException e) {
            e.printStackTrace();;
            return new MachineResponse().setResult(-1);
        }
    }
}
