package com.system.mandatory2.repositories;

import com.system.mandatory2.domain.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gerli on 28/11/2017.
 */
public interface RoleRepo extends CrudRepository<Role, Integer>{
    Role findByRoleName(String roleName);
}
