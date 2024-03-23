package board.board.mapstruct;

import board.board.dto.BoardFileResDto;
import board.board.dto.BoardResDto;
import board.board.entity.BoardEntity;
import board.board.entity.BoardFileEntity;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-23T09:41:37+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.1.jar, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class BoardResMapStructImpl implements BoardResMapStruct {

    @Override
    public List<BoardResDto> toDto(List<BoardEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<BoardResDto> list = new ArrayList<BoardResDto>( entities.size() );
        for ( BoardEntity boardEntity : entities ) {
            list.add( toDto( boardEntity ) );
        }

        return list;
    }

    @Override
    public BoardResDto toDto(BoardEntity entiy) {
        if ( entiy == null ) {
            return null;
        }

        BoardResDto boardResDto = new BoardResDto();

        boardResDto.setBoardIdx( entiy.getBoardIdx() );
        boardResDto.setTitle( entiy.getTitle() );
        boardResDto.setContents( entiy.getContents() );
        boardResDto.setHitCnt( entiy.getHitCnt() );
        boardResDto.setCreatorId( entiy.getCreatorId() );
        if ( entiy.getCreatedDatetime() != null ) {
            boardResDto.setCreatedDatetime( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( entiy.getCreatedDatetime() ) );
        }
        boardResDto.setUpdaterId( entiy.getUpdaterId() );
        if ( entiy.getUpdatedDatetime() != null ) {
            boardResDto.setUpdatedDatetime( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( entiy.getUpdatedDatetime() ) );
        }
        boardResDto.setFileList( boardFileEntityCollectionToBoardFileResDtoList( entiy.getFileList() ) );

        return boardResDto;
    }

    protected BoardFileResDto boardFileEntityToBoardFileResDto(BoardFileEntity boardFileEntity) {
        if ( boardFileEntity == null ) {
            return null;
        }

        BoardFileResDto boardFileResDto = new BoardFileResDto();

        boardFileResDto.setIdx( boardFileEntity.getIdx() );
        boardFileResDto.setOriginalFileName( boardFileEntity.getOriginalFileName() );
        boardFileResDto.setStoredFilePath( boardFileEntity.getStoredFilePath() );
        boardFileResDto.setFileSize( boardFileEntity.getFileSize() );
        boardFileResDto.setCreatorId( boardFileEntity.getCreatorId() );
        boardFileResDto.setCreatedDatetime( boardFileEntity.getCreatedDatetime() );
        boardFileResDto.setUpdaterId( boardFileEntity.getUpdaterId() );
        boardFileResDto.setUpdatedDatetime( boardFileEntity.getUpdatedDatetime() );

        return boardFileResDto;
    }

    protected List<BoardFileResDto> boardFileEntityCollectionToBoardFileResDtoList(Collection<BoardFileEntity> collection) {
        if ( collection == null ) {
            return null;
        }

        List<BoardFileResDto> list = new ArrayList<BoardFileResDto>( collection.size() );
        for ( BoardFileEntity boardFileEntity : collection ) {
            list.add( boardFileEntityToBoardFileResDto( boardFileEntity ) );
        }

        return list;
    }
}
