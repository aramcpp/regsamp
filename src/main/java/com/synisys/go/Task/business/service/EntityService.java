package com.synisys.go.Task.business.service;

import com.synisys.go.Task.business.model.Entity;
import com.synisys.go.Task.business.model.User;
import com.synisys.go.Task.business.service.exception.DuplicateUsernameException;
import com.synisys.go.Task.business.service.exception.IllegalUsernamePasswordCombinationException;
import com.synisys.go.Task.business.service.exception.NoSuchIdException;
import com.synisys.go.Task.business.service.exception.NoSuchUsernameException;
import com.synisys.go.Task.persistance.dao.EntityDao;

/**
 * Created by aram.hovhannisyan on 10/8/2016.
 */
public interface EntityService<T extends Entity> {
    T load(Integer id) throws NoSuchIdException;

    void save(T entity) throws DuplicateUsernameException;

    void delete(T entity) throws NoSuchIdException;

    T load(String username, String password) throws DuplicateUsernameException, NoSuchUsernameException, IllegalUsernamePasswordCombinationException;
}
