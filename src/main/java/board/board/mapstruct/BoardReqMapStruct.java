package board.board.mapstruct;

import board.board.dto.BoardReqDto;
import board.board.entity.BoardEntity;
import board.common.mapper.EntityReqMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoardReqMapStruct extends EntityReqMapper<BoardEntity, BoardReqDto>
{
    //@Mapping(target = "createDate", ignore = true)
    @Override
    BoardEntity toEntity(BoardReqDto dto) ;
}
