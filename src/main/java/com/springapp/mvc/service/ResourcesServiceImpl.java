package com.springapp.mvc.service;

import com.springapp.mvc.dao.ResourcesDao;
import com.springapp.mvc.model.Resources;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by Maxim.Temborskiy on 21.01.2017.
 */
@Service
public class ResourcesServiceImpl implements ResourcesService {
   private ResourcesDao resourcesDao;

    public void setResourcesDao(ResourcesDao resourcesDao) {
        this.resourcesDao = resourcesDao;
    }


    @Override
    @Transactional
    public void addResources(Resources resources) {

    // Add date
        Date d = new Date(new Date().getTime());
        resources.setTime(d);

    //Get a list of all filesystem roots on this system
        File[] roots = File.listRoots();

    // For each filesystem root, print some info(HDD in this case)
        for (File root : roots) {
            int freeSpace = (int) (root.getFreeSpace()/1048576);
            resources.setHdd(freeSpace);
            break;  // loop it just once (for one disk)
        }


        this.resourcesDao.addResources(resources);
    }

    @Override
    @Transactional
    public void removeResources(Date time) {

    }

    @Override
    @Transactional
    public Resources getResourcesByTime(Date time) {
        return null;
    }

    @Override
    @Transactional
    public List<Resources> listResources() {
        return this.resourcesDao.listResources();
    }


    @Transactional
    public List<Resources> listLimitedResources() {
        return this.resourcesDao.listLimitedResources();
    }

}
