package controller;

import java.util.List;

public abstract class InterfaceController<Entity, Key> {

    abstract public void create(Entity e);

    abstract public void update(Entity e);

    abstract public void deleteById(Key id);

    abstract public List<Entity> getAllList();

    abstract public Entity selectById(Key id);
}
