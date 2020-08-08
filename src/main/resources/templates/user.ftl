<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>

<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Пользователь
    </div>
    <table>
        <table border="0">
            <tr>
                <td>Id</td>
                <td>:</td>
                <td>${user.id}</td>
            </tr>
            <tr>
                <td>LastName</td>
                <td>:</td>
                <td>${user.lastName}</td>
            </tr>
            <tr>
                <td>FirstName</td>
                <td>:</td>
                <td>${user.firstName}</td>
            </tr>
            <tr>
                <td>State</td>
                <td>:</td>
                <td>${user.state}</td>
            </tr>
        </table>

        <br/><br/>

        <form action="${'/users/' + user.id}" method="post">
            Забанить этого пользователя? <input type="submit" value="Yes"/>
            <#if message??>
                <div class="alert alert-danger" role="alert">${message}</div>
            </#if>
        </form>

        <form action="${'/users/restore/' + user.id}" method="post">
        Восстановить этого пользователя? <input type="submit" value="Yes"/>
            <#if message1??>
                <div class="alert alert-danger" role="alert">${message1}</div>
            </#if>
        </form>
</div>

<a href="/users">Вернуться к списку пользователей</a>

</body>
</html>