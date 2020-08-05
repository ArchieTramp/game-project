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

<div class="form-style-2">
    <div class="form-style-2-heading">
        Создайте игрового персонажа.
    </div>
    <form method="post" action="/">
        <br>
        <label for="nick-name">NickName
            <input class="input-field" id="nick-name" name="nickName">
            <#if message??>
                <div class="alert alert-danger" role="alert">${message}</div>
            </#if>
            <#if messageNickName??>
                <div class="alert alert-danger" role="alert">${messageNickName}</div>
            </#if>
        </label>
        <br>
        <input type="submit" value="Создать">
        <br>
    </form>
</div>

<a href="/users">Для администратора</a>
<p></p>
<a href="/start">Начать игру</a>
<p></p>
<a href="/logout">Выход</a>
</body>
</html>