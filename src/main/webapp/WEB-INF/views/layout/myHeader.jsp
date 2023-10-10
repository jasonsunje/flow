<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>

<body>
	<div class="mypage" align="center">
		<div class="top_nav">
			<table style="border-spacing: 10px; border-collapse: separate;">
				<tr>
					<td style="border-right: 1px solid;">
						<body>
							<div
								style="position: absolute; text-align: center; width: 100%; height: 100%; top: 0; left: 0;">
								<div>
									<h2>파일 확장자 차단</h2>
									<div>
										고정 확장자 : <label><input type="checkbox" value="bat"
											id="bat" />bat</label> <label><input type="checkbox"
											value="cmd" id="cmd" />cmd</label> <label><input
											type="checkbox" value="com" id="com" />com</label> <label><input
											type="checkbox" value="cpl" id="cpl" />cpl</label> <label><input
											type="checkbox" value="exe" id="exe" />exe</label> <label><input
											type="checkbox" value="scr" id="scr" />scr</label> <label><input
											type="checkbox" value="js" id="js" />js</label>
									</div>
									<br>
									<div>
										<label>커스텀 확장자 : <input placeholder="확장자 입력"
											type="text" id="custom_extension" />
											<button id="addButton">추가</button></label>
									</div>
									<br>
									<div id="custom"
										style="border: 1px solid black; width: 30%; height: 400px; margin: 0 auto;">
										<div id="num"></div>
									</div>
								</div>
							</div>
						</body>
						</html>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>