package aed.individual4;

import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.PositionList;
import java.util.Iterator;

public class OrderedIterator implements Iterator<Integer> {

  // Tienes permiso, y debes, definir atributos nuvevos

  private PositionList<Integer> lista;

  private Position<Integer> pos;

  private Integer valAux;
  
  public OrderedIterator(PositionList<Integer> list) {
    this.lista = list;
    this.pos = lista.first();
    this.valAux = null;
  }

  // Implementa los metodos que hace falta
  //
  @Override
  public boolean hasNext() {
    if (pos == null) { return false; }
    if (valAux == null || valAux <= pos.element()) {
      return true;
    }
    pos = lista.next(pos);
    return hasNext();
  }

  @Override
  public Integer next() {
    if (!hasNext()) {
      throw new java.util.NoSuchElementException();
    }
    valAux = pos.element();
    pos = lista.next(pos);
    return valAux;
  }
}
