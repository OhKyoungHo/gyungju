  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ page import="java.util.List"%>
  <%@ page import="com.example.domain.CalendarVO"%>

<!DOCTYPE html>
<html>
<head>

  <meta charset='utf-8' />
  <title>캘린더</title>
  <!-- 화면 해상도에 따라 글자 크기 대응(모바일 대응) -->
  <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <!-- jquery CDN -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <!-- fullcalendar CDN -->
  <link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.css' rel='stylesheet' />
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js'></script>
  <!-- fullcalendar 언어 CDN -->
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.min.js'></script>
<style>
  /* body 스타일 */
  html, body {
    overflow: hidden;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 15px;
  }
  /* 캘린더 위의 해더 스타일(날짜가 있는 부분) */
  .fc-header-toolbar {
    padding-top: 1em;
    padding-left: 1em;
    padding-right: 1em;
    
  }
</style>
</head>
<body style="padding:30px;">
  <!-- calendar 태그 -->
  <div id='calendar-container'>
    <div id='calendar'></div>
  </div>
  
  <script>
  document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		initialView : 'dayGridMonth',
		locale : 'ko', // 한국어 설정
		headerToolbar : {
        	left: 'prev,next today',
            center: 'title'	,
            end : 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
            },
            height: '700px', // calendar 높이 설정
        	expandRows: true, // 화면에 맞게 높이 재설정
        	slotMinTime: '08:00', // Day 캘린더에서 시작 시간
        	slotMaxTime: '20:00', // Day 캘린더에서 종료 시간
        	navLinks: true, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
        	nowIndicator: true, // 현재 시간 마크
			selectable : true,
			droppable : true,
			eventLimit : true,
			backgroundColor: '#378006',
			display: 'background',
			events : [ 
  					<% List<CalendarVO> calendarList = (List<CalendarVO>) request.getAttribute("calendarList"); %>
            		<% if (calendarList != null) {%>
            		<% for (CalendarVO vo : calendarList) {%>
            		{
		            	title : '<%=vo.getCalTitle()%>',
		                start : '<%=vo.getCalStart()%>',
		                end : '<%=vo.getCalEnd()%>',
		                display: 'background',
		                color : '#' + Math.round(Math.random() * 0xffffff).toString(16)
             		},
				<% }
			} %>
					]
				
			});
			calendar.render();
		});
  

</script>
</body>
</html>