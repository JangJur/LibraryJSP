<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회</title>
<link href="css/table.css" rel="stylesheet" type="text/css">

</head>
<body>
	${ error }
	<table style="border: 0px">
		<tr>
			<td colspan="7" style="border: 0px">
				<form name="search" method="post">
					<select name="keyField">
						<option value="0">----선택----</option>
						<option value="book_num">도서번호</option>
						<option value="book_name">제목</option>
						<option value="book_class">분류</option>
						<option value="book_pub">출판사</option>
						<option value="book_author">저자</option>
					</select> <input type="text" name="keyWord" /> <input type="hidden"
						name="job" value="search" /> <input type="button" value="검색"
						onclick="searchCheck(form)" />

				</form>
			</td>
		</tr>
	</table>
</body>
</html>