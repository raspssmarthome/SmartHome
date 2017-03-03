package com.springapp.mvc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Maxim.Temborskiy on 21.01.2017.
 */
@Entity
@Table(name = "resources")
public class Resources implements Serializable{
   @Id
   @Column(name = "time")
    private Date time;

    @Column(name = "CPU")
    private int cpu;

    @Column(name = "RAM")
    private int ram;

    @Column(name = "HDD")
    private int hdd;


    public Date getTime() {
        return time;
    }

    public void setTime(Date  time) {
        this.time = time;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }
}


