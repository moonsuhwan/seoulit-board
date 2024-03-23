package board.board.mapstruct;

import board.board.dto.BoardFileReqDto;
import board.board.dto.BoardReqDto;
import board.board.entity.BoardEntity;
import board.board.entity.BoardFileEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-23T09:41:38+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.1.jar, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class BoardReqMapStructImpl implements BoardReqMapStruct {

    @Override
    public List<BoardEntity> toEntity(List<BoardReqDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<BoardEntity> list = new ArrayList<BoardEntity>( dtos.size() );
        for ( BoardReqDto boardReqDto : dtos ) {
            list.add( toEntity( boardReqDto ) );
        }

        return list;
    }

    @Override
    public BoardEntity toEntity(BoardReqDto dto) {
        if ( dto == null ) {
            return null;
        }

        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setBoardIdx( dto.getBoardIdx() );
        boardEntity.setTitle( dto.getTitle() );
        boardEntity.setContents( dto.getContents() );
        boardEntity.setHitCnt( dto.getHitCnt() );
        boardEntity.setCreatorId( dto.getCreatorId() );
        if ( dto.getCreatedDatetime() != null ) {
            boardEntity.setCreatedDatetime( LocalDateTime.parse( dto.getCreatedDatetime() ) );
        }
        boardEntity.setUpdaterId( dto.getUpdaterId() );
        if ( dto.getUpdatedDatetime() != null ) {
            boardEntity.setUpdatedDatetime( LocalDateTime.parse( dto.getUpdatedDatetime() ) );
        }
        boardEntity.setFileList( boardFileReqDtoListToBoardFileEntityCollection( dto.getFileList() ) );

        return boardEntity;
    }

    protected BoardFileEntity boardFileReqDtoToBoardFileEntity(BoardFileReqDto boardFileReqDto) {
        if ( boardFileReqDto == null ) {
            return null;
        }

        BoardFileEntity boardFileEntity = new BoardFileEntity();

        boardFileEntity.setIdx( boardFileReqDto.getIdx() );
        boardFileEntity.setOriginalFileName( boardFileReqDto.getOriginalFileName() );
        boardFileEntity.setStoredFilePath( boardFileReqDto.getStoredFilePath() );
        boardFileEntity.setFileSize( boardFileReqDto.getFileSize() );
        boardFileEntity.setCreatorId( boardFileReqDto.getCreatorId() );
        boardFileEntity.setCreatedDatetime( boardFileReqDto.getCreatedDatetime() );
        boardFileEntity.setUpdaterId( boardFileReqDto.getUpdaterId() );
        boardFileEntity.setUpdatedDatetime( boardFileReqDto.getUpdatedDatetime() );

        return boardFileEntity;
    }

    protected Collection<BoardFileEntity> boardFileReqDtoListToBoardFileEntityCollection(List<BoardFileReqDto> list) {
        if ( list == null ) {
            return null;
        }

        Collection<BoardFileEntity> collection = new ArrayList<BoardFileEntity>( list.size() );
        for ( BoardFileReqDto boardFileReqDto : list ) {
            collection.add( boardFileReqDtoToBoardFileEntity( boardFileReqDto ) );
        }

        return collection;
    }
}
