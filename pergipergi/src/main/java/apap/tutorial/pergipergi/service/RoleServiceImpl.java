package apap.tutorial.pergipergi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tutorial.pergipergi.model.RoleModel;
import apap.tutorial.pergipergi.repository.RoleDb;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDb roleDb;

    public List<RoleModel> findAll(){
        return roleDb.findAll();
    }
}
