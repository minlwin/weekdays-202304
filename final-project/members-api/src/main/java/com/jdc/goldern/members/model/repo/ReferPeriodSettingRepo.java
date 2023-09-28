package com.jdc.goldern.members.model.repo;

import java.util.List;

import com.jdc.goldern.members.model.BaseRepository;
import com.jdc.goldern.members.model.entity.ReferPeriodSetting;

public interface ReferPeriodSettingRepo extends BaseRepository<ReferPeriodSetting, Integer>{

	List<ReferPeriodSetting> findAllOederByCreateAtDesc();

}
