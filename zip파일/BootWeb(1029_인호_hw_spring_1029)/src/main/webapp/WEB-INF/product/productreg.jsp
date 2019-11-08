<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<script type="text/javascript">
    function insert(){
    	productform.action="productinsert";
    	productform.submit();
    }
    function update(){
    	productform.action="productupdate";
        productform.submit();
    }
    function del(){
    	productform.action="productdelete";
    	productform.submit();
    }
    function selectone(){
    	productform.action="productselectone";
    	productform.submit();
    }
    function selectlist(){
    	productform.action="productselectlist";
    	productform.submit();
    }
</script>
</head>
<body>
    <h1>상품등록</h1>
    <form action="" method="post" id="productform">
        <table>
            <tr>
                <td>상품번호</td>
                <td><input type="text" id="num" name="num" required="required"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" id="name" name="name" required="required"></td>
            </tr>
            <tr>
                <td>가격</td>
                <td><input type="text" id="price" name="price" required="required"></td>
            </tr>
            <tr>
                <td>수량</td>
                <td><input type="email" id="quantity" name="quantity" required="required"></td>
            </tr>
            
            <tr>
                <td colspan="2">
                    <input type="reset" value="초기화">
                    <input type="button" value="등록" onclick="insert()">
                    <input type="button" value="수정" onclick="update()">
                    <input type="button" value="삭제" onclick="del()">
                    <input type="button" value="상품 정보 조회" onclick="selectone()">
                    <input type="button" value="전체 상품 조회" onclick="selectlist()">    
                </td>
                
                
            </tr>
        
        </table>
    </form>
</body>
</html>