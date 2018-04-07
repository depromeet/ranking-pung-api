package com.deprommet.mini5.api.api.board;

import com.deprommet.mini5.api.dto.BoardItem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
public class BoardController {

	private static HashMap<String, ArrayList<BoardItem>> boardMap = new HashMap<>();

	@PostMapping("/board/item")
	public void addBoardItem(@RequestBody BoardItem boardItem) {
		if (!boardMap.containsKey(boardItem.getKeyWord())) {
			ArrayList<BoardItem> boardItemList = new ArrayList<>();
			boardItem.setNickname(boardItem.getNickname());
			boardItemList.add(boardItem);
			boardMap.put(boardItem.getKeyWord(), boardItemList);
		} else {
			boardItem.setNickname(boardItem.getNickname());
			boardMap.get(boardItem.getKeyWord()).add(boardItem);
		}
	}

	@GetMapping("/board/{keyWord}/list")
	public List<BoardItem> getBoardList(@PathVariable String keyWord) {
		if (boardMap.containsKey(keyWord)) {
			return boardMap.get(keyWord);
		} else {
			return Collections.emptyList();
		}
	}
}
