package com.social.services;

import com.social.models.viewModels.BikeViewModel;

import java.util.List;

public interface BikeService {

    BikeViewModel findById(long id);

    List<BikeViewModel> findAll();
}
