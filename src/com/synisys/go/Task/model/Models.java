package com.synisys.go.Task.model;

import java.util.function.Predicate;

/**
 * Model interface
 *
 * contains default method signatures for models
 */
public interface Models {
    boolean save(Model model);

    Model findFirst(Predicate<Model> predicate);

    Model[] findAll(Predicate<Model> predicate);
}
