package com.system.mandatory2.repositories;

import com.system.mandatory2.domain.Account;
import com.system.mandatory2.domain.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by gerli on 28/11/2017.
 */
public interface AccountRepo extends CrudRepository<Account, Integer>{


}
