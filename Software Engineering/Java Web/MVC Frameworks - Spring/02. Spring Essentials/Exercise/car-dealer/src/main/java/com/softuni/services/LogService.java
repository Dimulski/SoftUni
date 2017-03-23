package com.softuni.services;

import com.softuni.models.bindingModels.log.LogModel;
import com.softuni.models.viewModels.log.LogView;

import java.util.List;

public interface LogService {

    void persist(LogModel logModel);
    List<LogView> getAllByUsername(String username);
    void deleteAllLogs();
}
