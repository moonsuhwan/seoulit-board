package board.common.mapper;

import java.util.List;

public interface EntityResMapper<E,D> {


    D toDto(E entiy);


    List<D> toDto(List<E> entities);
}
