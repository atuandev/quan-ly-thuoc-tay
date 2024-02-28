package dao;

import java.util.List;

public abstract class InterfaceDAO<Entity, Key> {

    abstract public void create(Entity e);

    abstract public void update(Entity e);

    abstract public void deleteById(Key k);

    abstract protected List<Entity> selectBySql(String sql, Object... args);

    abstract public List<Entity> selectAll();

    abstract public Entity selectById(Key k);
}
