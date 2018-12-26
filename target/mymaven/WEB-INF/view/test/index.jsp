<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h2>test's index</h2>
<br/>
${test.id}<br/>
${test.context}<br/>
${test.viewCount}
${data.datas}
</body>


<script>
    var data = ${data.Datas};
    <%--var data = JSON.parse('${data.Datas}');--%>
    for (int i=0;i<data.length;i++){
        alert(data[i].context);
    }


</script>
</html>