package controller;

import java.util.List;

public abstract class ChiTietInterfaceController<Entity, Key> {

    abstract public void create(List<Entity> e);

    abstract public void update(String id, List<Entity> e);

    abstract public void deleteById(Key id);

    abstract public List<Entity> selectAllById(Key id);
}
