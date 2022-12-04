package Modelo.interfaces;

import java.util.List;

/**
 *
 * @author Aylin Camila Orjuela Leiva & Juan Pablo Cuellar Florez
 */
public interface Obligacion <Cualquiercosa> {
    public boolean create (Cualquiercosa nuevo);
    public List<Cualquiercosa> readAll();
    public Cualquiercosa read (Cualquiercosa filter);
    public boolean update (Cualquiercosa item);
    public boolean delete (Cualquiercosa item);
}
