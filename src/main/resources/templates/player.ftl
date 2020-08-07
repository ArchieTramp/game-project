<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>

<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Игрок
    </div>
    <table>
        <table border="0">
            <tr>
                <td>Id</td>
                <td>:</td>
                <td>${player.id}</td>
            </tr>
            <tr>
                <td>NickName</td>
                <td>:</td>
                <td>${player.nickName}</td>
            </tr>
            <tr>
                <td>Level</td>
                <td>:</td>
                <td>${player.level}</td>
            </tr>
            <tr>
                <#if player.bandit ??>
                    <td>Banditos</td>
                    <td>:</td>
                    <td>${player.bandit}</td>
                <#else>
                    <td>Нет доступных бандитов</td>
                </#if>

            </tr>
        </table>

        <br/><br/>

        <form action="${'/start'}" method="get">Начать игру <input type="submit" value="Yes"/></form>
        <form action="${'/creatplayer/delete'}" method="post">Удалить игрока <input type="submit" value="Delete"/></form>

</div>

<a href="/">Вернуться на главную страницу</a>

</body>
</html>