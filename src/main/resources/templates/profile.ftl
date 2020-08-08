<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="form-style-2-heading">Имя пользователя: ${user.firstName}</div>
<div class="form-style-2-heading">Фамилия пользователя: ${user.lastName}</div>
<div class="form-style-2">Доступные игровые персонажи пользователя:
    <div class="form-style-2-heading">
        <#if players??>
            <#list players as player>
                <tr>
                    <br>
                    <td>${player.nickName}</td>
                    <td><a href="${'/' + player.id}">Выбрать игрока</a></td>
                    <br>
                </tr>
            <#else>
                Нет доступных игроков
            </#list>
        </#if>
    </div>
</div>
<a href="/creatplayer">Создать игрового персонажа</a>
<p></p>
<a href="/users">Для администратора</a>
<p></p>
<#--<a href="/start">Начать игру</a>-->
<#--<p></p>-->
<a href="/logout">Выход</a>
</body>
</html>