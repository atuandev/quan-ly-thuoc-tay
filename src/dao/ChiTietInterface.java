package dao;

import java.util.List;

/**
 *
 * @author Atuandev
 * @param <E>
 * @param <Key>
 */
public interface ChiTietInterface<E, Key> {

    public void insert(List<E> e);

    public void update(Key k, List<E> e);

    public void deleteById(Key k);

    public List<E> selectAllById(Key k);
}
