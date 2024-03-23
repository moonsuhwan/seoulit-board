package board.board.service;

import java.util.List;

import board.board.dto.BoardReqDto;
import board.board.dto.BoardResDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.board.entity.BoardEntity;
import board.board.entity.BoardFileEntity;

public interface JpaBoardService {

	List<BoardResDto> selectBoardList() throws Exception;

	void saveBoard(BoardReqDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
	
	BoardResDto selectBoardDetail(int boardIdx) throws Exception;

	void deleteBoard(int boardIdx);

	BoardFileEntity selectBoardFileInformation(int boardIdx, int idx) throws Exception;
}
