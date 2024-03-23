package board.board.controller;

import java.util.List;


import board.board.dto.BoardReqDto;
import board.board.dto.BoardResDto;
import board.board.service.JpaBoardService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import board.board.dto.BoardDto;
import board.board.service.BoardService;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Api(description="게시판 REST API")
@RestController
public class RestBoardApiController {

	@Autowired
	private JpaBoardService boardService;

	@ApiOperation(value = "게시글 목록 조회")
	@RequestMapping(value="/api/board", method=RequestMethod.GET)
	public List<BoardResDto> openBoardList() throws Exception{
		return boardService.selectBoardList();
	}

	@ApiOperation(value = "게시글 작성")
	@RequestMapping(value="/api/board/write", method=RequestMethod.POST)
	public void insertBoard(@RequestBody BoardReqDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
		boardService.saveBoard(board, multipartHttpServletRequest);
	}

	@ApiOperation(value = "게시글 상세 내용 조회")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Bad Request, invalid format of the request. See response message for more information."),
			@ApiResponse(code = 404, message = "Not found, the specified id does not exist."),
			@ApiResponse(code = 422, message = "Unprocessable entity, input parameters caused the processing to fails. See response message for more information.")
	})


	@RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.GET)
	@Cacheable(key = "#boardIdx", value ="BOARD")
	public BoardResDto openBoardDetail(@PathVariable("boardIdx") @ApiParam(value="게시글 번호") int boardIdx) throws Exception{

		return boardService.selectBoardDetail(boardIdx);
	}

	@ApiOperation(value = "게시글 상세 내용 수정")
	@RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.PUT)
	@CacheEvict(key = "#boardIdx", value ="BOARD")
	public void updateBoard(@RequestBody BoardReqDto board,MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
		boardService.saveBoard(board,multipartHttpServletRequest);
	}

	@ApiOperation(value = "게시글 삭제")
	@RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.DELETE)
	@CacheEvict(key = "#boardIdx", value ="BOARD")
	public void deleteBoard(@PathVariable("boardIdx") @ApiParam(value="게시글 번호") int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
	}
}
