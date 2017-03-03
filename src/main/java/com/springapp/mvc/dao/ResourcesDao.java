package com.springapp.mvc.dao;

import com.springapp.mvc.model.Resources;
import java.util.Date;
import java.util.List;

/**
 * Created by Maxim.Temborskiy on 21.01.2017.
 */
public interface ResourcesDao {
    public void addResources(Resources resources);
    public void removeResources(Date time);
    public Resources getResourcesByTime(Date time);
    public List<Resources> listResources();
    public List<Resources> listLimitedResources();
}
