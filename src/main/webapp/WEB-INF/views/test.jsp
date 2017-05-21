<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
#modDiv {
    width:300px;
    height:100px;
    background-color: gray;
    position: absolute;
    top: 50%;
    left: 50%;
    margin-top: -50px;
    margin-left: -150px;
    padding: 10px;
    z-index: 1000;
}
</style>
</head>
<body>
    <h2>Ajax Test Page</h2>
    <div>
        <div>
         REPLYER <input type="text" name="replyer" id="newReplyWriter">
        </div>
         <div>
         REPLY TEXT <input type="text" name="replytext" id="newReplyText">
        </div>
        <button id="replyAddBtn">ADD REPLY</button>
    </div>
    
    <ul id="replies">
      
    </ul>
    <div id="modDiv" style="display: none;">
        <div class="modal-title"></div>
        <div>
            <input type="text" id="replytext">
        </div>
        <div>
            <button type="button" id="replyModBtn">Modify</button>
            <button type="button" id="replyDelBtn">DELETE</button>
            <button type="button" id="closBtn">Close</button>
        </div>
    </div>
    <ul class="pagination">
    </ul>
    <!-- jQuery -->
    <script src="/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script type="text/javascript">
    
    $(document).ready(function(){
    	getPageList(1);
    });
   
    var bbsno = 6127;
    
        function getAllList() {
        	
        	$.getJSON("/replies/all/" + bbsno, function(data) {
        		
            	var str = "";
            	console.log(data.length);
            	
            	$(data).each (function() {
            		str += "<li data-replyno='"+this.replyno+"' class='replyLi'>"
            		    + this.replyno + ": " + this.replytext + "<button>MOD</button></li>";
            	});
            	
            	$("#replies").html(str);
            });
        	
        } // ajax 댓글 전체 목록
        
        $("#replyAddBtn").on("click", function() {
        	
        	var replyer = $("#newReplyWriter").val();
        	var replytext = $("#newReplyText").val();
        	
        	$.ajax({
        		type : 'post',
        		url : '/replies',
        		headers : {
        			"Content-Type" : "application/json",
        			"X-HTTP-Method-Override" : "POST"
        		},
        		dataType : 'text',
        		data : JSON.stringify({
        			bbsno : bbsno,
        			replyer : replyer,
        			replytext : replytext
        		}),
        		success : function(result) {
        			
        			if (result == 'SUCCESS') {
        				alert("글이 등록되었습니다.");
        				getAllList();
        			}
        		}
        	});
        });  // ajax 댓글 등록
        
        $("#replies").on("click", ".replyLi button", function(){
        	var reply = $(this).parent();
        	
        	var replyno = reply.attr("data-replyno");
        	var replytext = reply.text();
        	
        	$(".modal-title").html(replyno);
        	$("#replytext").val(replytext);
        	$("#modDiv").show("slow");
        })  // ajax 수정및 삭제 모달화면 호출
        
       	$("#replyDelBtn").on("click",function() {
       		
       		var replyno = $(".modal-title").html();
       		var replytext = $("#replytext").val();
       		
       		$.ajax({
       			type : 'delete',
       			url : '/replies/' + replyno,
       			headers : {
       				"Content-type" : "application/json",
       				"X-HTTP-Method-Override" : "DELETE"
       			},
       			dataTyp : 'text',
       			success : function(result) {
       				console.log("result : " + result);
       				if (result == 'SUCCESS') {
       					alert('삭제 되었습니다.');
       					$('#modDiv').hide("slow");
       					getAllList();
       				}
       			}
       		});
       	});  //ajax 댓글 삭제.
       	
       	$("#replyModBtn").on("click", function() {
       		var replyno = $(".modal-title").html();
       		var replytext = $("#replytext").val();
       		
       		$.ajax({
       			type : 'put',
       			url : '/replies/' + replyno,
       			headers : {
       				"Content-Type": "application/json",
       				"X-HTTP-Method-Override": "PUT"
       			},
       			data : JSON.stringify({
       				replytext:replytext
       			}),
       			dataType : 'text',
       			success : function(result) {
       				console.log("result : " + result);
       				
       				if (result == 'SUCCESS') {
       					alert("수정 되었습니다.");
       					$("#modDiv").hide("slow");
       					getPageList(replyPage);
       				}
       			}
       			
       		});
       	});  // ajax 댓글 수정
       	
       	function getPageList(page) {
       		$.getJSON("/replies/6127/1",  function(data) {
       			console.log(data);
       			console.log(data.replyList.length);
       			
       			var str = "";
       			
       			$(data.replyList).each(function() {
       				str += "<li data-replyno='"+this.replyno+"' class='replyLi'>"
        		    + this.replyno + ": " + this.replytext + "<button>MOD</button></li>";
       			});
       			
       			$("#replies").html(str);
       			
       			printPaging(data.pageMaker);
       		});
       	}
       	
       	function printPaging(pageMaker) {
       		
       		console.log(pageMaker);
       		
       		var str = "";
       		
       		if (pageMaker.prev) {
       			str += "<li><a href='"+(pageMaker.startPage-1)+"'> << </a></li>";
       		}
       		
       		for (var i = pageMaker.startPage, len = pageMaker.endPage; i < len; i++) {
				var strClass = pageMaker.criteriaVO.page == i ? 'class=active':'';
				star += "<li " + starClass + "><a href='"+i+"</a></li>";
			}
       		
       		if (pageMaker.next) {
       			str += "<li><a href='"+(pageMaker.endPage + 1)+"'> >> </a></li>";
       		}
       		$('.pagination').html(str);
       	}
        
    </script>
</body>
</html>