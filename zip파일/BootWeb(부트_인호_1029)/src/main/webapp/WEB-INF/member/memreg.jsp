<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
<script type="text/javascript">
    function insert(){
        memform.action="meminsert";
        memform.submit();
    }
    function update(){
        memform.action="memupdate";
        memform.submit();
    }
    function del(){
        memform.action="memdelete";
        memform.submit();
    }
    function selectone(){
        memform.action="memselectone";
        memform.submit();
    }
    function selectlist(){
        memform.action="memselectall";
        memform.submit();
    }
</script>
</head>
<body>
    <h1> 회원등록</h1>
    <form action="" method="post" id="memform">
        <table>
            <tr>
                <td>id</td>
                <td><input type="text" id="id" name="id" required="required"></td>
            </tr>
            <tr>
                <td>pw</td>
                <td><input type="password" id="pw" name="pw" required="required"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" id="name" name="name" required="required"></td>
            </tr>
            <tr>
                <td>email</td>
                <td><input type="email" id="email" name="email" required="required"></td>
            </tr>
            
            <tr>
                <td colspan="2">
                    <input type="reset" value="초기화">
                    <input type="button" value="등록" onclick="insert()">
                    <input type="button" value="수정" onclick="update()">
                    <input type="button" value="삭제" onclick="del()">
                    <input type="button" value="한개" onclick="selectone()">
                    <input type="button" value="전체" onclick="selectlist()">    
                </td>
                
                
            </tr>
        
        </table>
    </form>
</body>
</html>